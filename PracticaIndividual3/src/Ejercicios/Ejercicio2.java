package Ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.tour.HeldKarpTSP;

import Tipos.Atraccion;
import Tipos.Vecindad;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.List2;

public class Ejercicio2 {

	private static String carpetaResultados = "resultados/ejercicio2/";

	public static GraphPath<Atraccion, Vecindad> ejercicio2A(Graph<Atraccion, Vecindad> g, Atraccion vertexStart,
			Atraccion vertexEnd, String fichero) {

		DijkstraShortestPath<Atraccion, Vecindad> dijkstraAlg = new DijkstraShortestPath<>(g);
		GraphPath<Atraccion, Vecindad> shortestPath = dijkstraAlg.getPath(vertexStart, vertexEnd);

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoA.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.colorIf(Color.magenta, shortestPath.getVertexList().contains(v)),
				e -> GraphColors.colorIf(Color.magenta, shortestPath.getEdgeList().contains(e)));

		return shortestPath;
	}

	public static GraphPath<Atraccion, Vecindad> ejercicio2B(Graph<Atraccion, Vecindad> g, String fichero) {

		HeldKarpTSP<Atraccion, Vecindad> alg = new HeldKarpTSP<Atraccion, Vecindad>();
		GraphPath<Atraccion, Vecindad> res = alg.getTour(g);

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoB.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.color(res.getVertexList().get(0).equals(v) ? Color.magenta : Color.blue),
				e -> GraphColors.colorIf(Color.blue, res.getEdgeList().contains(e)));

		return res;

	}

	// Apartado C

	public static List<Atraccion> ejercicio2C(Graph<Atraccion, Vecindad> g, Integer numeroHoras) {

		// Declaración de un comparador para ordenar por popularidad
		Comparator<Atraccion> comparacionPopularidad = (atraccion1, aatraccion2) -> atraccion1.popularidad()
				.compareTo(aatraccion2.popularidad());

		// Obtención de la atracción más popular usando el comparador
		Atraccion masPopular = g.vertexSet().stream().max(comparacionPopularidad).get();

		// Cálculo de las horas restantes restando la duración y el tiempo de espera de
		// la atracción más popular
		Double horasRestantes = numeroHoras - (masPopular.duracion() + masPopular.tiempo()) / 60.;

		return ejercicio2C(g, horasRestantes, masPopular, List2.empty());
	}

	private static List<Atraccion> ejercicio2C(Graph<Atraccion, Vecindad> g, Double horasRestantes,
			Atraccion masPopular, List<Atraccion> res) {

		//Si no hay horas restantes o no hay atracciones para visitar
		if (horasRestantes <= 0 || masPopular == null) {
			return res;

			
		} else {
			//Agregar atracción actual a la lista
			res.add(masPopular);

			// Encuentra el vecino más popular y actualiza las horas restantes
			Atraccion vecino = vecinoMasPopular(masPopular, g, res);
			Vecindad path = g.getEdge(masPopular, vecino);
			horasRestantes -= tiempoPorAtraccion(vecino, path);

			return ejercicio2C(g, horasRestantes, vecino, res);
		}
	}

	private static Atraccion vecinoMasPopular(Atraccion a, Graph<Atraccion, Vecindad> g, List<Atraccion> res) {
		Set<Atraccion> vecinos = new HashSet<>();

		// Itera sobre las vecindades de la atracción actual
		for (Vecindad r : g.edgesOf(a)) {
			Atraccion source = g.getEdgeSource(r);
			Atraccion target = g.getEdgeTarget(r);

			// Agrega vecinos que no han sido visitados a la lista
			if (!res.contains(source)) {
				vecinos.add(source);
			}
			if (!res.contains(target)) {
				vecinos.add(target);
			}
		}

		// Compara los vecinos por popularidad y devuelve el más popular
		Comparator<Atraccion> comparacionVecinos = Comparator.comparing(Atraccion::popularidad);

		return vecinos.stream().max(comparacionVecinos).orElse(null);
	}

	// Calcula el tiempo necesario para visitar una atracción con la información de la vecindad
	private static double tiempoPorAtraccion(Atraccion a, Vecindad e) {
		if (e != null) {
			return (a.duracion() + a.tiempo() + e.tiempo()) / 60.0;
		} else {
			return 0.0;
		}
	}
}
