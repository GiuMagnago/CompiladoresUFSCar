/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t5;

import static br.ufscar.dc.compiladores.t5.t5SemanticoUtils.verificarTipo;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.Tipot5Sintaxe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Giuseppe
 */
public class GeraC extends t5SintaxeBaseVisitor<Void> {
    // String que receberá o programa em C ao longo da análise.

    StringBuilder saida = new StringBuilder();

// Criação da tabela principal e inicialização de escopos.
    TabelaDeSimbolos tabela = new TabelaDeSimbolos();
    Escopos escopos = new Escopos();
    static Escopos escoposAninhados = new Escopos();

// Mapas auxiliares para conversão de tipos
    private static final Map<Tipot5Sintaxe, String> tipoT5ParaC = Map.of(
            Tipot5Sintaxe.INTEIRO, "int",
            Tipot5Sintaxe.LITERAL, "char",
            Tipot5Sintaxe.REAL, "float"
    );

    private static final Map<String, Tipot5Sintaxe> stringParaTipot5Sintaxe = Map.of(
            "literal", Tipot5Sintaxe.LITERAL,
            "inteiro", Tipot5Sintaxe.INTEIRO,
            "real", Tipot5Sintaxe.REAL,
            "logico", Tipot5Sintaxe.LOGICO
    );

    private static final Map<String, String> tipoCParaFormato = Map.of(
            "int", "d",
            "float", "f",
            "char", "s"
    );

// Conversão de Tipot5Sintaxe para tipo em C
    public String converteTipo(Tipot5Sintaxe tipoAuxT5) {
        return tipoT5ParaC.get(tipoAuxT5);
    }

// Conversão de string para Tipot5Sintaxe
    public Tipot5Sintaxe converteTipot5Sintaxe(String tipo) {
        return stringParaTipot5Sintaxe.getOrDefault(tipo, Tipot5Sintaxe.INVALIDO);
    }

// Verifica tipo C equivalente a uma string
    public String verificaTipoC(String tipo) {
        return converteTipo(converteTipot5Sintaxe(tipo));
    }

// Retorna o especificador de formato C para um tipo em C
    public String verificaParamTipo(String tipo) {
        return tipoCParaFormato.get(tipo);
    }

// Retorna o especificador de formato C para um Tipot5Sintaxe
    public String verificaParamTipot5Sintaxe(Tipot5Sintaxe tipoAuxT5) {
        return verificaParamTipo(converteTipo(tipoAuxT5));
    }

// Verifica a existência de um tipo na tabela
    public boolean verificaTipoTabela(TabelaDeSimbolos tabela, String tipo) {
        return tabela.existe(tipo);
    }

// Extrai os limites de um comando 'caso'
    public String getLimitesCaso(String str, boolean ehEsquerda) {
        int pontoIndex = str.indexOf(".");
        if (pontoIndex == -1) {
            return str;
        }
        return ehEsquerda ? str.substring(0, pontoIndex) : str.substring(pontoIndex + 2);
    }

// Separa argumentos de uma expressão relacional
    public String separaArg(String total, int valor) {
        total = total.substring(1); // remove o primeiro caractere
        int cont = 0;

        // Encontrar início do operador
        while (cont < total.length()
                && !(total.startsWith("=", cont) || total.startsWith("<>", cont))) {
            cont++;
        }

        if (valor == 0) {
            return total.substring(0, cont);
        }

        // Pula o operador e busca o fim do segundo argumento
        int inicioArg2 = cont + (total.startsWith("<>", cont) ? 2 : 1);
        int fimArg2 = total.indexOf(")", inicioArg2);
        return total.substring(inicioArg2, fimArg2);
    }

    public String separaExp(String total, int valor) {
        int cont = 0;
        while (cont < total.length() && !"+-*/".contains(String.valueOf(total.charAt(cont)))) {
            cont++;
        }
        return valor == 0 ? total.substring(0, cont) : total.substring(cont + 1);
    }

