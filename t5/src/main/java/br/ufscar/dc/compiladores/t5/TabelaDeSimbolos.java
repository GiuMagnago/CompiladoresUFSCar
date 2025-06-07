/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giuseppe
 */
public class TabelaDeSimbolos {
    
    // tipos de variáveis
    public enum Tipot5Sintaxe {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        VOID,
        REGISTRO,
        TIPOESTENDIDO,
        INVALIDO
    }
    
    // tipos de declarações
    public enum TipoEntrada {
        VARIAVEL, 
        PROCEDIMENTO,
        FUNCAO
    }
    
    class EntradaTabelaDeSimbolos {
        String nome;
        Tipot5Sintaxe tipo;
        TipoEntrada tipoE;

        private EntradaTabelaDeSimbolos(String nome, Tipot5Sintaxe tipo, TipoEntrada tipoE) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipoE = tipoE;
        }
    }
    
    private final  Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, Tipot5Sintaxe tipo, TipoEntrada tipoE) {
        nome = t5SemanticoUtils.redutor(nome, "[");
        
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoE));
    }
    
    public boolean existe(String nome) {
        nome = t5SemanticoUtils.redutor(nome, "[");

        return tabela.containsKey(nome);
    }
    
    public Tipot5Sintaxe verificar(String nome) {
        nome = t5SemanticoUtils.redutor(nome, "[");
        
        return tabela.get(nome).tipo;
    }
}
