package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.TopologicalOrderIterator;

import Tipos.RelacionTareas;
import Tipos.Tarea;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.List2;

public class Ejercicio3 {

	private static String carpetaResultados = "resultados/ejercicio3/";

	public static List<Tarea> ejercicio3A(Graph<Tarea, RelacionTareas> g) {

		List<Tarea> res = new ArrayList<>();
		TopologicalOrderIterator<Tarea, RelacionTareas> alg = new TopologicalOrderIterator<Tarea, RelacionTareas>(g);

		alg.forEachRemaining(v -> res.add(v));

		return res;
	}

	public static Set<Tarea> ejercicio3B(Graph<Tarea, RelacionTareas> g, Tarea tareaActual, Set<Tarea> visitados,
			Set<Tarea> tareasPrevias, String fichero) {

		// Si la tarea actual ya ha sido visitada, retorna las tareas previas sin
		// realizar más operaciones
		if (visitados.contains(tareaActual)) {
			return tareasPrevias;
		}

		// Marca la tarea actual como visitada
		visitados.add(tareaActual);

		// Para cada arista entrante de la tarea actual
		for (RelacionTareas edge : g.incomingEdgesOf(tareaActual)) {

			// Obtiene la tarea anterior conectada por la arista
			Tarea tareaPrevia = g.getEdgeSource(edge);

			// Agrega la tarea previa a la lista de tareas previas
			tareasPrevias.add(tareaPrevia);

			// Realiza una llamada recursiva para explorar las tareas previas de la tarea
			// previa
			ejercicio3B(g, tareaPrevia, visitados, tareasPrevias, fichero);
		}

		return tareasPrevias;
	}

	public static List<Tarea> ejercicio3C(Graph<Tarea, RelacionTareas> g, String fichero) {

		// Lista de nodos sin aristas entrantes
		List<Tarea> tareasVacias = g.vertexSet().stream().filter(v -> g.incomingEdgesOf(v).isEmpty())
				.collect(Collectors.toList());

		List<Tarea> res = new ArrayList<>();

		// Mapa auxiliar para almacenar la tarea y la cantidad de sub-tareas
		Map<Tarea, Integer> aux = new HashMap<>();

		// Para cada tarea vacía
		for (Tarea t : tareasVacias) {

			// Iterador de búsqueda en profundidad desde la tarea actual
			DepthFirstIterator<Tarea, RelacionTareas> recProf = new DepthFirstIterator<>(g, t);

			List<Tarea> subTareas = List2.empty();

			// Para cada tarea en la búsqueda en profundidad, agregarla a la lista de
			// sub-tareas
			recProf.forEachRemaining((tarea) -> subTareas.add(tarea));

			// Almacenar en el mapa auxiliar la tarea actual y el tamaño de la lista de
			// sub-tareas
			aux.put(t, subTareas.size());
		}

		// Encontrar el valor máximo de sub-tareas
		Integer maxValue = aux.values().stream().max((n1, n2) -> n1.compareTo(n2)).orElse(0);

		// Filtrar las tareas con el máximo valor de sub-tareas y agregarlas a la lista
		// de resultados
		res = aux.entrySet().stream().filter(e -> e.getValue().equals(maxValue)).map(Entry::getKey).toList();

		// Dibujar grafo
		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoC.gv", v -> v.nombre(), e -> "Relacion-" + e.id(),
				v -> GraphColors.colorIf(Color.magenta, aux.entrySet().stream()
						.filter(e -> e.getValue().equals(maxValue)).map(Entry::getKey).toList().contains(v)),
				e -> GraphColors.color(Color.black));

		return res;

	}

}
