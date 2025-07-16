package br.ufscar.dc.compiladores.t6;

import java.util.*;

public class Escopos {
    private final TabelaDeSimbolos escopoGlobal = new TabelaDeSimbolos();
    private final Map<String, TabelaDeSimbolos> urnas = new LinkedHashMap<>();

    public TabelaDeSimbolos getGlobal() {
        return escopoGlobal;
    }

    public void criarUrna(String nome) {
        urnas.put(nome, new TabelaDeSimbolos());
    }

    public TabelaDeSimbolos getUrna(String nome) {
        return urnas.get(nome);
    }

    public boolean eleitorJaVotou(String eleitor) {
        return urnas.values().stream().anyMatch(t -> t.existe(eleitor));
    }

    public Map<String, TabelaDeSimbolos> getTodasUrnas() {
        return urnas;
    }
}
