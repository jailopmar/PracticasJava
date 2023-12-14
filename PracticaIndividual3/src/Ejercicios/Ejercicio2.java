package Ejercicios;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.tour.HeldKarpTSP;

import Tipos.Atraccion;
import Tipos.Vecindad;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;

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
	
	public static GraphPath<Atraccion, Vecindad> ejercicio2B(Graph<Atraccion, Vecindad> g, String fichero){
		
		HeldKarpTSP<Atraccion, Vecindad> alg = new HeldKarpTSP<Atraccion, Vecindad>();		
		GraphPath<Atraccion, Vecindad> res = alg.getTour(g);
		
		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoB.gv", v -> v.nombre(),
				e -> "(distancia: " + e.distanciaKm() + ", tiempo: " + e.tiempo() + ")",
				v -> GraphColors.color(res.getVertexList().get(0).equals(v) ? Color.magenta:Color.blue),
				e -> GraphColors.colorIf(Color.blue, res.getEdgeList().contains(e)));

		
		return res;
		
	}
}
