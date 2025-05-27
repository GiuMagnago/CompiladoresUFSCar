/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t4;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.Tipot4Sintaxe;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Giuseppe
 */
public class t4Semantico extends t4SintaxeBaseVisitor<Void> {

    // Representa a tabela de símbolos atual em uso
    TabelaDeSimbolos escopoAtual;

    // Conjunto de escopos gerenciados em pilha
    static Escopos gerenciadorEscopos = new Escopos();

    // Armazena tipos dos parâmetros para funções e procedimentos
    static HashMap<String, ArrayList<Tipot4Sintaxe>> mapaFuncProc = new HashMap<>();

    // Armazena campos dos registros definidos
    HashMap<String, ArrayList<String>> estruturaRegistros = new HashMap<>();

    /**
     * Adiciona um símbolo à tabela de símbolos atual
     */
    public void adicionarSimbolo(String nome, String tipo, Token tokenNome, Token tokenTipo, TipoEntrada tipoEntrada) {
        TabelaDeSimbolos tabela = gerenciadorEscopos.obterEscopoAtual();

        // Remove ponteiro, se presente
        Tipot4Sintaxe tipoConvertido;
        if (tipo.charAt(0) == '^') tipo = tipo.substring(1);

        // Mapeia a string do tipo para o enum correspondente
        switch (tipo) {
            case "literal" -> tipoConvertido = Tipot4Sintaxe.LITERAL;
            case "inteiro" -> tipoConvertido = Tipot4Sintaxe.INTEIRO;
            case "real" -> tipoConvertido = Tipot4Sintaxe.REAL;
            case "logico" -> tipoConvertido = Tipot4Sintaxe.LOGICO;
            case "void" -> tipoConvertido = Tipot4Sintaxe.VOID;
            case "registro" -> tipoConvertido = Tipot4Sintaxe.REGISTRO;
            default -> tipoConvertido = Tipot4Sintaxe.INVALIDO;
        }

        // Verifica se o tipo foi declarado
        if (tipoConvertido == Tipot4Sintaxe.INVALIDO)
            t4SemanticoUtils.adicionaErroSemantico(tokenTipo, "tipo " + tipo + " nao declarado");

        // Adiciona o símbolo se não houver duplicidade
        if (!tabela.existe(nome))
            tabela.adicionar(nome, tipoConvertido, tipoEntrada);
        else
            t4SemanticoUtils.adicionaErroSemantico(tokenNome, "identificador " + nome + " ja declarado anteriormente");
    }

