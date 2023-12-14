package Ejercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.traverse.TopologicalOrderIterator;

import Tipos.RelacionTareas;
import Tipos.Tarea;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.Set2;

public class Ejercicio3 {

	private static String carpetaResultados = "resultados/ejercicio3/";

	public static List<Tarea> ejercicio3A(Graph<Tarea, RelacionTareas> g) {

		List<Tarea> res = new ArrayList<>();
		TopologicalOrderIterator<Tarea, RelacionTareas> alg = new TopologicalOrderIterator<Tarea, RelacionTareas>(g);

		alg.forEachRemaining(v -> res.add(v));

		return res;
	}

	public static Set<Tarea> ejercicio3B(Graph<Tarea, RelacionTareas> g, Tarea tareaActual,
			Set<Tarea> visitados, Set<Tarea> tareasPrevias, String fichero) {
		if (visitados.contains(tareaActual)) {
			return tareasPrevias;
		}

		visitados.add(tareaActual);
		for (RelacionTareas edge : g.incomingEdgesOf(tareaActual)) {
			Tarea tareaPrevia = g.getEdgeSource(edge);
			tareasPrevias.add(tareaPrevia);
			ejercicio3B(g, tareaPrevia, visitados, tareasPrevias, fichero);
		}
		
		
		return tareasPrevias;
	}

}
