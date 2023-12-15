package Tests;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

import Tipos.Atraccion;
import Tipos.Vecindad;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Test2 {

	private static String fichero = "ficheros/";

	private static String fichero2_1 = "ejercicio2_1";
	private static String rutaFichero1 = fichero + fichero2_1 + ".txt";

	private static String fichero2_2 = "ejercicio2_2";
	private static String rutaFichero2 = fichero + fichero2_2 + ".txt";

	private static String fichero2_3 = "ejercicio2_3";
	private static String rutaFichero3 = fichero + fichero2_3 + ".txt";

	private static String carpetaResultados = "resultados/ejercicio2/";

	// Grafos original 1 Teniendo en cuenta distanciaKm en aristas

	private static Graph<Atraccion, Vecindad> g1 = GraphsReader.newGraph(rutaFichero1, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::distanciaKm);

	// Grafo original 2 Teniendo en cuenta distanciaKm en aristas

	private static Graph<Atraccion, Vecindad> g2 = GraphsReader.newGraph(rutaFichero2, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::distanciaKm);

	// Grafo original 3 Teniendo en cuenta distanciaKm en aristas

	private static Graph<Atraccion, Vecindad> g3 = GraphsReader.newGraph(rutaFichero3, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::distanciaKm);

	// Grafo original 1 Teniendo en cuenta tiempo en aristas

	private static Graph<Atraccion, Vecindad> g1_tiempo = GraphsReader.newGraph(rutaFichero1, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::tiempo);

	// Grafo original 2 Teniendo en cuenta tiempo en aristas

	private static Graph<Atraccion, Vecindad> g2_tiempo = GraphsReader.newGraph(rutaFichero2, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::tiempo);

	// Grafo original 3 Teniendo en cuenta tiempo en aristas

	private static Graph<Atraccion, Vecindad> g3_tiempo = GraphsReader.newGraph(rutaFichero3, Atraccion::ofFormat,
			Vecindad::ofFormat, Graphs2::simpleWeightedGraph, Vecindad::tiempo);

	public static void main(String[] args) {

		GraphColors.toDot(g1, carpetaResultados + "ejercicio2Original1.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		GraphColors.toDot(g2, carpetaResultados + "ejercicio2Original2.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		GraphColors.toDot(g3, carpetaResultados + "ejercicio2Original3.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		System.out.println(
				"Todos los grafos originales del ejercicio 2 se han guardado en la carpeta " + carpetaResultados);

		System.out.println("\nApartado A\n");
		testEjercicio2A();
		System.out.println("\n============================================================\n");
		System.out.println("\nApartado B\n");
		testEjercicio2B();
		System.out.println("\n============================================================\n");
		System.out.println("\nApartado C\n");
		testEjercicio2C();
	}

	private static void testEjercicio2A() {

		System.out.println("Fichero " + fichero2_1);

		Atraccion verticeOrigen_1 = g1.vertexSet().stream().filter(v -> v.nombre().equals("Coches de choque"))
				.findFirst().get();
		Atraccion verticeDestino_1 = g1.vertexSet().stream().filter(v -> v.nombre().equals("Raton Vacilon")).findFirst()
				.get();

		System.out.println("Atraccion origen: " + verticeOrigen_1.nombre());
		System.out.println("Atraccion destino: " + verticeDestino_1.nombre());
		System.out.println("Camino mas corto en distancia: "
				+ Ejercicios.Ejercicio2.ejercicio2A(g1, verticeOrigen_1, verticeDestino_1, fichero2_1).getVertexList()
						.stream().map(v -> v.nombre()).toList());

		// --------------------------------------------------------------------------------------------------

		System.out.println("\nFichero " + fichero2_2);

		Atraccion verticeOrigen_2 = g2.vertexSet().stream().filter(v -> v.nombre().equals("Coches de choque"))
				.findFirst().get();
		Atraccion verticeDestino_2 = g2.vertexSet().stream().filter(v -> v.nombre().equals("Patitos")).findFirst()
				.get();
		System.out.println("Atraccion origen: " + verticeOrigen_2.nombre());
		System.out.println("Atraccion destino: " + verticeDestino_2.nombre());
		System.out.println("Camino mas corto en distancia: "
				+ Ejercicios.Ejercicio2.ejercicio2A(g2, verticeOrigen_2, verticeDestino_2, fichero2_2).getVertexList()
						.stream().map(v -> v.nombre()).toList());

		// -----------------------------------------------------------------------------------------------------

		System.out.println("\nFichero " + fichero2_3);

		Atraccion verticeOrigen_3 = g3.vertexSet().stream().filter(v -> v.nombre().equals("Casa del Terror"))
				.findFirst().get();
		Atraccion verticeDestino_3 = g3.vertexSet().stream().filter(v -> v.nombre().equals("Pim pam pum")).findFirst()
				.get();

		System.out.println("Atraccion origen: " + verticeOrigen_3.nombre());
		System.out.println("Atraccion destino: " + verticeDestino_3.nombre());
		System.out.println("Camino mas corto en distancia: "
				+ Ejercicios.Ejercicio2.ejercicio2A(g3, verticeOrigen_3, verticeDestino_3, fichero2_3).getVertexList()
						.stream().map(v -> v.nombre()).toList());

	}

	private static void testEjercicio2B() {

		System.out.println("Fichero: " + fichero2_1);

		System.out.println("Camino mas corto en tiempo pasando por por todas las atracciones una sola vez: " + "\n"
				+ Ejercicios.Ejercicio2.ejercicio2B(g1_tiempo, fichero2_1).getVertexList().stream().map(v -> v.nombre())
						.toList());

		System.out.println("\nFichero: " + fichero2_2);
		System.out.println("Camino mas corto en tiempo pasando por por todas las atracciones una sola vez: " + "\n"
				+ Ejercicios.Ejercicio2.ejercicio2B(g2_tiempo, fichero2_2).getVertexList().stream().map(v -> v.nombre())
						.toList());

		System.out.println("\nFichero: " + fichero2_3);
		System.out.println("Camino mas corto en tiempo pasando por por todas las atracciones una sola vez: " + "\n"
				+ Ejercicios.Ejercicio2.ejercicio2B(g3_tiempo, fichero2_3).getVertexList().stream().map(v -> v.nombre())
						.toList());

	}

	private static void testEjercicio2C() {

		System.out.println("Fichero: " + fichero2_1);

		Integer horas_1 = 5;

		List<Atraccion> res_1 = Ejercicios.Ejercicio2.ejercicio2C(g1, horas_1);

		System.out.println("Camino de atracciones mas populares con: " + horas_1 + " horas" + "\n"
				+ res_1.stream().map(v -> v.nombre()).toList());

		GraphColors.toDot(g1, carpetaResultados + fichero2_1 + "ApartadoC.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.colorIf(List.of(res_1.get(0).equals(v), res_1.contains(v)),
						List.of(Color.magenta, Color.blue)),
				e -> GraphColors.colorIf(Color.blue, dibujarAristasC(g1, res_1, e)));

		// ------------------------------------------------------------------------------------------------------------------------

		System.out.println("\nFichero: " + fichero2_2);

		Integer horas_2 = 2;

		List<Atraccion> res_2 = Ejercicios.Ejercicio2.ejercicio2C(g2, horas_2);

		System.out.println("Camino de atracciones mas populares con: " + horas_2 + " horas" + "\n"
				+ res_2.stream().map(v -> v.nombre()).toList());

		GraphColors.toDot(g2, carpetaResultados + fichero2_2 + "ApartadoC.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.colorIf(List.of(res_2.get(0).equals(v), res_2.contains(v)),
						List.of(Color.magenta, Color.blue)),
				e -> GraphColors.colorIf(Color.blue, dibujarAristasC(g2, res_2, e)));

		// ------------------------------------------------------------------------------------------------------------------------

		System.out.println("\nFichero: " + fichero2_3);

		Integer horas_3 = 3;

		List<Atraccion> res_3 = Ejercicios.Ejercicio2.ejercicio2C(g3, horas_3);

		System.out.println("Camino de atracciones mas populares con: " + horas_3 + " horas" + "\n"
				+ res_3.stream().map(v -> v.nombre()).toList());

		GraphColors.toDot(g3, carpetaResultados + fichero2_3 + "ApartadoC.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.colorIf(List.of(res_3.get(0).equals(v), res_3.contains(v)),
						List.of(Color.magenta, Color.blue)),
				e -> GraphColors.colorIf(Color.blue, dibujarAristasC(g3, res_3, e)));

	}

	private static Boolean dibujarAristasC(Graph<Atraccion, Vecindad> g, List<Atraccion> ls, Vecindad edge) {

		Boolean res = false;
		for (int i = 0; i < ls.size() - 1; i++) {
			if (g.getEdge(ls.get(i), ls.get(i + 1)).equals(edge)) {
				res = true;
				break;
			}
		}
		return res;
	}

}
