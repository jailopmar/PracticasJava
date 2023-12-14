package Tests;

import Tipos.Relacion;
import Tipos.Usuario;
import us.lsi.graphs.GraphsReader;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

public class Test1 {

	private static String fichero = "ficheros/";

	private static String fichero1_1 = "ejercicio1_1";
	private static String rutaFichero1 = fichero + fichero1_1 + ".txt";

	private static String fichero1_2 = "ejercicio1_2";
	private static String rutaFichero2 = fichero + fichero1_2 + ".txt";

	private static String fichero1_3 = "ejercicio1_3";
	private static String rutaFichero3 = fichero + fichero1_3 + ".txt";

	private static String carpetaResultados = "resultados/ejercicio1/";

	private static Graph<Usuario, Relacion> g1 = GraphsReader.newGraph(rutaFichero1, Usuario::ofFormat,
			Relacion::ofFormat, Graphs2::simpleDirectedWeightedGraph, Relacion::interaccion);

	private static Graph<Usuario, Relacion> g2 = GraphsReader.newGraph(rutaFichero2, Usuario::ofFormat,
			Relacion::ofFormat, Graphs2::simpleDirectedWeightedGraph, Relacion::interaccion);

	private static Graph<Usuario, Relacion> g3 = GraphsReader.newGraph(rutaFichero3, Usuario::ofFormat,
			Relacion::ofFormat, Graphs2::simpleDirectedWeightedGraph, Relacion::interaccion);

	public static void main(String[] args) {

		GraphColors.toDot(g1, carpetaResultados + "ejercicio1Original1.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.color(Color.black),
				e -> GraphColors.color(Color.black));

		GraphColors.toDot(g2, carpetaResultados + "ejercicio1Original2.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.color(Color.black),
				e -> GraphColors.color(Color.black));

		GraphColors.toDot(g3, carpetaResultados + "ejercicio1Original3.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.color(Color.black),
				e -> GraphColors.color(Color.black));

		System.out.println(
				"Todos los grafos originales del ejercicio 1 se han guardado en la carpeta " + carpetaResultados);

		System.out.println("\nAPARTADO A \n");
		testEjercicio1A();
		System.out.println("======================================================================================");
		System.out.println("\nAPARTADO B \n");
		testEjercicio1B();
		System.out.println("======================================================================================");
		System.out.println("\nAPARTADO C \n");
		testEjercicio1C();
		System.out.println("======================================================================================");
		System.out.println("\nAPARTADO D \n");
		testEjercicio1D();
	}

	private static void testEjercicio1A() {

		System.out.println("Fichero: " + fichero1_1);

		Set<Usuario> solucionA_1 = Ejercicios.Ejercicio1.ejercicio1A(g1, fichero1_1);
		System.out.println(
				"\nLos usuarios que siguen a mas de 3 usuarios y con un índice de interacción de media de más de 2.5 son: "
						+ solucionA_1.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_2);

		Set<Usuario> solucionA_2 = Ejercicios.Ejercicio1.ejercicio1A(g2, fichero1_2);
		System.out.println(
				"\nLos usuarios que siguen a mas de 3 usuarios y con un índice de interacción de media de más de 2.5 son: "
						+ solucionA_2.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_3);

		Set<Usuario> solucionA_3 = Ejercicios.Ejercicio1.ejercicio1A(g3, fichero1_3);
		System.out.println(
				"\nLos usuarios que siguen a mas de 3 usuarios y con un índice de interacción de media de más de 2.5 son: "
						+ solucionA_3.stream().map(v -> v.nombre()).toList());

	}

	private static void testEjercicio1B() {

		System.out.println("Fichero: " + fichero1_1);

		List<Set<Usuario>> solucionB_1 = Ejercicios.Ejercicio1.ejercicio1B(g1, fichero1_1);
		System.out.println("Hay " + solucionB_1.size() + " componente(s) conexa(s)");
		for (int i = 0; i < solucionB_1.size(); i++) {
			System.out.println(
					"Componentes conexa " + (i + 1) + ": " + solucionB_1.get(i).stream().map(v -> v.nombre()).toList());
		}

		System.out.println("\nFichero: " + fichero1_2);

		List<Set<Usuario>> solucionB_2 = Ejercicios.Ejercicio1.ejercicio1B(g2, fichero1_2);
		System.out.println("Hay " + solucionB_2.size() + " componente(s) conexa(s)");
		for (int i = 0; i < solucionB_2.size(); i++) {
			System.out.println(
					"Componentes conexa " + (i + 1) + ": " + solucionB_2.get(i).stream().map(v -> v.nombre()).toList());
		}

		System.out.println("\nFichero: " + fichero1_3);

		List<Set<Usuario>> solucionB_3 = Ejercicios.Ejercicio1.ejercicio1B(g3, fichero1_3);
		System.out.println("Hay " + solucionB_3.size() + " componente(s) conexa(s)");
		for (int i = 0; i < solucionB_3.size(); i++) {
			System.out.println(
					"Componentes conexa " + (i + 1) + ": " + solucionB_3.get(i).stream().map(v -> v.nombre()).toList());
		}

	}

	private static void testEjercicio1C() {

		System.out.println("Fichero: " + fichero1_1);

		Set<Usuario> solucionC_1 = Ejercicios.Ejercicio1.ejercicio1C(g1, fichero1_1);
		System.out.println("Usuarios seleccionados:  " + solucionC_1.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_2);

		Set<Usuario> solucionC_2 = Ejercicios.Ejercicio1.ejercicio1C(g2, fichero1_2);
		System.out.println("Usuarios seleccionados:  " + solucionC_2.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_3);

		Set<Usuario> solucionC_3 = Ejercicios.Ejercicio1.ejercicio1C(g3, fichero1_3);
		System.out.println("Usuarios seleccionados:  " + solucionC_3.stream().map(v -> v.nombre()).toList());

	}

	private static void testEjercicio1D() {

		System.out.println("Fichero: " + fichero1_1);

		Set<Usuario> solucionD_1 = Ejercicios.Ejercicio1.ejercicio1D(g1, fichero1_1);
		System.out.println(
				"Los usuarios con mayor interacción media son:  " + solucionD_1.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_2);

		Set<Usuario> solucionD_2 = Ejercicios.Ejercicio1.ejercicio1D(g2, fichero1_2);
		System.out.println(
				"Los usuarios con mayor interacción media son:  " + solucionD_2.stream().map(v -> v.nombre()).toList());

		System.out.println("\nFichero: " + fichero1_3);

		Set<Usuario> solucionD_3 = Ejercicios.Ejercicio1.ejercicio1D(g3, fichero1_3);
		System.out.println(
				"Los usuarios con mayor interacción media son:  " + solucionD_3.stream().map(v -> v.nombre()).toList());

	}

}
