package ANTLR;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.*;

public class ErrorListener extends ConsoleErrorListener {

	public List<Integer> errorLocation = new ArrayList<>();
	public List<String> errorMessage = new ArrayList<>();

        // Imprimiendo errores de sintaxis y agregando mensaje y posicion del error a la lista - O(1)
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		System.err.println("Error en linea (" + line + "): " + msg);
		errorLocation.add(line);
		errorMessage.add(msg);
	}

}