    @Override
    public Void visitPrograma(t4SintaxeParser.ProgramaContext ctx) {
        // Verifica uso inválido de 'retorne' no escopo principal
        for (var comando : ctx.corpo().cmd()) {
            if (comando.cmdRetorne() != null)
                t4SemanticoUtils.adicionaErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");
        }
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_local(t4SintaxeParser.Declaracao_localContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        String tipo, nome;

        // Trata declaração de variáveis
        if (ctx.getText().contains("declare")) {
            if (ctx.variavel().tipo().registro() != null) {
                // Declaração de registro inline
                for (var ident : ctx.variavel().identificador()) {
                    adicionarSimbolo(ident.getText(), "registro", ident.getStart(), null, TipoEntrada.VARIAVEL);
                    for (var varReg : ctx.variavel().tipo().registro().variavel()) {
                        tipo = varReg.tipo().getText();
                        for (var idReg : varReg.identificador()) {
                            adicionarSimbolo(ident.getText() + "." + idReg.getText(), tipo, idReg.getStart(), varReg.tipo().getStart(), TipoEntrada.VARIAVEL);
                        }
                    }
                }
            } else {
                // Declaração de variável comum ou baseada em tipo registro
                tipo = ctx.variavel().tipo().getText();
                if (estruturaRegistros.containsKey(tipo)) {
                    ArrayList<String> camposRegistro = estruturaRegistros.get(tipo);
                    for (var ident : ctx.variavel().identificador()) {
                        nome = ident.IDENT().get(0).getText();
                        if (escopoAtual.existe(nome) || estruturaRegistros.containsKey(nome)) {
                            t4SemanticoUtils.adicionaErroSemantico(ident.getStart(), "identificador " + nome + " ja declarado anteriormente");
                        } else {
                            adicionarSimbolo(nome, "registro", ident.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                            for (int i = 0; i < camposRegistro.size(); i += 2) {
                                adicionarSimbolo(nome + "." + camposRegistro.get(i), camposRegistro.get(i + 1), ident.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                            }
                        }
                    }
                } else {
                    // Declaração de tipo primitivo ou não-estruturado
                    for (var ident : ctx.variavel().identificador()) {
                        nome = ident.getText();
                        if (mapaFuncProc.containsKey(nome)) {
                            t4SemanticoUtils.adicionaErroSemantico(ident.getStart(), "identificador " + nome + " ja declarado anteriormente");
                        } else {
                            adicionarSimbolo(nome, tipo, ident.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                        }
                    }
                }
            }
        } else if (ctx.getText().contains("tipo")) {
            // Declaração de tipo (registro)
            if (ctx.tipo().registro() != null) {
                ArrayList<String> campos = new ArrayList<>();
                for (var varReg : ctx.tipo().registro().variavel()) {
                    tipo = varReg.tipo().getText();
                    for (var ident : varReg.identificador()) {
                        campos.add(ident.getText());
                        campos.add(tipo);
                    }
                }
                estruturaRegistros.put(ctx.IDENT().getText(), campos);
            }
        } else if (ctx.getText().contains("constante")) {
            // Declaração de constante
            adicionarSimbolo(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), TipoEntrada.VARIAVEL);
        }
        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitDeclaracao_global(t4SintaxeParser.Declaracao_globalContext ctx) {
        gerenciadorEscopos.criarNovoEscopo();
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        ArrayList<Tipot4Sintaxe> listaTipos = new ArrayList<>();
        ArrayList<String> campos;
        String tipo;

        // Verifica e registra os parâmetros da função ou procedimento
        for (var param : ctx.parametros().parametro()) {
            if (param.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                adicionarSimbolo(param.identificador().get(0).getText(), param.tipo_estendido().getText(), param.getStart(), param.getStart(), TipoEntrada.VARIAVEL);
                tipo = param.tipo_estendido().getText();
                listaTipos.add(t4SemanticoUtils.confereTipo(estruturaRegistros, tipo));
            } else if (estruturaRegistros.containsKey(param.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                campos = estruturaRegistros.get(param.tipo_estendido().tipo_basico_ident().IDENT().getText());
                tipo = param.tipo_estendido().getText();
                listaTipos.add(t4SemanticoUtils.confereTipo(estruturaRegistros, tipo));
                for (var ident : param.identificador()) {
                    for (int i = 0; i < campos.size(); i += 2) {
                        adicionarSimbolo(ident.getText() + "." + campos.get(i), campos.get(i + 1), ident.getStart(), ident.getStart(), TipoEntrada.VARIAVEL);
                    }
                }
            } else {
                t4SemanticoUtils.adicionaErroSemantico(param.getStart(), "tipo nao declarado");
            }
        }

        // Trata declaração de procedimento
        if (ctx.getText().contains("procedimento")) {
            for (var comando : ctx.cmd()) {
                if (comando.cmdRetorne() != null)
                    t4SemanticoUtils.adicionaErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");
            }
            mapaFuncProc.put(ctx.IDENT().getText(), listaTipos);
        } else if (ctx.getText().contains("funcao")) {
            mapaFuncProc.put(ctx.IDENT().getText(), listaTipos);
        }

        // Visita comandos internos e finaliza escopo
        super.visitDeclaracao_global(ctx);
        gerenciadorEscopos.abandonarEscopo();

        // Registra o nome da função ou procedimento
        if (ctx.getText().contains("procedimento"))
            adicionarSimbolo(ctx.IDENT().getText(), "void", ctx.getStart(), ctx.getStart(), TipoEntrada.PROCEDIMENTO);
        else if (ctx.getText().contains("funcao"))
            adicionarSimbolo(ctx.IDENT().getText(), ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.getStart(), ctx.getStart(), TipoEntrada.FUNCAO);

        return null;
    }

    @Override
    public Void visitCmdLeia(t4SintaxeParser.CmdLeiaContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        // Verifica se os identificadores lidos foram declarados
        for (var id : ctx.identificador()) {
            if (!escopoAtual.existe(id.getText()))
                t4SemanticoUtils.adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");
        }
        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(t4SintaxeParser.CmdEscrevaContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        // Verifica o tipo de cada expressão a ser escrita
        for (var expressao : ctx.expressao()) {
            t4SemanticoUtils.verificarTipo(escopoAtual, expressao);
        }
        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(t4SintaxeParser.CmdEnquantoContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        // Verifica o tipo da expressão condicional
        t4SemanticoUtils.verificarTipo(escopoAtual, ctx.expressao());
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdSe(t4SintaxeParser.CmdSeContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        // Verifica o tipo da condição do comando 'se'
        t4SemanticoUtils.verificarTipo(escopoAtual, ctx.expressao());
        return super.visitCmdSe(ctx);
    }

    @Override
    public Void visitCmdAtribuicao(t4SintaxeParser.CmdAtribuicaoContext ctx) {
        escopoAtual = gerenciadorEscopos.obterEscopoAtual();
        Tipot4Sintaxe tipoExpr = t4SemanticoUtils.verificarTipo(escopoAtual, ctx.expressao());
        String nomeVar = ctx.identificador().getText();

        // Verifica compatibilidade de tipos na atribuição
        if (tipoExpr != Tipot4Sintaxe.INVALIDO) {
            if (!escopoAtual.existe(nomeVar)) {
                t4SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + nomeVar + " nao declarado");
            } else {
                Tipot4Sintaxe tipoVar = t4SemanticoUtils.verificarTipo(escopoAtual, nomeVar);
                if (tipoVar == Tipot4Sintaxe.INTEIRO || tipoVar == Tipot4Sintaxe.REAL) {
                    if (ctx.getText().contains("ponteiro")) {
                        if (!t4SemanticoUtils.verificaCompatibilidade(tipoVar, tipoExpr) && tipoExpr != Tipot4Sintaxe.INTEIRO)
                            t4SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + nomeVar);
                    } else if (!t4SemanticoUtils.verificaCompatibilidade(tipoVar, tipoExpr) && tipoExpr != Tipot4Sintaxe.INTEIRO) {
                        t4SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + nomeVar);
                    }
                } else if (tipoVar != tipoExpr) {
                    t4SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + nomeVar);
                }
            }
        }
        return super.visitCmdAtribuicao(ctx);
    }
}