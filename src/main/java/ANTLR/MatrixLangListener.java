package ANTLR;

// Generated from .\MatrixLang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MatrixLangParser}.
 */
public interface MatrixLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MatrixLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MatrixLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(MatrixLangParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(MatrixLangParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareInt}
	 * labeled alternative in {@link MatrixLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterDeclareInt(MatrixLangParser.DeclareIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareInt}
	 * labeled alternative in {@link MatrixLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitDeclareInt(MatrixLangParser.DeclareIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareMat}
	 * labeled alternative in {@link MatrixLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterDeclareMat(MatrixLangParser.DeclareMatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareMat}
	 * labeled alternative in {@link MatrixLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitDeclareMat(MatrixLangParser.DeclareMatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void enterVariable_list(MatrixLangParser.Variable_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void exitVariable_list(MatrixLangParser.Variable_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefineInt}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void enterDefineInt(MatrixLangParser.DefineIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefineInt}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void exitDefineInt(MatrixLangParser.DefineIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefineMat}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void enterDefineMat(MatrixLangParser.DefineMatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefineMat}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void exitDefineMat(MatrixLangParser.DefineMatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefineOp}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void enterDefineOp(MatrixLangParser.DefineOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefineOp}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void exitDefineOp(MatrixLangParser.DefineOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteOnConsole}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void enterWriteOnConsole(MatrixLangParser.WriteOnConsoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteOnConsole}
	 * labeled alternative in {@link MatrixLangParser#proceso}.
	 * @param ctx the parse tree
	 */
	void exitWriteOnConsole(MatrixLangParser.WriteOnConsoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Substraction}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterSubstraction(MatrixLangParser.SubstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substraction}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitSubstraction(MatrixLangParser.SubstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableOp}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterVariableOp(MatrixLangParser.VariableOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableOp}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitVariableOp(MatrixLangParser.VariableOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(MatrixLangParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(MatrixLangParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(MatrixLangParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(MatrixLangParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterAddition(MatrixLangParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitAddition(MatrixLangParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixOp}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterMatrixOp(MatrixLangParser.MatrixOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixOp}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitMatrixOp(MatrixLangParser.MatrixOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(MatrixLangParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatrixLangParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(MatrixLangParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(MatrixLangParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(MatrixLangParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(MatrixLangParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(MatrixLangParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_main}.
	 * @param ctx the parse tree
	 */
	void enterTk_main(MatrixLangParser.Tk_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_main}.
	 * @param ctx the parse tree
	 */
	void exitTk_main(MatrixLangParser.Tk_mainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_int}.
	 * @param ctx the parse tree
	 */
	void enterTk_int(MatrixLangParser.Tk_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_int}.
	 * @param ctx the parse tree
	 */
	void exitTk_int(MatrixLangParser.Tk_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_matrix}.
	 * @param ctx the parse tree
	 */
	void enterTk_matrix(MatrixLangParser.Tk_matrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_matrix}.
	 * @param ctx the parse tree
	 */
	void exitTk_matrix(MatrixLangParser.Tk_matrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tK_ID}.
	 * @param ctx the parse tree
	 */
	void enterTK_ID(MatrixLangParser.TK_IDContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tK_ID}.
	 * @param ctx the parse tree
	 */
	void exitTK_ID(MatrixLangParser.TK_IDContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_NUM}.
	 * @param ctx the parse tree
	 */
	void enterTk_NUM(MatrixLangParser.Tk_NUMContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_NUM}.
	 * @param ctx the parse tree
	 */
	void exitTk_NUM(MatrixLangParser.Tk_NUMContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_add}.
	 * @param ctx the parse tree
	 */
	void enterTk_add(MatrixLangParser.Tk_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_add}.
	 * @param ctx the parse tree
	 */
	void exitTk_add(MatrixLangParser.Tk_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_sub}.
	 * @param ctx the parse tree
	 */
	void enterTk_sub(MatrixLangParser.Tk_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_sub}.
	 * @param ctx the parse tree
	 */
	void exitTk_sub(MatrixLangParser.Tk_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixLangParser#tk_mult}.
	 * @param ctx the parse tree
	 */
	void enterTk_mult(MatrixLangParser.Tk_multContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixLangParser#tk_mult}.
	 * @param ctx the parse tree
	 */
	void exitTk_mult(MatrixLangParser.Tk_multContext ctx);
}