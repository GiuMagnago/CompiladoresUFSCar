/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t3;

import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.Tipot3Sintaxe;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Giuseppe
 */

public class t3SemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();

    public static void adicionaErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        
        if (!errosSemanticos.contains("Linha " + linha + ": " + mensagem)) {
            errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
        }
    }
    
    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Exp_aritmeticaContext ctx) {
        // pega o primeiro termo da expressão
        Tipot3Sintaxe tipoRet = verificarTipo(tabela, ctx.termo().get(0));
                
        for (var termoArit : ctx.termo()) {
            // pega o segundo termo da expressão
            Tipot3Sintaxe tipoAtual = verificarTipo(tabela, termoArit);
            
            // faz a comparação entre os termos seguindo as regras do professor
            // após, ele checa se o tipo atual não é inválido (na comparação não é checado)
            if ((verificaCompatibilidade(tipoAtual, tipoRet)) && (tipoAtual != Tipot3Sintaxe.INVALIDO))
                tipoRet = Tipot3Sintaxe.REAL;
            else
                tipoRet = tipoAtual;
        }

        return tipoRet;
    }
    
    // verifica a compatibilidade entre tipos nas operações aritmeticas
    public static boolean verificaCompatibilidade(Tipot3Sintaxe T1, Tipot3Sintaxe T2) {
        if (T1 == Tipot3Sintaxe.INTEIRO && T2 == Tipot3Sintaxe.REAL) {
            return true;
        } else if (T1 == Tipot3Sintaxe.REAL && T2 == Tipot3Sintaxe.INTEIRO) {
            return true;
        } else if (T1 == Tipot3Sintaxe.REAL && T2 == Tipot3Sintaxe.REAL) {
            return true;
        }
        return false;
    }
    
    // verifica a compatibilidade entre tipos nas operações lógicas
    public static boolean verificaCompatibilidadeLogica(Tipot3Sintaxe T1, Tipot3Sintaxe T2) {
        if (T1 == Tipot3Sintaxe.INTEIRO && T2 == Tipot3Sintaxe.REAL) {
            return true;
        } else if (T1 == Tipot3Sintaxe.REAL && T2 == Tipot3Sintaxe.INTEIRO) {
            return true;
        }
        return false;
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.TermoContext ctx) {
        Tipot3Sintaxe tipoRet = verificarTipo(tabela, ctx.fator().get(0));
                
        for (t3SintaxeParser.FatorContext fatorArit : ctx.fator()) {
            Tipot3Sintaxe tipoAtual = verificarTipo(tabela, fatorArit);
            
            // faz a comparação entre os termos seguindo as regras do professor
            // após, ele checa se o tipo atual não é inválido (na comparação não é checado)
            if ((verificaCompatibilidade(tipoAtual, tipoRet)) && (tipoAtual != Tipot3Sintaxe.INVALIDO)) {
                tipoRet = Tipot3Sintaxe.REAL;
            } else {
                tipoRet = tipoAtual;
            }
        }
        return tipoRet;
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.FatorContext ctx) {
        Tipot3Sintaxe tipoRet = null;
        
        for (t3SintaxeParser.ParcelaContext parcela : ctx.parcela()) {
            if (parcela.parcela_unario() != null) {
                return verificarTipo(tabela, parcela.parcela_unario());
            } else {
                return verificarTipo(tabela, parcela.parcela_nao_unario());
            }
        }
        return tipoRet;
    }


    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Parcela_unarioContext ctx) {
        String name;
        
        if (ctx.identificador() != null) {
            // pega o name da variável
            name = ctx.identificador().getText();
            
            // se ela já estiver declarada, retorna o tipo dela
            if (tabela.existe(name))
                return tabela.verificar(name);
            // se não encontrar, continua a busca
            else {
                TabelaDeSimbolos tabelaAux = t3Semantico.escoposAninhados.percorrerEscoposAninhados().get(t3Semantico.escoposAninhados.percorrerEscoposAninhados().size() - 1);
                if (!tabelaAux.existe(name)) {
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                    return Tipot3Sintaxe.INVALIDO;
                } else 
                    return tabelaAux.verificar(name);
            }
        } else if (ctx.NUM_INT() != null) {
            return Tipot3Sintaxe.INTEIRO;
        } else if (ctx.NUM_REAL() != null) {
            return Tipot3Sintaxe.REAL;
        } else {
            return verificarTipo(tabela, ctx.exp_aritmetica().get(0));
        }
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Parcela_nao_unarioContext ctx) {
        String name;

        if (ctx.identificador() != null) {
            name = ctx.identificador().getText();
        
            if (!tabela.existe(name)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                return Tipot3Sintaxe.INVALIDO;
            } else {
                return tabela.verificar(ctx.identificador().getText());
            }   
        } else {
            return Tipot3Sintaxe.LITERAL;
        }
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.ExpressaoContext ctx) {
        Tipot3Sintaxe tipoRet = verificarTipo(tabela, ctx.termo_logico(0));

        // verifica se os tipos são diferentes (é o bastante)
        for (t3SintaxeParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            Tipot3Sintaxe tipoAtual = verificarTipo(tabela, termoLogico);
            if (tipoRet != tipoAtual && tipoAtual != Tipot3Sintaxe.INVALIDO) {
                tipoRet = Tipot3Sintaxe.INVALIDO;
            }
        }

        return tipoRet;
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Termo_logicoContext ctx) {
        Tipot3Sintaxe tipoRet = verificarTipo(tabela, ctx.fator_logico(0).parcela_logica());

        // verifica se os tipos são diferentes (é o bastante)
        for (t3SintaxeParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            Tipot3Sintaxe tipoAtual = verificarTipo(tabela, fatorLogico.parcela_logica());
            if (tipoRet != tipoAtual && tipoAtual != Tipot3Sintaxe.INVALIDO) {
                tipoRet = Tipot3Sintaxe.INVALIDO;
            }
        }
        return tipoRet;
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Parcela_logicaContext ctx) {
        if (ctx.exp_relacional() != null) {
            return verificarTipo(tabela, ctx.exp_relacional());
        } else {
            return Tipot3Sintaxe.LOGICO;
        }
    }

    public static Tipot3Sintaxe verificarTipo(TabelaDeSimbolos tabela, t3SintaxeParser.Exp_relacionalContext ctx) {
        Tipot3Sintaxe tipoRet = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        if (ctx.exp_aritmetica().size() > 1) {
            Tipot3Sintaxe tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));

            // verifica a possibilidade da expressão lógica
            if (tipoRet == tipoAtual || verificaCompatibilidadeLogica(tipoRet, tipoAtual)) {
                tipoRet = Tipot3Sintaxe.LOGICO;
            } else {
                tipoRet = Tipot3Sintaxe.INVALIDO;
            }
        }
        return tipoRet;

    }
}