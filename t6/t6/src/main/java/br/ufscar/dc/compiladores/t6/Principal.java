package br.ufscar.dc.compiladores.t6;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Erro nos argumentos.");
            System.err.println("Uso correto: java -jar <caminho do complicador .jar> <caminho da entrada .el> <caminho da saída .txt>");
            return;
        }

        String entrada = args[0];
        String saida = args[1];

        String source = new String(Files.readAllBytes(Paths.get(entrada)));

        eleicoesLexer lexer = new eleicoesLexer(CharStreams.fromString(source));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        eleicoesParser parser = new eleicoesParser(tokens);

        parser.removeErrorListeners();

        ParseTree tree = parser.programa();

        EleicaoSemantico semantico = new EleicaoSemantico();
        semantico.visit(tree);

        String resultado = semantico.gerarResultadoFinal();

        FileWriter fw = new FileWriter(saida);
        fw.write(resultado);
        fw.close();

        System.out.println("Apuração concluída! Resultado salvo em: " + saida);
    }
}
