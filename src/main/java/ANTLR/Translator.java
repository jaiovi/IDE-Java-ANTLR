package ANTLR;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Translator {
	ErrorListener err, err2;
	List <Integer> lexerErrors;
	List <Integer> parserErrors;

	private MatrixLangLexer lexer;
	private MatrixLangParser parser;
	private ParseTree tree;

	private String sourceCode;
	
	public Translator () {
		err = new ErrorListener();
		err2 = new ErrorListener();
		lexerErrors = new ArrayList<Integer>();
		parserErrors = new ArrayList<Integer>();
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
		lexerErrors = err.errorLocation;
		parserErrors = err2.errorLocation;
	}

	public List<Integer> lexerErrors () {		
		return lexerErrors;
	}

	public List<Integer> parserErrors () {
		return parserErrors;
	}

	public void translate (String outputFile) {
		ParseTreeWalker walker = new ParseTreeWalker();
		MatrixLangBaseListener listener = new MatrixLangBaseListener(outputFile);
		try {
			walker.walk(listener, tree);
			System.out.println(listener.getOutputFile());
		} catch (CancellationException e) {
			//TODO: handle exception
			System.out.println("Semantic error detected. Translation aborted.");
		}
	}
}