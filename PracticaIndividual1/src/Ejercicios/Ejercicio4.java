package Ejercicios;

import java.util.HashMap;
import java.util.Map;
import us.lsi.common.IntPair;

public class Ejercicio4 {

	public static String ejercicio4SinMemoria(Integer a, Integer b) {

		String res = "";

		if (a <= 4) {
			res = a.toString() + "." + b.toString();

		} else if (b <= 4) {
			res = b.toString() + "-" + a.toString();

		} else {

			res = ejercicio4SinMemoria(a / 2, b - 2) + "," + ejercicio4SinMemoria(a - 2, b / 2) + ","
					+ ejercicio4SinMemoria(a - 1, b - 1);
		}

		return res;
	}

	public static String ejercicio4ConMemoria(Integer a, Integer b) {

		Map<IntPair, String> map = new HashMap<>();
		return recursiva(a, b, map);

	}

	private static String recursiva(Integer a, Integer b, Map<IntPair, String> map) {

		String res = map.get(IntPair.of(a, b));

		if (res == null) {
			if (a <= 4) {
				res = a.toString() + "." + b.toString();
			} else if (b <= 4) {
				res = b.toString() + "-" + a.toString();
			} else {
				res = recursiva(a / 2, b - 2, map) + "," + recursiva(a - 2, b / 2, map) + ","
						+ recursiva(a - 1, b - 1, map);
			}
			map.put(IntPair.of(a, b), res);
		}
		return res;
	}

	public static String ejercicio4Iterativa(Integer a, Integer b) {

		String res = "";
		Map<IntPair, String> map = new HashMap<>();

		for (Integer i = 0; i <= a; i++) {
			for (Integer j = 0; j <= b; j++) {
				if (i <= 4) {
					res = i.toString() + "." + j.toString();
				} else if (j <= 4) {
					res = j.toString() + "-" + i.toString();
				} else {
					res = map.get(IntPair.of(i / 2, j - 2)) + "," + map.get(IntPair.of(i - 2, j / 2)) + ","
							+ map.get(IntPair.of(i - 1, j - 1));
				}
				map.put(IntPair.of(i,j), res);
			}
		}
		return map.get(IntPair.of(a,b));
	}

}
