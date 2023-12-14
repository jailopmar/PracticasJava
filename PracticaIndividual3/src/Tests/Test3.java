package Tests;

import java.util.Set;

import org.jgrapht.Graph;

import Tipos.Atraccion;
import Tipos.RelacionTareas;
import Tipos.Tarea;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.Set2;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Test3 {

	private static String fichero = "ficheros/";

	private static String fichero3_1 = "ejercicio3_1";
	private static String rutaFichero1 = fichero + fichero3_1 + ".txt";

	private static String fichero3_2 = "ejercicio3_2";
	private static String rutaFichero2 = fichero + fichero3_2 + ".txt";

	private static String fichero3_3 = "ejercicio3_3";
	private static String rutaFichero3 = fichero + fichero3_3 + ".txt";

	private static String carpetaResultados = "resultados/ejercicio3/";

	private static Graph<Tarea, RelacionTareas> g1 = GraphsReader.newGraph(rutaFichero1, Tarea::ofFormat,
			RelacionTareas::ofFormat, Graphs2::simpleDirectedGraph);

	private static Graph<Tarea, RelacionTareas> g2 = GraphsReader.newGraph(rutaFichero2, Tarea::ofFormat,
			RelacionTareas::ofFormat, Graphs2::simpleDirectedGraph);

	private static Graph<Tarea, RelacionTareas> g3 = GraphsReader.newGraph(rutaFichero3, Tarea::ofFormat,
			RelacionTareas::ofFormat, Graphs2::simpleDirectedGraph);

	public static void main(String[] args) {

		GraphColors.toDot(g1, carpetaResultados + "ejercicio3Original1.gv", v -> v.nombre(), e -> "Relacion-" + e.id(),
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		GraphColors.toDot(g2, carpetaResultados + "ejercicio3Original2.gv", v -> v.nombre(), e -> "Relacion-" + e.id(),
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		GraphColors.toDot(g3, carpetaResultados + "ejercicio3Original3.gv", v -> v.nombre(), e -> "Relacion-" + e.id(),
				v -> GraphColors.color(Color.black), e -> GraphColors.color(Color.black));

		System.out.println(
				"Todos los grafos originales del ejercicio 3 se han guardado en la carpeta " + carpetaResultados);

		System.out.println("\nApartado A\n");
		testEjercicio3A();
		System.out.println("\n============================================================\n");
		System.out.println("\nApartado B\n");
		testEjercicio3B();

	}

	private static void testEjercicio3A() {

		System.out.println("Fichero " + fichero3_1);

		System.out.println("Orden de tareas: " + "\n" + Ejercicios.Ejercicio3.ejercicio3A(g1));

		System.out.println("\nFichero " + fichero3_2);

		System.out.println("Orden de tareas: " + "\n" + Ejercicios.Ejercicio3.ejercicio3A(g2));

		System.out.println("\nFichero " + fichero3_3);

		System.out.println("Orden de tareas: " + "\n" + Ejercicios.Ejercicio3.ejercicio3A(g3));

	}

	private static void testEjercicio3B() {

		System.out.println("Fichero " + fichero3_1);

		Tarea tareaElegida_1 = g1.vertexSet().stream().filter(v -> v.nombre().equals("Tarea5")).findFirst().get();
		Set<Tarea> res1 = Ejercicios.Ejercicio3.ejercicio3B(g1, tareaElegida_1, Set2.empty(), Set2.empty(), fichero3_1);
		
		System.out.println("Tareas que deben realizarse previamente a " + tareaElegida_1.nombre());
		System.out.println(res1);

		GraphColors.toDot(g1, carpetaResultados + fichero3_1 + "ApartadoB.gv", v -> v.nombre(),
				e -> "Relacion-" + e.id(), v -> GraphColors.color(getColorB(tareaElegida_1, res1, v)),
				e -> GraphColors.color(Color.black));

		// ------------------------------------------------------------------------------------------------------

		System.out.println("\nFichero " + fichero3_2);

		Tarea tareaElegida_2 = g2.vertexSet().stream().filter(v -> v.nombre().equals("Tarea8")).findFirst().get();
		Set<Tarea> res2 = Ejercicios.Ejercicio3.ejercicio3B(g2, tareaElegida_2, Set2.empty(), Set2.empty(), fichero3_2);

		System.out.println("Tareas que deben realizarse previamente a " + tareaElegida_2.nombre());
		System.out.println(res2);

		GraphColors.toDot(g2, carpetaResultados + fichero3_2 + "ApartadoB.gv", v -> v.nombre(),
				e -> "Relacion-" + e.id(), v -> GraphColors.color(getColorB(tareaElegida_2, res2, v)),
				e -> GraphColors.color(Color.black));

		// --------------------------------------------------------------------------------------------------------

		System.out.println("\nFichero " + fichero3_3);

		Tarea tareaElegida_3 = g3.vertexSet().stream().filter(v -> v.nombre().equals("Tarea8")).findFirst().get();
		Set<Tarea> res3 = Ejercicios.Ejercicio3.ejercicio3B(g3, tareaElegida_3, Set2.empty(), Set2.empty(), fichero3_3);

		System.out.println("Tareas que deben realizarse previamente a " + tareaElegida_3.nombre());
		System.out.println(res3);
		
		GraphColors.toDot(g3, carpetaResultados + fichero3_3 + "ApartadoB.gv", v -> v.nombre(),
				e -> "Relacion-" + e.id(), v -> GraphColors.color(getColorB(tareaElegida_3, res3, v)),
				e -> GraphColors.color(Color.black));

		
		

	}

	private static Color getColorB(Tarea tareaElegida, Set<Tarea> res, Tarea z) {

		GraphColors.Color c = Color.black;
		if (res.contains(z))
			c = Color.blue;
		if (z.nombre().equals(tareaElegida.nombre()))
			c = Color.magenta;
		return c;

	}

}
