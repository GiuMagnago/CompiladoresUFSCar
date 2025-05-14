/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t3;

import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.Tipot3Sintaxe;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Giuseppe
 */
public class t3Semantico extends t3SintaxeBaseVisitor<Void> {
    TabelaDeSimbolos tabela;
    
    static Escopos escoposAninhados = new Escopos();
    
    TabelaDeSimbolos tabelaEscopo;

    // variável sendo analisada será adicionada na tabela
    public void adicionaVariavelTabela(String name, String type, Token nameT, Token typeT) {
        tabelaEscopo = escoposAninhados.obterEscopoAtual();

        Tipot3Sintaxe typeItem;

        typeItem = switch (type) {
            case "literal" -> Tipot3Sintaxe.LITERAL;
            case "inteiro" -> Tipot3Sintaxe.INTEIRO;
            case "real" -> Tipot3Sintaxe.REAL;
            case "logico" -> Tipot3Sintaxe.LOGICO;
            default -> Tipot3Sintaxe.INVALIDO;
        };

        if (typeItem == Tipot3Sintaxe.INVALIDO) {
            t3SemanticoUtils.adicionaErroSemantico(typeT, "tipo " + type + " nao declarado");
        }
        
        if (!tabelaEscopo.existe(name)) {
            tabelaEscopo.adicionar(name, typeItem);
        } else {
            t3SemanticoUtils.adicionaErroSemantico(nameT, "identificador " + name + " ja declarado anteriormente");
        }
    }

    @Override
    public Void visitPrograma(t3SintaxeParser.ProgramaContext ctx) {
        // inicialização
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    // checa qual o type da declaracao
    @Override
    public Void visitDeclaracoes(t3SintaxeParser.DeclaracoesContext ctx) {
        for (t3SintaxeParser.Decl_local_globalContext declaracao : ctx.decl_local_global()) {
            visitDecl_local_global(declaracao);
        }
        return super.visitDeclaracoes(ctx);
    }

    @Override
    public Void visitDecl_local_global(t3SintaxeParser.Decl_local_globalContext ctx) {
        if (ctx.declaracao_local() != null) {
            visitDeclaracao_local(ctx.declaracao_local());
        } else if (ctx.declaracao_global() != null) {
            visitDeclaracao_global(ctx.declaracao_global());
        }
        return super.visitDecl_local_global(ctx);
    }

    @Override
    public Void visitDeclaracao_local(t3SintaxeParser.Declaracao_localContext ctx) {
        String typeVar;
        String nameVar;

        // procura uma declaracao
        if (ctx.getText().contains("declare")) {
            typeVar = ctx.variavel().tipo().getText();

            for (t3SintaxeParser.IdentificadorContext id : ctx.variavel().identificador()) {
                nameVar = id.getText();
                adicionaVariavelTabela(nameVar, typeVar, id.getStart(), ctx.variavel().tipo().getStart());
            }
        }
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitCmdLeia(t3SintaxeParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        for (t3SintaxeParser.IdentificadorContext id : ctx.identificador()) {
            if (!tabela.existe(id.getText())) {
                t3SemanticoUtils.adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");
            }
        }
        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(t3SintaxeParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        for (t3SintaxeParser.ExpressaoContext expressao : ctx.expressao()) {
            t3SemanticoUtils.verificarTipo(tabela, expressao);
        }
        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(t3SintaxeParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        t3SemanticoUtils.verificarTipo(tabela, ctx.expressao());
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdAtribuicao(t3SintaxeParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        Tipot3Sintaxe typeExp = t3SemanticoUtils.verificarTipo(tabela, ctx.expressao());
        String varName = ctx.identificador().getText();
        
        if (typeExp != Tipot3Sintaxe.INVALIDO) {
            // caso variável não tenha sido declarada
            if (!tabela.existe(varName)) {
                t3SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            } else {
                Tipot3Sintaxe varType = tabela.verificar(varName);
                // se for real ou inteiro, pode ser feita a verificação
                if (varType == Tipot3Sintaxe.INTEIRO || varType == Tipot3Sintaxe.REAL) {
                    if (!t3SemanticoUtils.verificaCompatibilidade(varType, typeExp)) {
                        // tipo da expressão não inteiro
                        if (typeExp != Tipot3Sintaxe.INTEIRO) {
                            t3SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                } else if (varType != typeExp) {
                    t3SemanticoUtils.adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());   
                }
            }
        }
        return super.visitCmdAtribuicao(ctx);
    }
}
