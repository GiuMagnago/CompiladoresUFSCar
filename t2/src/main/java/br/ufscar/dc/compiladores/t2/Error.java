/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufscar.dc.compiladores.t2;

import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author Giuseppe
 */
public class Error implements ANTLRErrorListener {
    
    PrintWriter writer;
    
    public Error(PrintWriter writer) {
        this.writer = writer;
    }
    
    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {}

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {}

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {}

    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {

        // Token analisado
        Token t = (Token) o;

        switch (t.getType()) {
            case -1: // token EOF, que indica o fim do programa analisado
                writer.println("Linha " + i + ": erro sintatico proximo a EOF");
                break;
            case 66: // 6erro em uma cadeia literal
                writer.println("Linha " + i + ": cadeia literal nao fechada");
                break;
            case 67: // erro em um comentario
                writer.println("Linha " + i + ": comentario nao fechado");
                break;
            case 68: // erro na identificação de simbolos
                writer.println("Linha " + i + ": " + t.getText() + " - simbolo nao identificado");
                break;
            default: // mensagem padrão de erro sintático
                writer.println("Linha " + i + ": erro sintatico proximo a " + t.getText());
                break;
        }  
        
        writer.println("Fim da compilacao"); 
        throw new RuntimeException();
    }
}