    public String verificaOp(String total) {
        for (char op : new char[]{'+', '-', '*', '/'}) {
            if (total.indexOf(op) != -1) {
                return String.valueOf(op);
            }
        }
        return null;
    }

    @Override
    public Void visitPrograma(t5SintaxeParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n#include <stdlib.h>\n\n");
        visitDeclaracoes(ctx.declaracoes());
        saida.append("\nint main() {\n");
        visitCorpo(ctx.corpo());
        saida.append("\nreturn 0;\n}\n");
        return null;
    }

    @Override
    public Void visitDeclaracao_local(t5SintaxeParser.Declaracao_localContext ctx) {
        String nomeIdentificador = ctx.IDENT() != null ? ctx.IDENT().getText() : "";

        if (ctx.valor_constante() != null) {
            // Declaração de constante
            String valorConstante = ctx.valor_constante().getText();
            saida.append(String.format("#define %s %s\n", nomeIdentificador, valorConstante));

        } else if (ctx.tipo() != null) {
            // Declaração de novo tipo (registro)
            TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
            escopos.criarNovoEscopo();

            saida.append("typedef struct {\n");
            super.visitRegistro(ctx.tipo().registro());
            saida.append(String.format("} %s;\n", nomeIdentificador));

            escopos.abandonarEscopo();
            escopoAtual.adicionar(nomeIdentificador, Tipot5Sintaxe.REGISTRO, TipoEntrada.VARIAVEL);

        } else if (ctx.variavel() != null) {
            // Declaração de variável comum
            visitVariavel(ctx.variavel());
        }

        return null;
    }

    @Override
    public Void visitVariavel(t5SintaxeParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        String tipoTexto = ctx.tipo().getText();

        // Caso seja um tipo estendido (registro já definido ou novo registro).
        if (ctx.tipo().tipo_estendido() != null) {
            String tipoBase = tipoTexto.replace("^", "");
            boolean ehPonteiro = tipoTexto.contains("^");
            boolean tipoEstendido = verificaTipoTabela(escopoAtual, tipoBase);

            Tipot5Sintaxe tipoT5 = tipoEstendido ? Tipot5Sintaxe.TIPOESTENDIDO : converteTipot5Sintaxe(tipoBase);
            String tipoFinal = tipoEstendido ? tipoBase : converteTipo(tipoT5);
            if (ehPonteiro) {
                tipoFinal += "*";
            }

            for (t5SintaxeParser.IdentificadorContext idCtx : ctx.identificador()) {
                String nomeVar = idCtx.getText();

                Tipot5Sintaxe tipoRegistroOuBasico = tipoEstendido ? Tipot5Sintaxe.REGISTRO : tipoT5;
                escopoAtual.adicionar(nomeVar, tipoRegistroOuBasico, TipoEntrada.VARIAVEL);

                if (tipoT5 == Tipot5Sintaxe.LITERAL) {
                    saida.append(String.format("%s %s[80];\n", tipoFinal, nomeVar));
                } else {
                    saida.append(String.format("%s %s;\n", tipoFinal, nomeVar));
                }
            }

        } else { // Declaração de um novo registro
            // Cria escopo para variáveis internas do registro
            escopos.criarNovoEscopo();
            saida.append("struct{\n");

            for (t5SintaxeParser.VariavelContext varCtx : ctx.tipo().registro().variavel()) {
                visitVariavel(varCtx);
            }

            String nomeRegistro = ctx.identificador(0).getText();
            saida.append(String.format("}%s;\n", nomeRegistro));

            // Fecha escopo e adiciona o novo tipo no escopo atual
            escopos.abandonarEscopo();
            escopoAtual.adicionar(nomeRegistro, Tipot5Sintaxe.REGISTRO, TipoEntrada.VARIAVEL);
        }

        return null;
    }

