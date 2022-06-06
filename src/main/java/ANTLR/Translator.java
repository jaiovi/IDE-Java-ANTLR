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
        
        public String translation;
        public List<int[][]> outputs;
	
        // Contructor de objeto traductor - O(1)
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

        // Analisis del codiho fuente y recuperacion de errores lexicos y sintacticos - O(n)
	private void analyze () {
		err = new ErrorListener();
		err2 = new ErrorListener();
		lexer = new MatrixLangLexer(CharStreams.fromString(sourceCode));    // O(1)
		lexer.removeErrorListeners();   // O(1)
		lexer.addErrorListener(err);    // O(1)
		CommonTokenStream tokens = new CommonTokenStream(lexer);    // O(1)
		parser = new MatrixLangParser(tokens);
		parser.removeErrorListeners();  // O(1)
		parser.addErrorListener(err2);  // O(1)
                // Analisis del codigo fuente - O(n)
		tree = parser.prog();
		lexerErrorsPos = err.errorLocation;
		lexerErrorsMsg = err.errorMessage;
		parserErrorsPos = err2.errorLocation;
		parserErrorsMsg = err2.errorMessage;
	}

        // Recuperando lista de posicion de errores lexicos - O(1)
	public List<Integer> lexerErrorsPos () {		
		return lexerErrorsPos;
	}
        // Recuperando lista de mensajes de errores lexicos - O(1)
	public List<String> lexerErrorsMsg () {
		return lexerErrorsMsg;
	}
        // Recuperando lista de posicion de errores sintacticos - O(1)
	public List<Integer> parserErrorsPos () {
		return parserErrorsPos;
	}
        // Recuperando lista de mensajes de errores sintacticos - O(1)
	public List<String> parserErrorsMsg () {
		return parserErrorsMsg;
	}

        // Proceso de traduccion a lenguaje Java - O(n)
	public boolean translate (String outputFile) {
		ParseTreeWalker walker = new ParseTreeWalker(); // O(1)
		MatrixLangBaseListener listener = new MatrixLangBaseListener(outputFile);   //O(1_
		try {
			walker.walk(listener, tree);    // O(n) ~ O(log(n))
			// Escribir archivo de salida
                        translation = listener.getOutputFile();
			// System.out.println(listener.getOutputFile());
			// Imprimir en consola matrices de write
                        outputs = listener.writeList;
                        return true;
		} catch (CancellationException e) {
			// Mensaje de error semantico por imprimir en consola
			semanticErrorPos = listener.semanticErrorPos;
			semanticErrorMsg = listener.semanticErrorMsg;
			System.out.println(semanticErrorMsg);
			System.out.println("Traduccion abortada.");
			// Localizacion de error en el codigo fuente
			System.out.println("Error en caracter " + semanticErrorPos);
                        return false;
		}
	}
}