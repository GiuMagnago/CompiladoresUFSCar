package br.ufscar.dc.compiladores.t6;

public class EntradaTabelaDeSimbolos {

    public enum TipoEntrada {
        CANDIDATO,
        ELEITOR
    }

    private final String nome;
    private final TipoEntrada tipo;

    public EntradaTabelaDeSimbolos(String nome, TipoEntrada tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }
}
