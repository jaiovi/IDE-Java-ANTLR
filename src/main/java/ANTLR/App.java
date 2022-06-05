package ANTLR;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		// Leyendo archivo de entrada
		File file = new File(".\\test.txt");
		StringBuilder sb = new StringBuilder();
		String source_code = "";
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append('\n');
		}
		source_code = sb.toString();

		// Creando objeto de traductor
		Translator translator = new Translator();

		// Analizando el codigo fuente
		translator.updateCheck(source_code);
		
		// Obteniendo errores lexer
		List<Integer> lexerErrors = translator.lexerErrorsPos();
		List<String> lexerErrorsMsg = translator.lexerErrorsMsg();

		// Obteniendo errores parser
		List<Integer> parserErrors = translator.parserErrorsPos();
		List<String> parserErrorsMsg = translator.parserErrorsMsg();

		// Imprimiendo traduccion a java
		translator.translate("Hola");
	}
}