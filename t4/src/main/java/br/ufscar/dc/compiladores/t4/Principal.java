/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.t4;

import br.ufscar.dc.compiladores.t4.t4SintaxeParser.ProgramaContext;
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
            
            t4SintaxeLexer lexer = new t4SintaxeLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            t4SintaxeParser parser = new t4SintaxeParser(tokens);
            ProgramaContext tree = parser.programa();
            t4Semantico s = new t4Semantico();
            
            s.visitPrograma(tree);
            
            List<String> erros = t4SemanticoUtils.errosSemanticos;
            for (int i = 0; i < erros.size(); i++) {
                pw.println(erros.get(i));
            }
            pw.println("Fim da compilacao");
            pw.close();
         
        } catch(RuntimeException e){}
    }
}