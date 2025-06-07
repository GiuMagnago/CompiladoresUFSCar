/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t5;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.Tipot5Sintaxe;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Giuseppe
 */
public class t5Semantico extends t5SintaxeBaseVisitor<Void> {

    // Escopo atual utilizado para a análise semântica
    TabelaDeSimbolos tabela;

    // Pilha de escoposAninhados utilizados durante a análise
    static Escopos escoposAninhados = new Escopos();

    // Mapeia nomes de funções e procedimentos com suas respectivas listas de tipos de parâmetros
    static HashMap<String, ArrayList<Tipot5Sintaxe>> dadosFuncaoProcedimento = new HashMap<>();

    // Registra os tipos e nomes de campos dos registros
    HashMap<String, ArrayList<String>> tabelaRegistro = new HashMap<>();

    // Adiciona símbolo à tabela de símbolos do escopo atual
    public void registrarSimbolo(String ident, String tipo, Token tokenIdent, Token tokenTipo, TipoEntrada categoria) {
        TabelaDeSimbolos tabelaEscopo = escoposAninhados.obterEscopoAtual();
        Tipot5Sintaxe tipoEnum;

        if (tipo.startsWith("^")) tipo = tipo.substring(1);

        switch (tipo) {
            case "literal": tipoEnum = Tipot5Sintaxe.LITERAL; break;
            case "inteiro": tipoEnum = Tipot5Sintaxe.INTEIRO; break;
            case "real": tipoEnum = Tipot5Sintaxe.REAL; break;
            case "logico": tipoEnum = Tipot5Sintaxe.LOGICO; break;
            case "void": tipoEnum = Tipot5Sintaxe.VOID; break;
            case "registro": tipoEnum = Tipot5Sintaxe.REGISTRO; break;
            default: tipoEnum = Tipot5Sintaxe.INVALIDO; break;
        }

        if (tipoEnum == Tipot5Sintaxe.INVALIDO)
            t5SemanticoUtils.adicionaErroSemantico(tokenTipo, "tipo " + tipo + " nao declarado");

        if (!tabelaEscopo.existe(ident))
            tabelaEscopo.adicionar(ident, tipoEnum, categoria);
        else
            t5SemanticoUtils.adicionaErroSemantico(tokenIdent, "identificador " + ident + " ja declarado anteriormente");
    }