    @Override
    public Void visitDeclaracao_global(t5SintaxeParser.Declaracao_globalContext ctx) {
        TabelaDeSimbolos escopoGlobal = escopos.obterEscopoAtual();
        escopos.criarNovoEscopo();
        TabelaDeSimbolos escopoParametros = escopos.obterEscopoAtual();

        String nomeFuncao = ctx.IDENT().getText();
        String tipoRetorno = (ctx.tipo_estendido() != null)
                ? verificaTipoC(ctx.tipo_estendido().getText())
                : "void";

        saida.append(tipoRetorno).append(" ").append(nomeFuncao).append("(");

        // Processa parâmetros, se houver
        if (ctx.parametros() != null) {
            List<t5SintaxeParser.ParametroContext> parametros = ctx.parametros().parametro();
            for (int i = 0; i < parametros.size(); i++) {
                t5SintaxeParser.ParametroContext pctx = parametros.get(i);
                String tipoParametro = verificaTipoC(pctx.tipo_estendido().getText());
                if (tipoParametro.equals("char")) {
                    tipoParametro = "char*";
                }

                StringBuilder nomes = new StringBuilder();
                for (int j = 0; j < pctx.identificador().size(); j++) {
                    String nomeVar = pctx.identificador(j).getText();
                    escopoParametros.adicionar(nomeVar,
                            converteTipot5Sintaxe(pctx.tipo_estendido().getText()),
                            TipoEntrada.VARIAVEL);

                    nomes.append(nomeVar);
                    if (j < pctx.identificador().size() - 1) {
                        nomes.append(", ");
                    }
                }

                saida.append(String.format("%s %s", tipoParametro, nomes.toString()));
                if (i < parametros.size() - 1) {
                    saida.append(", ");
                }
            }
        }

        saida.append(") {\n");

        // Registra função ou procedimento no escopo global
        if (ctx.tipo_estendido() != null) {
            escopoGlobal.adicionar(nomeFuncao,
                    converteTipot5Sintaxe(ctx.tipo_estendido().getText()),
                    TipoEntrada.FUNCAO);
        } else {
            escopoGlobal.adicionar(nomeFuncao, Tipot5Sintaxe.VOID, TipoEntrada.PROCEDIMENTO);
        }

        // Executa comandos internos da função/procedimento
        for (t5SintaxeParser.CmdContext cmd : ctx.cmd()) {
            visitCmd(cmd);
        }

        saida.append("}\n");
        escopos.abandonarEscopo();
        return null;
    }

    @Override
    public Void visitParcela_unario(t5SintaxeParser.Parcela_unarioContext ctx) {
        if (!ctx.expressao().get(0).getText().contains("(")) {
            saida.append(ctx.getText());
        } else {
            saida.append("(");
            super.visitParcela_unario(ctx);
            saida.append(")");
        }
        return null;
    }

    @Override
    public Void visitParcela_nao_unario(t5SintaxeParser.Parcela_nao_unarioContext ctx) {
        if (ctx.identificador() != null) {
            saida.append(ctx.identificador().getText());
        }
        return super.visitParcela_nao_unario(ctx);
    }

    @Override
    public Void visitOp_relacional(t5SintaxeParser.Op_relacionalContext ctx) {
        String str = ctx.getText().equals("=") ? "==" : ctx.getText();
        saida.append(str);
        return super.visitOp_relacional(ctx);
    }

