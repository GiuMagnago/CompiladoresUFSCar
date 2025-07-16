// Generated from br\u005Cufscar\dc\compiladores\t6\eleicoes.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t6;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link eleicoesParser}.
 */
public interface eleicoesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link eleicoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(eleicoesParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link eleicoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(eleicoesParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link eleicoesParser#candidatoDecl}.
	 * @param ctx the parse tree
	 */
	void enterCandidatoDecl(eleicoesParser.CandidatoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link eleicoesParser#candidatoDecl}.
	 * @param ctx the parse tree
	 */
	void exitCandidatoDecl(eleicoesParser.CandidatoDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link eleicoesParser#urnaDecl}.
	 * @param ctx the parse tree
	 */
	void enterUrnaDecl(eleicoesParser.UrnaDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link eleicoesParser#urnaDecl}.
	 * @param ctx the parse tree
	 */
	void exitUrnaDecl(eleicoesParser.UrnaDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link eleicoesParser#votoDecl}.
	 * @param ctx the parse tree
	 */
	void enterVotoDecl(eleicoesParser.VotoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link eleicoesParser#votoDecl}.
	 * @param ctx the parse tree
	 */
	void exitVotoDecl(eleicoesParser.VotoDeclContext ctx);
}