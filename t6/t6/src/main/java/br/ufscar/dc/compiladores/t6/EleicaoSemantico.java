package br.ufscar.dc.compiladores.t6;

import java.util.*;

public class EleicaoSemantico extends eleicoesBaseVisitor<Void> {

    private final Escopos escopos = new Escopos();
    private final Map<String, Map<String, Integer>> votosPorUrna = new LinkedHashMap<>();
    private final Map<String, Integer> totalVotos = new LinkedHashMap<>();
    private final List<String> erros = new ArrayList<>();
    
    @Override
    public Void visitCandidatoDecl(eleicoesParser.CandidatoDeclContext ctx) {
        String nome = ctx.STRING().getText().replace("\"", "");

        boolean inserido = escopos.getGlobal().adicionar(
                new EntradaTabelaDeSimbolos(nome, EntradaTabelaDeSimbolos.TipoEntrada.CANDIDATO));

        if (!inserido) {
            erros.add("Erro: Candidato \"" + nome + "\" já declarado.");
        }

        totalVotos.putIfAbsent(nome, 0);
        return null;
    }

    @Override
    public Void visitUrnaDecl(eleicoesParser.UrnaDeclContext ctx) {
        String idUrna = ctx.STRING().getText().replace("\"", "");
        escopos.criarUrna(idUrna);
        TabelaDeSimbolos urna = escopos.getUrna(idUrna);

        Map<String, Integer> votosUrna = new LinkedHashMap<>();

        for (var votoCtx : ctx.votoDecl()) {
            String eleitor = votoCtx.STRING(0).getText().replace("\"", "");
            String candidato = votoCtx.STRING(1).getText().replace("\"", "");

            // Verifica se candidato existe
            if (!escopos.getGlobal().existe(candidato)) {
                erros.add("Erro: Candidato \"" + candidato + "\" não existe.");
                continue;
            }

            // Verifica se eleitor já votou em alguma urna
            if (escopos.eleitorJaVotou(eleitor)) {
                erros.add("Erro: Eleitor \"" + eleitor + "\" já votou.");
                continue;
            }

            // Registra eleitor nesta urna
            urna.adicionar(new EntradaTabelaDeSimbolos(eleitor, EntradaTabelaDeSimbolos.TipoEntrada.ELEITOR));

            votosUrna.put(candidato, votosUrna.getOrDefault(candidato, 0) + 1);
            totalVotos.put(candidato, totalVotos.getOrDefault(candidato, 0) + 1);
        }

        votosPorUrna.put(idUrna, votosUrna);
        return null;
    }

    public String gerarResultadoFinal() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- Resultado por Urna ---\n");
        for (var urna : votosPorUrna.keySet()) {
            sb.append("Urna ").append(urna).append(":\n");
            Map<String, Integer> votos = votosPorUrna.get(urna);
            for (String cand : escopos.getGlobal().nomes()) {
                sb.append("  ").append(cand)
                        .append(": ").append(votos.getOrDefault(cand, 0)).append(" voto(s)\n");
            }
            sb.append("\n");
        }

        sb.append("--- Resultado Geral ---\n");
        for (String cand : escopos.getGlobal().nomes()) {
            sb.append(cand).append(": ").append(totalVotos.getOrDefault(cand, 0)).append(" voto(s)\n");
        }

        // Vencedor
        int max = -1;
        List<String> vencedores = new ArrayList<>();
        for (String cand : totalVotos.keySet()) {
            int votos = totalVotos.get(cand);
            if (votos > max) {
                max = votos;
                vencedores.clear();
                vencedores.add(cand);
            } else if (votos == max) {
                vencedores.add(cand);
            }
        }

        if (vencedores.size() == 1) {
            sb.append("Vencedor: ").append(vencedores.get(0)).append("\n");
        } else {
            sb.append("Empate entre: ").append(String.join(", ", vencedores)).append("\n");
        }

        // Erros
        sb.append("\n--- Erros ---\n");
        if (erros.isEmpty()) {
            sb.append("Nenhum erro encontrado.\n");
        } else {
            for (String erro : erros) {
                sb.append(erro).append("\n");
            }
        }
        return sb.toString();
    }
}
