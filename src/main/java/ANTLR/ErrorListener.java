package ANTLR;

import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.*;

public class ErrorListener extends ConsoleErrorListener {

	public List<Integer> errorLocation = new ArrayList<>();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		System.err.println("Error de sintaxis en linea " + line + ":" + charPositionInLine + ": " + msg);
		errorLocation.add(line);
	}

}
