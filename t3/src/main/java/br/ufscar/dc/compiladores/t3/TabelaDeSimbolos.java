/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giuseppe
 */
public class TabelaDeSimbolos {
    public enum Tipot3Sintaxe {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        INVALIDO
    }
    
    class EntradaTabelaDeSimbolos {

        String nome;
        Tipot3Sintaxe tipo;

        private EntradaTabelaDeSimbolos(String nome, Tipot3Sintaxe tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }
    }
    
    private final  Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, Tipot3Sintaxe tipo) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public Tipot3Sintaxe verificar(String nome) {
        return tabela.get(nome).tipo;
    }
}
