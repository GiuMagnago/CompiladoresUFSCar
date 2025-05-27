/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t4;
import static br.ufscar.dc.compiladores.t4.t4Semantico.mapaFuncProc;
import static br.ufscar.dc.compiladores.t4.t4Semantico.gerenciadorEscopos;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.Tipot4Sintaxe;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Giuseppe
 */

public class t4SemanticoUtils {

    public static List<String> errosSemanticos = new ArrayList<>();

    public static void adicionaErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        String erro = String.format("Linha %d: %s", linha, mensagem);
        if (!errosSemanticos.contains(erro)) {
            errosSemanticos.add(erro);
        }
    }

    public static boolean verificaCompatibilidade(Tipot4Sintaxe a, Tipot4Sintaxe b) {
        return (a == Tipot4Sintaxe.REAL || b == Tipot4Sintaxe.REAL)
                && (a == Tipot4Sintaxe.INTEIRO || a == Tipot4Sintaxe.REAL)
                && (b == Tipot4Sintaxe.INTEIRO || b == Tipot4Sintaxe.REAL);
    }

    public static boolean verificaCompatibilidadeLogica(Tipot4Sintaxe a, Tipot4Sintaxe b) {
        return (a == Tipot4Sintaxe.INTEIRO && b == Tipot4Sintaxe.REAL)
                || (a == Tipot4Sintaxe.REAL && b == Tipot4Sintaxe.INTEIRO);
    }

    public static String redutor(String nome, String simbolo) {
        int pos = nome.indexOf(simbolo);
        return (pos != -1) ? nome.substring(0, pos) : nome;
    }

    public static Tipot4Sintaxe confereTipo(HashMap<String, ArrayList<String>> registros, String tipo) {
        if (tipo.startsWith("^")) {
            tipo = tipo.substring(1);
        }

        switch (tipo) {
            case "literal":
                return Tipot4Sintaxe.LITERAL;
            case "inteiro":
                return Tipot4Sintaxe.INTEIRO;
            case "real":
                return Tipot4Sintaxe.REAL;
            case "logico":
                return Tipot4Sintaxe.LOGICO;
            default:
                return registros.containsKey(tipo) ? Tipot4Sintaxe.REGISTRO : Tipot4Sintaxe.INVALIDO;
        }
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Exp_aritmeticaContext ctx) {
        Tipot4Sintaxe tipo = verificarTipo(tabela, ctx.termo().get(0));

        // Percorre os termos restantes e verifica compatibilidade aritmética
        for (t4SintaxeParser.TermoContext termo : ctx.termo()) {
            Tipot4Sintaxe tipoAtual = verificarTipo(tabela, termo);
            if (verificaCompatibilidade(tipo, tipoAtual) && tipoAtual != Tipot4Sintaxe.INVALIDO) {
                tipo = Tipot4Sintaxe.REAL;
            } else {
                tipo = tipoAtual;
            }
        }

        return tipo;
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.TermoContext ctx) {
        Tipot4Sintaxe tipo = verificarTipo(tabela, ctx.fator().get(0));

        for (t4SintaxeParser.FatorContext fator : ctx.fator()) {
            Tipot4Sintaxe tipoAtual = verificarTipo(tabela, fator);
            if (verificaCompatibilidade(tipo, tipoAtual) && tipoAtual != Tipot4Sintaxe.INVALIDO) {
                tipo = Tipot4Sintaxe.REAL;
            } else {
                tipo = tipoAtual;
            }
        }

        return tipo;
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.FatorContext ctx) {
        Tipot4Sintaxe tipo = null;

        for (t4SintaxeParser.ParcelaContext parcela : ctx.parcela()) {
            tipo = verificarTipo(tabela, parcela);

            // Se for um registro com chamada de função, extrai o nome
            if (tipo == Tipot4Sintaxe.REGISTRO) {
                String nome = redutor(parcela.getText(), "(");
                tipo = verificarTipo(tabela, nome);
            }
        }

        return tipo;
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.ParcelaContext ctx) {
        if (ctx.parcela_unario() != null) {
            return verificarTipo(tabela, ctx.parcela_unario());
        } else {
            return verificarTipo(tabela, ctx.parcela_nao_unario());
        }
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Parcela_unarioContext ctx) {
        Tipot4Sintaxe tipo = null;
        String nome;

        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();

            if (tabela.existe(nome)) {
                tipo = tabela.verificar(nome);
            } else {
                TabelaDeSimbolos escopo = gerenciadorEscopos.obterEscopoAtual();
                if (!escopo.existe(nome)) {
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + nome + " nao declarado");
                    tipo = Tipot4Sintaxe.INVALIDO;
                } else {
                    tipo = escopo.verificar(nome);
                }
            }
        } else if (ctx.IDENT() != null) {
            // Chamada de função/procedimento
            String nomeFunc = ctx.IDENT().getText();
            if (mapaFuncProc.containsKey(nomeFunc)) {
                List<Tipot4Sintaxe> tipos = mapaFuncProc.get(nomeFunc);

                if (tipos.size() == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++) {
                        Tipot4Sintaxe tipoParam = verificarTipo(tabela, ctx.expressao().get(i));
                        if (tipos.get(i) != tipoParam) {
                            adicionaErroSemantico(ctx.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + nomeFunc);
                        }
                    }
                    tipo = tipos.get(tipos.size() - 1);
                } else {
                    adicionaErroSemantico(ctx.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + nomeFunc);
                }
            } else {
                tipo = Tipot4Sintaxe.INVALIDO;
            }
        } else if (ctx.NUM_INT() != null) {
            tipo = Tipot4Sintaxe.INTEIRO;
        } else if (ctx.NUM_REAL() != null) {
            tipo = Tipot4Sintaxe.REAL;
        } else {
            tipo = verificarTipo(tabela, ctx.expressao().get(0));
        }

        return tipo;
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Parcela_nao_unarioContext ctx) {
        Tipot4Sintaxe tipo;
        String nome;

        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();

            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + nome + " nao declarado");
                tipo = Tipot4Sintaxe.INVALIDO;
            } else {
                tipo = tabela.verificar(nome);
            }
        } else {
            tipo = Tipot4Sintaxe.LITERAL;
        }

        return tipo;
    }

    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.ExpressaoContext ctx) {
        Tipot4Sintaxe tipo = verificarTipo(tabela, ctx.termo_logico(0));

        // Avalia todos os termos lógicos da expressão
        for (t4SintaxeParser.Termo_logicoContext termo : ctx.termo_logico()) {
            Tipot4Sintaxe tipoAtual = verificarTipo(tabela, termo);
            if (verificaCompatibilidadeLogica(tipo, tipoAtual)) {
                tipo = Tipot4Sintaxe.LOGICO;
            }
        }

        return tipo;
    }
    
    // Verifica o tipo de uma expressão lógica composta por fatores lógicos
    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Termo_logicoContext ctx) {
        // Começa verificando o tipo do primeiro fator lógico
        Tipot4Sintaxe tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));
        
        // Percorre os demais fatores lógicos para verificar compatibilidade
        for (t4SintaxeParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            Tipot4Sintaxe tipoAtual = verificarTipo(tabela, fatorLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != Tipot4Sintaxe.INVALIDO) {
                tipoRetorno = Tipot4Sintaxe.INVALIDO;
            }
        }
        
        return tipoRetorno;
    }
    
    // Verifica o tipo de um fator lógico (composto por uma parcela lógica)
    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Fator_logicoContext ctx) {
        return verificarTipo(tabela, ctx.parcela_logica());
    }
    
    // Verifica o tipo de uma parcela lógica
    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Parcela_logicaContext ctx) {
        // Se houver uma expressão relacional, verifica seu tipo
        if (ctx.exp_relacional() != null) {
            return verificarTipo(tabela, ctx.exp_relacional());
        } else {
            // Caso contrário, trata como valor lógico direto (true/false)
            return Tipot4Sintaxe.LOGICO;
        }
    }
    
    // Verifica o tipo de uma expressão relacional
    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, t4SintaxeParser.Exp_relacionalContext ctx) {
        // Verifica o tipo da primeira expressão aritmética
        Tipot4Sintaxe tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));
        
        // Se houver uma segunda expressão aritmética, realiza a verificação de compatibilidade
        if (ctx.exp_aritmetica().size() > 1) {
            Tipot4Sintaxe tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));
            if (tipoRetorno == tipoAtual || verificaCompatibilidadeLogica(tipoRetorno, tipoAtual)) {
                tipoRetorno = Tipot4Sintaxe.LOGICO;
            } else {
                tipoRetorno = Tipot4Sintaxe.INVALIDO;
            }
        }
        
        return tipoRetorno;
    }


    public static Tipot4Sintaxe verificarTipo(TabelaDeSimbolos tabela, String nome) {
        Tipot4Sintaxe tipo;

        if (!tabela.existe(nome)) {
            TabelaDeSimbolos escopo = gerenciadorEscopos.obterEscopoAtual();
            if (!escopo.existe(nome)) {
                tipo = Tipot4Sintaxe.INVALIDO;
            } else {
                tipo = escopo.verificar(nome);
            }
        } else {
            tipo = tabela.verificar(nome);
        }

        return tipo;
    }
} 