    @Override
    public Void visitPrograma(t5SintaxeParser.ProgramaContext ctx) {
        for (t5SintaxeParser.CmdContext comando : ctx.corpo().cmd())
            if (comando.cmdRetorne() != null)
                t5SemanticoUtils.adicionaErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");

        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitCorpo(t5SintaxeParser.CorpoContext ctx) {
        super.visitCorpo(ctx);
        return null;
    }

    @Override
    public Void visitDeclaracao_local(t5SintaxeParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        String tipoVar;
        String nomeVar;

        if (ctx.getText().contains("declare")) {
            if (ctx.variavel().tipo().registro() != null) {
                for (t5SintaxeParser.IdentificadorContext id : ctx.variavel().identificador()) {
                    registrarSimbolo(id.getText(), "registro", id.getStart(), null, TipoEntrada.VARIAVEL);

                    for (t5SintaxeParser.VariavelContext var : ctx.variavel().tipo().registro().variavel()) {
                        tipoVar = var.tipo().getText();
                        for (t5SintaxeParser.IdentificadorContext campo : var.identificador()) {
                            registrarSimbolo(id.getText() + "." + campo.getText(), tipoVar, campo.getStart(), var.tipo().getStart(), TipoEntrada.VARIAVEL);
                        }
                    }
                }
            } else {
                tipoVar = ctx.variavel().tipo().getText();

                if (tabelaRegistro.containsKey(tipoVar)) {
                    ArrayList<String> campos = tabelaRegistro.get(tipoVar);
                    for (t5SintaxeParser.IdentificadorContext id : ctx.variavel().identificador()) {
                        nomeVar = id.IDENT().get(0).getText();

                        if (tabela.existe(nomeVar) || tabelaRegistro.containsKey(nomeVar)) {
                            t5SemanticoUtils.adicionaErroSemantico(id.getStart(), "identificador " + nomeVar + " ja declarado anteriormente");
                        } else {
                            registrarSimbolo(nomeVar, "registro", id.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                            for (int i = 0; i < campos.size(); i += 2) {
                                registrarSimbolo(nomeVar + "." + campos.get(i), campos.get(i + 1), id.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                            }
                        }
                    }
                } else {
                    for (t5SintaxeParser.IdentificadorContext id : ctx.variavel().identificador()) {
                        nomeVar = id.getText();
                        if (dadosFuncaoProcedimento.containsKey(nomeVar))
                            t5SemanticoUtils.adicionaErroSemantico(id.getStart(), "identificador " + nomeVar + " ja declarado anteriormente");
                        else
                            registrarSimbolo(nomeVar, tipoVar, id.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                    }
                }
            }
        } else if (ctx.getText().contains("tipo")) {
            if (ctx.tipo().registro() != null) {
                ArrayList<String> campos = new ArrayList<>();
                for (t5SintaxeParser.VariavelContext var : ctx.tipo().registro().variavel()) {
                    tipoVar = var.tipo().getText();
                    for (t5SintaxeParser.IdentificadorContext id : var.identificador()) {
                        campos.add(id.getText());
                        campos.add(tipoVar);
                    }
                }
                tabelaRegistro.put(ctx.IDENT().getText(), campos);
            }
        } else if (ctx.getText().contains("constante")) {
            registrarSimbolo(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), TipoEntrada.VARIAVEL);
        }

        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitDeclaracao_global(t5SintaxeParser.Declaracao_globalContext ctx) {
        escoposAninhados.criarNovoEscopo();
        tabela = escoposAninhados.obterEscopoAtual();

        ArrayList<Tipot5Sintaxe> tiposParams = new ArrayList<>();
        ArrayList<String> camposRegistro;
        String tipoParam;
        Tipot5Sintaxe tipoTemp;

        for (t5SintaxeParser.ParametroContext param : ctx.parametros().parametro()) {
            if (param.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                registrarSimbolo(param.identificador().get(0).getText(), param.tipo_estendido().getText(), param.getStart(), param.getStart(), TipoEntrada.VARIAVEL);
                tipoParam = param.tipo_estendido().getText();
                tipoTemp = t5SemanticoUtils.confereTipo(tabelaRegistro, tipoParam);
                tiposParams.add(tipoTemp);
            } else if (tabelaRegistro.containsKey(param.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                camposRegistro = tabelaRegistro.get(param.tipo_estendido().tipo_basico_ident().IDENT().getText());
                tipoParam = param.tipo_estendido().getText();
                tipoTemp = t5SemanticoUtils.confereTipo(tabelaRegistro, tipoParam);
                tiposParams.add(tipoTemp);

                for (t5SintaxeParser.IdentificadorContext id : param.identificador()) {
                    for (int i = 0; i < camposRegistro.size(); i += 2) {
                        registrarSimbolo(id.getText() + "." + camposRegistro.get(i), camposRegistro.get(i + 1), id.getStart(), id.getStart(), TipoEntrada.VARIAVEL);
                    }
                }
            } else {
                t5SemanticoUtils.adicionaErroSemantico(param.getStart(), "tipo nao declarado");
            }
        }

        if (ctx.getText().contains("procedimento")) {
            for (t5SintaxeParser.CmdContext comando : ctx.cmd()) {
                if (comando.cmdRetorne() != null) {
                    t5SemanticoUtils.adicionaErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");
                }
            }
            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposParams);
        } else if (ctx.getText().contains("funcao")) {
            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposParams);
        }

        super.visitDeclaracao_global(ctx);
        escoposAninhados.abandonarEscopo();

        if (ctx.getText().contains("procedimento"))
            registrarSimbolo(ctx.IDENT().getText(), "void", ctx.getStart(), ctx.getStart(), TipoEntrada.PROCEDIMENTO);
        else if (ctx.getText().contains("funcao"))
            registrarSimbolo(ctx.IDENT().getText(), ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.getStart(), ctx.getStart(), TipoEntrada.FUNCAO);

        return null;
    }

    @Override
    public Void visitCmdLeia(t5SintaxeParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        for (t5SintaxeParser.IdentificadorContext id : ctx.identificador()) {
            if (!tabela.existe(id.getText()))
                t5SemanticoUtils.adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");
        }
        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(t5SintaxeParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        for (t5SintaxeParser.ExpressaoContext expr : ctx.expressao()) {
            t5SemanticoUtils.verificarTipo(tabela, expr);
        }
        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(t5SintaxeParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        t5SemanticoUtils.verificarTipo(tabela, ctx.expressao());
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdSe(t5SintaxeParser.CmdSeContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        t5SemanticoUtils.verificarTipo(tabela, ctx.expressao());
        return super.visitCmdSe(ctx);
    }

    @Override
    public Void visitCmdAtribuicao(t5SintaxeParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        Tipot5Sintaxe tipoExpr = t5SemanticoUtils.verificarTipo(tabela, ctx.expressao());
        String nomeVar = ctx.identificador().getText();

        if (tipoExpr != Tipot5Sintaxe.INVALIDO) {
            if (!tabela.existe(nomeVar)) {
                t5SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + nomeVar + " nao declarado");
            } else {
                Tipot5Sintaxe tipoVar = t5SemanticoUtils.verificarTipo(tabela, nomeVar);

                if (tipoVar == Tipot5Sintaxe.INTEIRO || tipoVar == Tipot5Sintaxe.REAL) {
                    if (ctx.getText().contains("ponteiro")) {
                        if (!t5SemanticoUtils.verificaCompatibilidade(tipoVar, tipoExpr) && tipoExpr != Tipot5Sintaxe.INTEIRO)
                            t5SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + nomeVar);
                    } else if (!t5SemanticoUtils.verificaCompatibilidade(tipoVar, tipoExpr) && tipoExpr != Tipot5Sintaxe.INTEIRO) {
                        t5SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + nomeVar);
                    }
                } else if (tipoVar != tipoExpr) {
                    t5SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + nomeVar);
                }
            }
        }

        return super.visitCmdAtribuicao(ctx);
    }
}
