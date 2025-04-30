/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Giuseppe
 */
public class Principal {
    
    public static void main(String args[]) throws IOException {
        
        try(PrintWriter pw = new PrintWriter(new File(args[1]))) {
            
            CharStream cs = CharStreams.fromFileName(args[0]);
            
            // Geração dos tokens para as verificações
            t2SintaxeLexer lexer = new t2SintaxeLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Processo de análise.
            t2SintaxeParser parser = new t2SintaxeParser(tokens);

            // Para as mensagens de erro personalizado foi criada a classe Error
            Error errorListener = new Error(pw);
            parser.removeErrorListeners(); // Remove as mensagens de erro pré-definidas
            parser.addErrorListener(errorListener); // Adiciona os erros customizados

            parser.programa();
         
        } catch(RuntimeException e){}
    }
}