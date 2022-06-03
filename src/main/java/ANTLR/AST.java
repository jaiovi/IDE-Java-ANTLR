package ANTLR;

import java.util.ArrayList;
import java.util.List;

public class AST {
	static List<String> intVars;
	static List<String> matVars;
	static List<Integer> intValues;
	static List<int[][]> matValues;
	
	public AST() {
		AST.intVars = new ArrayList<String>();
		AST.matVars = new ArrayList<String>();
		AST.intValues = new ArrayList<Integer>();
		AST.matValues = new ArrayList<int[][]>();
	}

	public static void addIntVar(String var) {
		intVars.add(var);
		intValues.add(null);
	}

	public static void addMatVar(String var) {
		matVars.add(var);
		matValues.add(null);
	}

	public static void addIntValue(String var, int value) {
		for (int i = 0; i < intVars.size(); i++) {
			if (intVars.get(i).equals(var)) {
				intValues.set(i, value);
				return;
			}
		}
	}

	public static void addMatValue(String var, int[][] value) {
		for (int i = 0; i < matVars.size(); i++) {
			if (matVars.get(i).equals(var)) {
				matValues.set(i, value);
				return;
			}
		}
	}

	public static int getIntValue(String var) {
		int i = 0;
		while (i < intVars.size() && !intVars.get(i).equals(var)) {
			i++;
		}
		return intValues.get(i);
	}

	public static int[][] getMatValue(String var) {
		int i = 0;
		while (i < matVars.size() && !matVars.get(i).equals(var)) {
			i++;
		}
		return matValues.get(i);
	}

	public static boolean intVarExist(String var) {
		for (String stored : intVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		return false;
	}

	public static boolean matVarExist(String var) {
		for (String stored : matVars) {
			if (stored.equals(var)) {
				return true;
			}
		}
		return false;
	}
}
