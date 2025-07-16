package br.ufscar.dc.compiladores.t6;

import java.util.*;

public class TabelaDeSimbolos {
    private final Map<String, EntradaTabelaDeSimbolos> simbolos = new LinkedHashMap<>();

    public boolean adicionar(EntradaTabelaDeSimbolos entrada) {
        if (simbolos.containsKey(entrada.getNome())) {
            return false;
        }
        simbolos.put(entrada.getNome(), entrada);
        return true;
    }

    public boolean existe(String nome) {
        return simbolos.containsKey(nome);
    }

    public EntradaTabelaDeSimbolos buscar(String nome) {
        return simbolos.get(nome);
    }

    public Set<String> nomes() {
        return simbolos.keySet();
    }
}
