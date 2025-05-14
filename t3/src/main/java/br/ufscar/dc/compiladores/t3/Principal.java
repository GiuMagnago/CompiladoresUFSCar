/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t3;

import br.ufscar.dc.compiladores.t3.t3SintaxeParser.ProgramaContext;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            
            t3SintaxeLexer lexer = new t3SintaxeLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            t3SintaxeParser parser = new t3SintaxeParser(tokens);
            ProgramaContext tree = parser.programa();
            t3Semantico s = new t3Semantico();
            
            s.visitPrograma(tree);
            
            List<String> erros = t3SemanticoUtils.errosSemanticos;
            for (int i = 0; i < erros.size(); i++) {
                pw.println(erros.get(i));
            }
            pw.println("Fim da compilacao");
            pw.close();
         
        } catch(RuntimeException e){}
    }
}