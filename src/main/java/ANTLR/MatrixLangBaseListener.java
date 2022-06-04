package ANTLR;

// Generated from .\MatrixLang.g4 by ANTLR 4.8

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link MatrixLangListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MatrixLangBaseListener implements MatrixLangListener {

	private String outputFile;
	private StringBuilder sb = new StringBuilder();

	public MatrixLangBaseListener (String outputFile) {
		this.outputFile = outputFile;
	}

	public String getOutputFile () {
		return sb.toString();
	}

	AST ast = new AST();

	public int[][] transpose (int[][] mat) {
		int res[][] = new int[mat[0].length][mat.length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				res[j][i] = mat[i][j];
			}
		}
		return res;
	}

	public int[][] mult (int[][] mat1, int[][] mat2) {

		if (mat1[0].length != mat2.length) {
			return null;
		}

		int res[][] = new int[mat1.length][mat2[0].length];

		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				for (int k = 0; k < mat2.length; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}

		return res;
	}

	public int[][] add (int[][] mat1, int[][] mat2) {

		if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
			return null;
		}

		int res[][] = new int[mat1.length][mat1[0].length];

		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				res[i][j] = mat1[i][j] + mat2[i][j];
			}
		}

		return res;
	}

	public int[][] sub (int[][] mat1, int[][] mat2) {

		if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
			return null;
		}

		int res[][] = new int[mat1.length][mat1[0].length];

		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				res[i][j] = mat1[i][j] - mat2[i][j];
			}
		}

		return res;
	}

	public void print (int [][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Declaration flags
	private boolean declaresInt = false;
	private boolean declaresMat = false;
	// Definition flags
	private boolean definesInt = false;
	private boolean definesMat = false;
	private boolean definesOp = false;
	private boolean write = false;
	private boolean firstArg = false;
	// Length of column of matrix
	private int colLength;

	private String intVar;
	private String matVar;

	private int[][] resultMat = null;
	private int[][] memoryMat = null;
	private int[][] memoryMatSec = null;

	CancellationException exitWalker = new CancellationException();

	public List<int [][]> writeList = new ArrayList<>();

	public int semanticErrorPos;
	public String semanticErrorMsg;

	@Override public void enterProg(MatrixLangParser.ProgContext ctx) {
		sb.append("public class " + outputFile + " {");
		sb.append("\n");
	}
	 
	@Override public void exitProg(MatrixLangParser.ProgContext ctx) { 
		sb.append("}");	
		sb.append("\n");
	}
	 
	@Override public void enterBody(MatrixLangParser.BodyContext ctx) { 
		sb.append("\tpublic static void main (String[] args) {");
		sb.append("\n");
	}
	 
	@Override public void exitBody(MatrixLangParser.BodyContext ctx) { 
		sb.append("\t}");
		sb.append("\n");
	}
	 
	@Override public void enterDeclareInt(MatrixLangParser.DeclareIntContext ctx) { 
		sb.append("\t\tint ");
		declaresInt = true;
	}
	 
	@Override public void exitDeclareInt(MatrixLangParser.DeclareIntContext ctx) { 
		sb.append(";");
		sb.append("\n");
		declaresInt = false;
	}
	 
	@Override public void enterDeclareMat(MatrixLangParser.DeclareMatContext ctx) { 
		sb.append("\t\tint[][] ");
		declaresMat = true;
	}
	 
	@Override public void exitDeclareMat(MatrixLangParser.DeclareMatContext ctx) { 
		sb.append(";");
		sb.append("\n");
		declaresMat = false;
	}
	 
	@Override public void enterVariable_list(MatrixLangParser.Variable_listContext ctx) { 
		String[] vars = ctx.getText().split(",");
		int i = 0;
		for (String var : vars) {
			if (i == vars.length-1) {
				sb.append(var);
			}
			else {
				sb.append(var + ",");
			}
			i++;

			if (declaresInt) {
				AST.addIntVar(var);
			}
			else if (declaresMat) {
				AST.addMatVar(var);
			}
		}
	}
	 
	@Override public void exitVariable_list(MatrixLangParser.Variable_listContext ctx) { }
	 
	@Override public void enterDefineInt(MatrixLangParser.DefineIntContext ctx) { 
		definesInt = true;
	}
	 
	@Override public void exitDefineInt(MatrixLangParser.DefineIntContext ctx) { 
		definesInt = false;
		sb.append(";");
		sb.append("\n");
	}
	 
	@Override public void enterDefineMat(MatrixLangParser.DefineMatContext ctx) { 
		definesMat = true;
	}
	 
	@Override public void exitDefineMat(MatrixLangParser.DefineMatContext ctx) { 
		definesMat = false;
		sb.append(";");
		sb.append("\n");
	}
	 
	@Override public void enterDefineOp(MatrixLangParser.DefineOpContext ctx) { 
		definesOp = true;
	}
	 
	@Override public void exitDefineOp(MatrixLangParser.DefineOpContext ctx) { 
		sb.append(";");
		sb.append("\n");
		AST.addMatValue(matVar, resultMat);
		resultMat = null;
	}
	 
	@Override public void enterWriteOnConsole(MatrixLangParser.WriteOnConsoleContext ctx) { 
		write = true;
		sb.append("\t\tprint(");
	}
	 
	@Override public void exitWriteOnConsole(MatrixLangParser.WriteOnConsoleContext ctx) { 
		if (AST.getMatValue(matVar) == null) {
			semanticErrorPos = ctx.start.getStartIndex();
			semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable no definida (no se puede imprimir)";
			throw exitWalker;
		}
		writeList.add(AST.getMatValue(matVar));
		sb.append(");");
		sb.append("\n");
		write = false;
	}
	 
	@Override public void enterSubstraction(MatrixLangParser.SubstractionContext ctx) { 
		sb.append("sub(");
		firstArg = true;
	}
	 
	@Override public void exitSubstraction(MatrixLangParser.SubstractionContext ctx) { 		
		sb.append(")");
		resultMat = sub(memoryMat, memoryMatSec);
		if (resultMat == null) {
			semanticErrorPos = ctx.start.getStartIndex();
			semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Dimensiones diferentes de matrices (no se puede restar)";
			throw exitWalker;
		}
	}
	 
	@Override public void enterVariableOp(MatrixLangParser.VariableOpContext ctx) { 
		if (!AST.matVarExist(ctx.getText())){
			semanticErrorPos = ctx.start.getStartIndex();
			semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no existe.";
			throw exitWalker;
		}

		sb.append(ctx.getText());

		if (firstArg) {
			memoryMat = AST.getMatValue(ctx.getText());
			if (memoryMat == null) {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no esta definida.";
				throw exitWalker;
			}
		}
		else {
			memoryMatSec = AST.getMatValue(ctx.getText());
			if (memoryMatSec == null) {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no esta definida.";
				throw exitWalker;
			}
		}
	}
	 
	@Override public void exitVariableOp(MatrixLangParser.VariableOpContext ctx) { 
		
	}
	 
	@Override public void enterParenthesis(MatrixLangParser.ParenthesisContext ctx) { 
		sb.append("(");
	}
	 
	@Override public void exitParenthesis(MatrixLangParser.ParenthesisContext ctx) { 
		sb.append(")");
	}
	 
	@Override public void enterMultiplication(MatrixLangParser.MultiplicationContext ctx) { 
		sb.append("mult(");
		firstArg = true;
	}
	 
	@Override public void exitMultiplication(MatrixLangParser.MultiplicationContext ctx) { 
		sb.append(")");
		resultMat = mult(memoryMat, memoryMatSec);
		if (resultMat == null) {
			semanticErrorPos = ctx.start.getStartIndex();
			semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Dimensiones diferentes de matrices (no se puede multiplicar)";
			throw exitWalker;
		}
	}
	 
	@Override public void enterAddition(MatrixLangParser.AdditionContext ctx) { 
		sb.append("add(");
		firstArg = true;
	}
	 
	@Override public void exitAddition(MatrixLangParser.AdditionContext ctx) { 
		sb.append(")");
		resultMat = add(memoryMat, memoryMatSec);
		if (resultMat == null) {
			semanticErrorPos = ctx.start.getStartIndex();
			semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Dimensiones diferentes de matrices (no se puede sumar)";
			throw exitWalker;
		}
	}
	 
	@Override public void enterMatrixOp(MatrixLangParser.MatrixOpContext ctx) { }
	 
	@Override public void exitMatrixOp(MatrixLangParser.MatrixOpContext ctx) { }
	 
	@Override public void enterTranspose(MatrixLangParser.TransposeContext ctx) { 
		sb.append("transpose(");
		firstArg = true;
	}
	 
	@Override public void exitTranspose(MatrixLangParser.TransposeContext ctx) { 
		sb.append(")");
		memoryMat = transpose(memoryMat);
		resultMat = memoryMat;
	}
	 
	@Override public void enterMatrix(MatrixLangParser.MatrixContext ctx) { 
		sb.append("{");
		String matrix = ctx.getText().substring(1, ctx.getText().length()-1);
		colLength = matrix.split(";")[0].split(",").length;
		int[][] mat = new int[matrix.split(";").length][colLength];

		int i = 0;
		int j = 0;

		// Creating variable for AST
		for (String col : matrix.split(";")) {
			if (col.split(",").length != colLength) {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Dimensiones de la matriz no son constantes.";
				throw exitWalker;
			}
			for (String row : col.split(",")) {
				mat[i][j] = Integer.parseInt(row);
				j++;
			}
			j= 0;
			i++;
		}

		mat = transpose(mat);
		AST.addMatValue(matVar, mat);

		// Printing variable definition
		for (i = 0; i < mat.length; i++) {
			sb.append("{");
			for (j = 0; j < mat[i].length; j++) {
				if (j == mat[i].length-1) {
					sb.append(mat[i][j]);
				}
				else {
					sb.append(mat[i][j] + ",");
				}
			}
			if (i == mat.length-1) {
				sb.append("}");
			}
			else {
				sb.append("},");
			}
		}
	}
	 
	@Override public void exitMatrix(MatrixLangParser.MatrixContext ctx) { 
		colLength = -1;
		sb.append("}");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColumn(MatrixLangParser.ColumnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColumn(MatrixLangParser.ColumnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_main(MatrixLangParser.Tk_mainContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_main(MatrixLangParser.Tk_mainContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_int(MatrixLangParser.Tk_intContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_int(MatrixLangParser.Tk_intContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_matrix(MatrixLangParser.Tk_matrixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_matrix(MatrixLangParser.Tk_matrixContext ctx) { }

	// Reporte de analisis semantico (Caso de variables no declaradas)
	@Override public void enterTK_ID(MatrixLangParser.TK_IDContext ctx) { 
		if (definesInt) {
			if (AST.intVarExist(ctx.getText())) {
				intVar = ctx.getText();
				sb.append("\t\t" + intVar + " = ");
			}
			else {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no existe.";
				throw exitWalker;
			}
		}
		else  if (definesMat) {
			if (AST.matVarExist(ctx.getText())) {
				matVar = ctx.getText();
				sb.append("\t\t" + matVar + " = new int[][] ");
			}
			else {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no existe.";
				throw exitWalker;
			}
		}
		else if (definesOp) {
			if (AST.matVarExist(ctx.getText())) {
				matVar = ctx.getText();
				sb.append("\t\t" + matVar + " = ");
				definesOp = false;
			}
			else {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no existe.";
				throw exitWalker;
			}
		}
		else if (write) {
			if (AST.matVarExist(ctx.getText())) {
				matVar = ctx.getText();
				sb.append(matVar);
				write = false;
			}
			else {
				semanticErrorPos = ctx.start.getStartIndex();
				semanticErrorMsg = "Error en linea (" + ctx.start.getLine() + "): Variable " + ctx.getText() + " no existe.";
				throw exitWalker;
			}
		}
	}
	
	@Override public void exitTK_ID(MatrixLangParser.TK_IDContext ctx) { }
	
	@Override public void enterTk_NUM(MatrixLangParser.Tk_NUMContext ctx) { 
		AST.addIntValue(intVar, Integer.parseInt(ctx.getText()));
		sb.append(ctx.getText());
	}
	
	@Override public void exitTk_NUM(MatrixLangParser.Tk_NUMContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_add(MatrixLangParser.Tk_addContext ctx) { 
		sb.append(", ");
		firstArg = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_add(MatrixLangParser.Tk_addContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_sub(MatrixLangParser.Tk_subContext ctx) { 
		sb.append(", ");
		firstArg = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_sub(MatrixLangParser.Tk_subContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_mult(MatrixLangParser.Tk_multContext ctx) { 
		sb.append(", ");
		firstArg = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_mult(MatrixLangParser.Tk_multContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}