    @Override
    public Void visitCmdRetorne(t5SintaxeParser.CmdRetorneContext ctx) {
        saida.append("return ");
        super.visitExpressao(ctx.expressao());
        saida.append(";\n");
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(t5SintaxeParser.CmdAtribuicaoContext ctx) {
        String ident = ctx.identificador().getText();
        String expr = ctx.expressao().getText();

        if (ctx.getText().contains("^")) {
            saida.append("*").append(ident).append(" = ").append(expr).append(";\n");
        } else if (ident.contains(".") && ctx.getText().contains("\"")) {
            saida.append("strcpy(").append(ident).append(",").append(expr).append(");\n");
        } else {
            saida.append(ident).append(" = ").append(expr).append(";\n");
        }

        return null;
    }

    @Override
    public Void visitExpressao(t5SintaxeParser.ExpressaoContext ctx) {
        if (ctx.termo_logico().size() > 1) {
            boolean primeiro = true;
            for (t5SintaxeParser.Termo_logicoContext termo : ctx.termo_logico()) {
                if (!primeiro) {
                    saida.append(" || ");
                }
                visitTermo_logico(termo);
                primeiro = false;
            }
        } else {
            visitTermo_logico(ctx.termo_logico(0));
        }

        return null;
    }

    @Override
    public Void visitTermo_logico(t5SintaxeParser.Termo_logicoContext ctx) {
        if (ctx.fator_logico().size() > 1) {
            boolean primeiro = true;
            for (t5SintaxeParser.Fator_logicoContext fator : ctx.fator_logico()) {
                if (!primeiro) {
                    saida.append(" && ");
                }
                visitFator_logico(fator);
                primeiro = false;
            }
        } else {
            visitFator_logico(ctx.fator_logico(0));
        }

        return null;
    }

    @Override
    public Void visitFator_logico(t5SintaxeParser.Fator_logicoContext ctx) {
        if (ctx.getText().contains("nao")) {
            saida.append("!");
        }

        visitParcela_logica(ctx.parcela_logica());
        return null;
    }

    @Override
    public Void visitOp2(t5SintaxeParser.Op2Context ctx) {
        saida.append(ctx.getText());
        return super.visitOp2(ctx);
    }

    @Override
    public Void visitParcela_logica(t5SintaxeParser.Parcela_logicaContext ctx) {
        if (ctx.getText().contains("falso")) {
            saida.append("false");
        } else if (ctx.getText().contains("verdadeiro")) {
            saida.append("true");
        } else {
            visitExp_relacional(ctx.exp_relacional());
        }

        return null;
    }

    @Override
    public Void visitExp_relacional(t5SintaxeParser.Exp_relacionalContext ctx) {
        String opAtual = ctx.getText();
        String expAtual = ctx.exp_aritmetica().get(0).getText();

        if (expAtual.contains("<>")) {
            opAtual = "<>";
        } else if (expAtual.contains("=")) {
            if (!expAtual.contains("<=") && !expAtual.contains(">=")) {
                opAtual = "=";
            }
        }

        if (ctx.op_relacional() != null) {
            saida.append(expAtual).append(ctx.op_relacional().getText()).append(ctx.exp_aritmetica(1).getText());
        } else {
            switch (opAtual) {
                case "=":
                    String arg1 = separaArg(expAtual, 0);
                    String arg2 = separaArg(expAtual, 1);
                    saida.append("(").append(arg1).append("==").append(arg2).append(")");
                    break;
                case "<>":
                    saida.append("!=");
                    break;
                default:
                    arg1 = separaExp(expAtual, 0);
                    arg2 = separaExp(expAtual, 1);
                    String op = verificaOp(opAtual);
                    saida.append(arg1).append(op).append(arg2);
                    break;
            }
        }

        return null;
    }

    @Override
    public Void visitCmdLeia(t5SintaxeParser.CmdLeiaContext ctx) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();

        for (t5SintaxeParser.IdentificadorContext ictx : ctx.identificador()) {
            String nomeVar = ictx.getText();
            Tipot5Sintaxe tipoAuxT5 = escopoAtual.verificar(nomeVar);
            String codigoTipo = verificaParamTipot5Sintaxe(tipoAuxT5);

            if (tipoAuxT5 == Tipot5Sintaxe.LITERAL) {
                saida.append("gets(").append(nomeVar).append(");\n");
            } else {
                saida.append("scanf(\"%").append(codigoTipo).append("\", &").append(nomeVar).append(");\n");
            }
        }

        return null;
    }

    @Override
    public Void visitCmdEscreva(t5SintaxeParser.CmdEscrevaContext ctx) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();

