/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giuseppe
 */
public class TabelaDeSimbolos {
    
    // tipos de variáveis
    public enum Tipot4Sintaxe {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        VOID,
        REGISTRO,
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
        Tipot4Sintaxe tipo;
        TipoEntrada tipoE;

        private EntradaTabelaDeSimbolos(String nome, Tipot4Sintaxe tipo, TipoEntrada tipoE) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipoE = tipoE;
        }
    }
    
    private final  Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, Tipot4Sintaxe tipo, TipoEntrada tipoE) {
        nome = t4SemanticoUtils.redutor(nome, "[");
        
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoE));
    }
    
    public boolean existe(String nome) {
        nome = t4SemanticoUtils.redutor(nome, "[");

        return tabela.containsKey(nome);
    }
    
    public Tipot4Sintaxe verificar(String nome) {
        nome = t4SemanticoUtils.redutor(nome, "[");
        
        return tabela.get(nome).tipo;
    }
}
