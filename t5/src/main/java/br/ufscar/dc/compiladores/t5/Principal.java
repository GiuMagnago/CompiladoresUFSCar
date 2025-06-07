/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t5;

import br.ufscar.dc.compiladores.t5.t5SintaxeParser.ProgramaContext;
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
            
            CharStream cs = CharStreams.fromFileName(args[0]);
            
            t5SintaxeLexer lexer = new t5SintaxeLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            t5SintaxeParser parser = new t5SintaxeParser(tokens);
            ProgramaContext tree = parser.programa();
            t5Semantico s = new t5Semantico();
            
            s.visitPrograma(tree);
            
            if (t5SemanticoUtils.errosSemanticos.isEmpty()) {
            GeraC agc = new GeraC();
            agc.visitPrograma(tree);
            
            try(PrintWriter pw = new PrintWriter(args[1])) {
                pw.print(agc.saida.toString());
            }
        }
      
    }
}