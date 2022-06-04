package ANTLR;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Translator {
	ErrorListener err, err2;
	List <Integer> lexerErrorsPos;
	List <String> lexerErrorsMsg;
	List <Integer> parserErrorsPos;
	List <String> parserErrorsMsg;

	private MatrixLangLexer lexer;
	private MatrixLangParser parser;
	private ParseTree tree;

	private String sourceCode;

	public int semanticErrorPos;
	public String semanticErrorMsg;
	
	public Translator () {
		err = new ErrorListener();
		err2 = new ErrorListener();
		lexerErrorsPos = new ArrayList<Integer>();
		lexerErrorsMsg = new ArrayList<String>();
		parserErrorsPos = new ArrayList<Integer>();
		parserErrorsMsg = new ArrayList<String>();
	}

	public void updateCheck (String newSource) {
		sourceCode = newSource;
		analyze();
	}

	private void analyze () {
		lexer = new MatrixLangLexer(CharStreams.fromString(sourceCode));
		lexer.removeErrorListeners();
		lexer.addErrorListener(err);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new MatrixLangParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(err2);
		tree = parser.prog();
		lexerErrorsPos = err.errorLocation;
		lexerErrorsMsg = err.errorMessage;
		parserErrorsPos = err2.errorLocation;
		parserErrorsMsg = err2.errorMessage;
	}

	public List<Integer> lexerErrorsPos () {		
		return lexerErrorsPos;
	}

	public List<String> lexerErrorsMsg () {
		return lexerErrorsMsg;
	}

	public List<Integer> parserErrorsPos () {
		return parserErrorsPos;
	}

	public List<String> parserErrorsMsg () {
		return parserErrorsMsg;
	}

	public void translate (String outputFile) {
		ParseTreeWalker walker = new ParseTreeWalker();
		MatrixLangBaseListener listener = new MatrixLangBaseListener(outputFile);
		try {
			walker.walk(listener, tree);
			// Escribir archivo de salida
			System.out.println(listener.getOutputFile());
			// Imprimir en consola matrices de write
			for (int [][] mat : listener.writeList) {
				System.out.println("Matriz: ");
				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						System.out.print(mat[i][j] + "\t");
					}
					System.out.println();
				}
				System.out.println("");
			}
		} catch (CancellationException e) {
			// Mensaje de error semantico por imprimir en consola
			semanticErrorPos = listener.semanticErrorPos;
			semanticErrorMsg = listener.semanticErrorMsg;
			System.out.println(semanticErrorMsg);
			System.out.println("Traduccion abortada.");
			// Localizacion de error en el codigo fuente
			System.out.println("Error en caracter " + semanticErrorPos);
		}
	}
}