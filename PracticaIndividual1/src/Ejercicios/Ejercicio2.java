package Ejercicios;

import java.util.Collections;
import java.util.List;

import us.lsi.common.List2;

public class Ejercicio2 {

	public static List<Integer> ejercicio2RecursivaNoFinal(Integer a, Integer b) {

		List<Integer> res = List2.empty();

		if (a < 2 || b < 2) {
			res.add(0, a * b);
		} else if (a > b) {

			res = ejercicio2RecursivaNoFinal(a % b, b - 1);
			res.add(a);
		} else {
			res = ejercicio2RecursivaNoFinal(a - 2, b / 2);
			res.add(b);
		}

		return res;
	}

	public static List<Integer> ejercicio2RecursivaFinal(Integer a, Integer b) {

		List<Integer> res = List2.empty();
		return recursiva(a, b, res);
	}

	private static List<Integer> recursiva(Integer a, Integer b, List<Integer> res) {

		if (a < 2 || b < 2) {
			res.add(0, a * b);

		} else if (a > b) {

			res = recursiva(a % b, b - 1, res);
			res.add(a);

		} else {
			res = recursiva(a - 2, b / 2, res);
			res.add(b);
		}

		return res;
	}

	public static List<Integer> ejercicio2Iterativa(Integer a, Integer b) {

		List<Integer> res = List2.empty();
		while (!(a < 2 || b < 2)) {
			if (a > b) {
				res.add(a);
				a = a % b;
				b = b - 1;
			} else {
				res.add(b);
				a = a - 2;
				b = b / 2;
			}

		}
		if(a < 2 || b < 2) {
			res.add(0, a*b);
		}
		Collections.sort(res); //Ordenar lista de enteros de menor a mayor
		return res;
	}

}