        for (t5SintaxeParser.ExpressaoContext ectx : ctx.expressao()) {
            saida.append("printf(\"");

            if (ectx.getText().contains("\"")) {
                String str = ectx.getText().replace("\"", "") + "\");\n";
                saida.append(str);
            } else {
                Tipot5Sintaxe tipoAuxT5Exp = verificarTipo(escopoAtual, ectx);
                String codTipoExp = verificaParamTipot5Sintaxe(tipoAuxT5Exp);

                if (tipoAuxT5Exp == Tipot5Sintaxe.LITERAL) {
                    saida.append("%s\", ").append(ectx.getText()).append(");\n");
                } else {
                    saida.append("%").append(codTipoExp).append("\", ").append(ectx.getText()).append(");\n");
                }
            }
        }

        return null;
    }

    @Override
    public Void visitCmdSe(t5SintaxeParser.CmdSeContext ctx) {
        String textoExpressao = ctx.expressao().getText().replace("e", "&&").replace("=", "==");

        saida.append("if (").append(textoExpressao).append("){\n");

        for (t5SintaxeParser.CmdContext cctx : ctx.cmdEntao) {
            super.visitCmd(cctx);
        }

        saida.append("}\n");

        if (ctx.getText().contains("senao")) {
            saida.append("else{\n");
            for (t5SintaxeParser.CmdContext cctx : ctx.cmdSenao) {
                super.visitCmd(cctx);
            }
            saida.append("}\n");
        }

        return null;
    }

    @Override
    public Void visitCmdEnquanto(t5SintaxeParser.CmdEnquantoContext ctx) {
        saida.append("while(");
        super.visitExpressao(ctx.expressao());
        saida.append("){\n");

        for (t5SintaxeParser.CmdContext cctx : ctx.cmd()) {
            super.visitCmd(cctx);
        }

        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdFaca(t5SintaxeParser.CmdFacaContext ctx) {
        saida.append("do{\n");

        for (t5SintaxeParser.CmdContext cctx : ctx.cmd()) {
            super.visitCmd(cctx);
        }

        saida.append("}while(");
        super.visitExpressao(ctx.expressao());
        saida.append(");\n");

        return null;
    }

    @Override
    public Void visitCmdPara(t5SintaxeParser.CmdParaContext ctx) {
        String nomeVariavel = ctx.IDENT().getText();
        String limiteEsq = ctx.exp_aritmetica(0).getText();
        String limiteDir = ctx.exp_aritmetica(1).getText();

        saida.append("for(").append(nomeVariavel).append(" = ").append(limiteEsq)
                .append("; ").append(nomeVariavel).append(" <= ").append(limiteDir)
                .append("; ").append(nomeVariavel).append("++){\n");

        for (t5SintaxeParser.CmdContext cctx : ctx.cmd()) {
            visitCmd(cctx);
        }

        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdCaso(t5SintaxeParser.CmdCasoContext ctx) {
        saida.append("switch (").append(ctx.exp_aritmetica().getText()).append("){\n");

        for (t5SintaxeParser.Item_selecaoContext sctx : ctx.selecao().item_selecao()) {
            String strOriginal = sctx.constantes().numero_intervalo(0).getText();
            String limiteEsq, limiteDir;

            if (strOriginal.contains(".")) {
                limiteEsq = getLimitesCaso(strOriginal, true);
                limiteDir = getLimitesCaso(strOriginal, false);
            } else {
                limiteEsq = limiteDir = getLimitesCaso(strOriginal, true);
            }

            for (int i = Integer.parseInt(limiteEsq); i <= Integer.parseInt(limiteDir); i++) {
                saida.append("case ").append(i).append(":\n");
            }

            for (t5SintaxeParser.CmdContext cctx : sctx.cmd()) {
                visitCmd(cctx);
            }

            saida.append("break;\n");
        }

        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdChamada(t5SintaxeParser.CmdChamadaContext ctx) {
        String str;
        str = ctx.IDENT().getText() + "(";
        saida.append(str);
        int contador = 0;
        
        for (t5SintaxeParser.ExpressaoContext ectx : ctx.expressao()) {
            if (contador >= 1) {
                saida.append(", ");
            }

            saida.append(ectx.getText());
            contador += 1;
        }
        saida.append(");\n");
        return null;
    }
}
