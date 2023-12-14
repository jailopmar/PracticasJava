package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.List2;

public class Ejercicio3 {

	public static List<String> ejercicio3Iterativa(List<String> a, List<String> b) {

		List<String> res = List2.empty();
		int i = 0;
		int j = 0;

		while (i < a.size() || j < b.size()) {
			if (i < a.size()) {
				res.add(a.get(i));
				i++;
				if (i < a.size()) {
					res.add(a.get(i));
					i++;
				}
			}

			if (j < b.size()) {
				res.add(b.get(j));
				j++;
				if (j < b.size()) {
					res.add(b.get(j));
					j++;
				}
			}
		}

		return res;
	}

	public static List<String> ejercicio3RecursivaFinal(List<String> a, List<String> b) {
		int i = 0;
		int j = 0; 
		return recursiva(a, b, i, j);
	}

	private static List<String> recursiva(List<String> a, List<String> b, int i, int j) {

		List<String> res = new ArrayList<>();
		if (!(i < a.size() || j < b.size())) {
			return res;
		}
		if (i < a.size()) {
			res.add(a.get(i));
			if (i + 1 < a.size()) {
				res.add(a.get(i + 1));
			}
		}
		if (j < b.size()) {

			res.add(b.get(j));
			if (j + 1 < b.size()) {
				res.add(b.get(j + 1));
			}
		}
		res.addAll(recursiva(a, b, i + 2, j + 2));
		return res;
	}

}
