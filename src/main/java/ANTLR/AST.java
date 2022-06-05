package ANTLR;

import java.util.ArrayList;
import java.util.List;

public class AST {
	static List<String> intVars;
	static List<String> matVars;
	static List<Integer> intValues;
	static List<int[][]> matValues;
	
        // Constructor de arbol de sintaxis abstracta - O(1)
	public AST() {
		AST.intVars = new ArrayList<String>();
		AST.matVars = new ArrayList<String>();
		AST.intValues = new ArrayList<Integer>();
		AST.matValues = new ArrayList<int[][]>();
	}

        // Agregando nuevo nombre de variable int en AST - O(1)
	public static void addIntVar(String var) {
		intVars.add(var);
		intValues.add(null);
	}

        // Agregando nuevo nombre de variable mat en AST - O(1)
	public static void addMatVar(String var) {
		matVars.add(var);
		matValues.add(null);
	}

        // Asignando valor a variable int - O(n)
	public static void addIntValue(String var, int value) {
		for (int i = 0; i < intVars.size(); i++) {
			if (intVars.get(i).equals(var)) {
				intValues.set(i, value);
				return;
			}
		}
	}

        // Asignando valor a variable mat - O(n)
	public static void addMatValue(String var, int[][] value) {
		for (int i = 0; i < matVars.size(); i++) {
			if (matVars.get(i).equals(var)) {
				matValues.set(i, value);
				return;
			}
		}
	}

        // Recuperando valor de la variable int - O(n)
	public static int getIntValue(String var) {
		int i = 0;
		while (i < intVars.size() && !intVars.get(i).equals(var)) {
			i++;
		}
		return intValues.get(i);
	}

        // Recuperando valor de la variable mat - O(n)
	public static int[][] getMatValue(String var) {
		int i = 0;
		while (i < matVars.size() && !matVars.get(i).equals(var)) {
			i++;
		}
		return matValues.get(i);
	}

        // Verificando si una variable tipo int existe - O(n)
	public static boolean intVarExist(String var) {
		for (String stored : intVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		for (String stored : matVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		return false;
	}
        
        // Verificando si una variable tipo mat existe - O(n)
	public static boolean matVarExist(String var) {
		for (String stored : intVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		for (String stored : matVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		return false;
	}
}