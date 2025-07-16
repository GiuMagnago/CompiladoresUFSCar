// Generated from br\u005Cufscar\dc\compiladores\t6\eleicoes.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t6;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link eleicoesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface eleicoesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link eleicoesParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(eleicoesParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link eleicoesParser#candidatoDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCandidatoDecl(eleicoesParser.CandidatoDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link eleicoesParser#urnaDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrnaDecl(eleicoesParser.UrnaDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link eleicoesParser#votoDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVotoDecl(eleicoesParser.VotoDeclContext ctx);
}