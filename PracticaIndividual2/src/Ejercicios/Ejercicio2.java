package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;
import us.lsi.recursivos.problemasdelistas.ProblemasDeListas;

public class Ejercicio2 {

	private static Integer nMin = 1000;
	private static Integer nMax = 12000;
	private static Integer nIncr = 2500;
	private static Integer nIter = 50;
	private static Integer nIterWarmup = 1000;
	private static List<Integer> list = List.of();

	private static void generaListaEnteros(Integer t) {

		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {
			ls.add(new Random(System.nanoTime()).nextInt(t * 1000));
		}
		list = ls;
	}
	
	// ---------------------- GEN DATA ----------------------

	public static void MergeSortGenDataUmbral1() {

		String fichero = String.format("ficheros/Ej2-1.txt");
		Consumer<Integer> num = i -> generaListaEnteros(i);
		Function<Integer, Long> f = GenData.time(num, t -> ProblemasDeListas.mergeSort(list, 1)); // Umbral 1
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void MergeSortGenDataUmbral4() {

		String fichero = String.format("ficheros/Ej2-4.txt");
		Consumer<Integer> num = i -> generaListaEnteros(i);
		Function<Integer, Long> f = GenData.time(num, t -> ProblemasDeListas.mergeSort(list, 4)); // Umbral 4
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void MergeSortGenDataUmbral16() {

		String fichero = String.format("ficheros/Ej2-16.txt");
		Consumer<Integer> num = i -> generaListaEnteros(i);
		Function<Integer, Long> f = GenData.time(num, t -> ProblemasDeListas.mergeSort(list, 16)); // Umbral 16
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void MergeSortGenDataUmbral64() {

		String fichero = String.format("ficheros/Ej2-64.txt");
		Consumer<Integer> num = i -> generaListaEnteros(i);
		Function<Integer, Long> f = GenData.time(num, t -> ProblemasDeListas.mergeSort(list, 64)); // Umbral 64
		GenData.tiemposEjecucionAritmetica(f, fichero, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void MergeSortGenDataUmbral256() {

		String fichero = String.format("ficheros/Ej2-256.txt");
		Consumer<Integer> num = i -> generaListaEnteros(i);
		Function<Integer, Long> f = GenData.time(num, t -> ProblemasDeListas.mergeSort(list, 256)); // Umbral 256
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
				List.of("ficheros/Ej2-1.txt", "ficheros/Ej2-4.txt",
						"ficheros/Ej2-16.txt", "ficheros/Ej2-64.txt", "ficheros/Ej2-256.txt"),
				List.of("Umbral 1", "Umbral 4", "Umbral 16", "Umbral 64", "Umbral 256"));
	}

}
