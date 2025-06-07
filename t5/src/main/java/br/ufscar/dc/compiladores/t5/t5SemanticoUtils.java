/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t5;
import static br.ufscar.dc.compiladores.t5.t5Semantico.dadosFuncaoProcedimento;
import static br.ufscar.dc.compiladores.t5.t5Semantico.escoposAninhados;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.Tipot5Sintaxe;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Giuseppe
 */

public class t5SemanticoUtils {

    // Lista que guarda erros semânticos encontrados
    public static List<String> errosSemanticos = new ArrayList<>();

    // Registra novo erro se ainda não foi registrado
    public static void adicionaErroSemantico(Token token, String msg) {
        int linha = token.getLine();
        String formatado = String.format("Linha %d: %s", linha, msg);
        if (!errosSemanticos.contains(formatado)) {
            errosSemanticos.add(formatado);
        }
    }

    // Verifica compatibilidade aritmética (qualquer operando REAL gera REAL)
    public static boolean verificaCompatibilidade(Tipot5Sintaxe a, Tipot5Sintaxe b) {
        return (a == Tipot5Sintaxe.REAL && b != Tipot5Sintaxe.INVALIDO)
            || (b == Tipot5Sintaxe.REAL && a != Tipot5Sintaxe.INVALIDO);
    }

    // Verifica compatibilidade lógica entre inteiro e real
    public static boolean verificaCompatibilidadeLogica(Tipot5Sintaxe a, Tipot5Sintaxe b) {
        return (a == Tipot5Sintaxe.REAL && b == Tipot5Sintaxe.INTEIRO)
            || (a == Tipot5Sintaxe.INTEIRO && b == Tipot5Sintaxe.REAL);
    }

    // Remove sufixo de vetor/procedimento (ex: "vetor[...]" vira "vetor")
    public static String redutor(String nome, String simbolo) {
        if (nome.contains(simbolo)) {
            int pos = 0;
            while (!nome.substring(pos).startsWith(simbolo)) {
                pos++;
            }
            return nome.substring(0, pos);
        }
        return nome;
    }

    // Determina Tipot5Sintaxe a partir de literal ou registro
    public static Tipot5Sintaxe confereTipo(HashMap<String,ArrayList<String>> tabelaTipos, String tipoTxt) {
        if (tipoTxt.startsWith("^")) {
            tipoTxt = tipoTxt.substring(1);
        }
        if (tabelaTipos.containsKey(tipoTxt)) return Tipot5Sintaxe.REGISTRO;
        if (tipoTxt.equals("literal")) return Tipot5Sintaxe.LITERAL;
        if (tipoTxt.equals("inteiro")) return Tipot5Sintaxe.INTEIRO;
        if (tipoTxt.equals("real")) return Tipot5Sintaxe.REAL;
        if (tipoTxt.equals("logico")) return Tipot5Sintaxe.LOGICO;
        return Tipot5Sintaxe.INVALIDO;
    }

