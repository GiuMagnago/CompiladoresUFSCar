// Generated from br\u005Cufscar\dc\compiladores\t5\t5Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link t5SintaxeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface t5SintaxeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(t5SintaxeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(t5SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(t5SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(t5SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(t5SintaxeParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(t5SintaxeParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(t5SintaxeParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(t5SintaxeParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(t5SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(t5SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(t5SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(t5SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(t5SintaxeParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(t5SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(t5SintaxeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(t5SintaxeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(t5SintaxeParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(t5SintaxeParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(t5SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(t5SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(t5SintaxeParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(t5SintaxeParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(t5SintaxeParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(t5SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(t5SintaxeParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(t5SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(t5SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(t5SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(t5SintaxeParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(t5SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(t5SintaxeParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(t5SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(t5SintaxeParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(t5SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(t5SintaxeParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(t5SintaxeParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(t5SintaxeParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(t5SintaxeParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(t5SintaxeParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(t5SintaxeParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(t5SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(t5SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(t5SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(t5SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(t5SintaxeParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(t5SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(t5SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(t5SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(t5SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t5SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(t5SintaxeParser.Op_logico_2Context ctx);
}