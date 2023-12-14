package Ejercicios;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class Ejercicio1 {

	private static Integer nMin = 1000;
	private static Integer nMax = 12000;
	private static Integer nIncr = 2500; // Incremento
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 1000; // número de iteraciones para warmup

	private static Double recursivaDouble(Integer a) {

		if (a < 6) {
			return 10.;
		} else {
			return Math.pow(a, 3) * (recursivaDouble(a - 1));
		}
	}

	private static BigInteger recursivaBig(Integer a) {

		if (a < 6) {
			return BigInteger.valueOf(10);
		} else {
			return BigInteger.valueOf(a).multiply(BigInteger.valueOf(a)).multiply(BigInteger.valueOf(a))
					.multiply(recursivaBig(a - 1));
		}
	}

	private static Double iterativaDouble(Integer a) {

		Double res = 10.;
		while (!(a < 6)) {
			res *= Math.pow(a, 3);
			a = a - 1;
		}
		return res;
	}

	private static BigInteger iterativaBig(Integer a) {

		BigInteger res = BigInteger.valueOf(10);
		while (!(a < 6)) {
			res = BigInteger.valueOf(a).multiply(BigInteger.valueOf(a)).multiply(BigInteger.valueOf(a)).multiply(res);
			a = a - 1;
		}
		return res;
	}

	// ---------------------- GEN DATA ----------------------

	public static void recursivaDoubleGenData() {

		String fichero = "ficheros/recursivaDouble.txt";
		Consumer<Integer> num = i -> recursivaDouble(i);
		Function<Integer, Long> f = GenData.time(num);
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);

	}

	public static void recursivaBigGenData() {

		String fichero = "ficheros/recursivaBigInteger.txt";
		Consumer<Integer> num = i -> recursivaBig(i);
		Function<Integer, Long> f = GenData.time(num);
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);

	}

	public static void iterativaDoubleGenData() {

		String fichero = "ficheros/iterativaDouble.txt";
		Consumer<Integer> num = i -> iterativaDouble(i);
		Function<Integer, Long> f = GenData.time(num);
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}

	public static void iterativaBigGenData() {

		String fichero = "ficheros/iterativaBigInteger.txt";
		Consumer<Integer> num = i -> iterativaBig(i);
		Function<Integer, Long> f = GenData.time(num);
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}

	// ------------------------ GRAFICAS ----------------------

	public static void showGraph(String fichero, String nombre) {

		List<WeightedObservedPoint> datos = DataFile.points(fichero);
		Fit ajuste = PowerLog.of(List.of(Pair.of(2, 0.), Pair.of(3, 0.)));
		ajuste.fit(datos);
		MatPlotLib.show(fichero, ajuste.getFunction(), String.format("%s %s", nombre, ajuste.getExpression()));
	}

	public static void showCombined() {

		MatPlotLib.showCombined("Tiempos",
				List.of("ficheros/recursivaDouble.txt", "ficheros/recursivaBigInteger.txt",
						"ficheros/iterativaDouble.txt", "ficheros/iterativaBigInteger.txt"),
				List.of("Recursiva Double", "Recursiva BigInteger", "Iterativa Double", "Iterativa BigInteger"));
	}

	public static void showCombinedDouble() {

		MatPlotLib.showCombined("Tiempos", List.of("ficheros/recursivaDouble.txt", "ficheros/iterativaDouble.txt"),
				List.of("Recursiva Double", "Iterativa Double"));
	}

}