    // Métodos de avaliação de tipo para expressões e seus componentes:

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Exp_aritmeticaContext ctx) {
        Tipot5Sintaxe tipo = verificarTipo(tabela, ctx.termo().get(0));
        for (var termo : ctx.termo()) {
            Tipot5Sintaxe t = verificarTipo(tabela, termo);
            tipo = verificaCompatibilidade(tipo, t) ? Tipot5Sintaxe.REAL : t;
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.TermoContext ctx) {
        Tipot5Sintaxe tipo = verificarTipo(tabela, ctx.fator().get(0));
        for (var fator : ctx.fator()) {
            Tipot5Sintaxe t = verificarTipo(tabela, fator);
            tipo = verificaCompatibilidade(tipo, t) ? Tipot5Sintaxe.REAL : t;
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.FatorContext ctx) {
        Tipot5Sintaxe tipo = null;
        for (var parcela : ctx.parcela()) {
            tipo = verificarTipo(tabela, parcela);
            if (tipo == Tipot5Sintaxe.REGISTRO) {
                String base = redutor(parcela.getText(), "(");
                tipo = verificarTipo(tabela, base);
            }
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.ParcelaContext ctx) {
        return ctx.parcela_unario() != null
            ? verificarTipo(tabela, ctx.parcela_unario())
            : verificarTipo(tabela, ctx.parcela_nao_unario());
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Parcela_unarioContext ctx) {
        Tipot5Sintaxe tipo;
        if (ctx.identificador() != null) {
            String id = ctx.identificador().dimensao().exp_aritmetica().isEmpty()
                ? ctx.identificador().getText()
                : ctx.identificador().IDENT().get(0).getText();
            if (tabela.existe(id)) {
                tipo = tabela.verificar(id);
            } else {
                TabelaDeSimbolos escopo = escoposAninhados.obterEscopoAtual();
                if (!escopo.existe(id)) {
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + id + " nao declarado");
                    tipo = Tipot5Sintaxe.INVALIDO;
                } else {
                    tipo = escopo.verificar(id);
                }
            }
        } else if (ctx.IDENT() != null) {
            if (dadosFuncaoProcedimento.containsKey(ctx.IDENT().getText())) {
                List<Tipot5Sintaxe> sig = dadosFuncaoProcedimento.get(ctx.IDENT().getText());
                if (sig.size() == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++) {
                        if (sig.get(i) != verificarTipo(tabela, ctx.expressao().get(i))) {
                            adicionaErroSemantico(ctx.expressao().get(i).getStart(),
                                "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                        }
                    }
                    tipo = sig.get(sig.size() - 1);
                } else {
                    adicionaErroSemantico(ctx.IDENT().getSymbol(),
                        "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                    tipo = Tipot5Sintaxe.INVALIDO;
                }
            } else {
                tipo = Tipot5Sintaxe.INVALIDO;
            }
        } else if (ctx.NUM_INT() != null) {
            tipo = Tipot5Sintaxe.INTEIRO;
        } else if (ctx.NUM_REAL() != null) {
            tipo = Tipot5Sintaxe.REAL;
        } else {
            tipo = verificarTipo(tabela, ctx.expressao().get(0));
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Parcela_nao_unarioContext ctx) {
        if (ctx.identificador() != null) {
            String nome = ctx.identificador().getText();
            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(),
                    "identificador " + nome + " nao declarado");
                return Tipot5Sintaxe.INVALIDO;
            }
            return tabela.verificar(nome);
        }
        return Tipot5Sintaxe.LITERAL;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.ExpressaoContext ctx) {
        Tipot5Sintaxe tipo = verificarTipo(tabela, ctx.termo_logico(0));
        for (var termo : ctx.termo_logico()) {
            Tipot5Sintaxe t = verificarTipo(tabela, termo);
            if (tipo != t && t != Tipot5Sintaxe.INVALIDO) {
                tipo = Tipot5Sintaxe.INVALIDO;
            }
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Termo_logicoContext ctx) {
        Tipot5Sintaxe tipo = verificarTipo(tabela, ctx.fator_logico(0));
        for (var fator : ctx.fator_logico()) {
            Tipot5Sintaxe t = verificarTipo(tabela, fator);
            if (tipo != t && t != Tipot5Sintaxe.INVALIDO) {
                tipo = Tipot5Sintaxe.INVALIDO;
            }
        }
        return tipo;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Fator_logicoContext ctx) {
        return verificarTipo(tabela, ctx.parcela_logica());
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Parcela_logicaContext ctx) {
        return ctx.exp_relacional() != null
            ? verificarTipo(tabela, ctx.exp_relacional())
            : Tipot5Sintaxe.LOGICO;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.Exp_relacionalContext ctx) {
        Tipot5Sintaxe t1 = verificarTipo(tabela, ctx.exp_aritmetica().get(0));
        if (ctx.exp_aritmetica().size() > 1) {
            Tipot5Sintaxe t2 = verificarTipo(tabela, ctx.exp_aritmetica().get(1));
            return (t1 == t2 || verificaCompatibilidade(t1, t2)) ? Tipot5Sintaxe.LOGICO : Tipot5Sintaxe.INVALIDO;
        }
        return t1;
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, t5SintaxeParser.IdentificadorContext ctx) {
        return tabela.verificar(ctx.IDENT().get(0).getText());
    }

    public static Tipot5Sintaxe verificarTipo(TabelaDeSimbolos tabela, String nome) {
        return tabela.verificar(nome);
    }
} 

