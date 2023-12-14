package Ejercicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.graphs.GraphsReader;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.List2;
import us.lsi.graphs.Graphs2;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.SimpleDirectedGraph;

import Tipos.Relacion;
import Tipos.Usuario;

public class Ejercicio1 {

	private static String carpetaResultados = "resultados/ejercicio1/";

	// Apartado A

	public static Set<Usuario> ejercicio1A(Graph<Usuario, Relacion> g, String fichero) {

		Set<Usuario> setVertex = g.vertexSet();
		Set<Usuario> res = new HashSet<>();

		for (Usuario resAux : setVertex) {
			if (g.outDegreeOf(resAux) > 3) {
				Double interaccionMedia = g.outgoingEdgesOf(resAux).stream().mapToDouble(edge -> edge.interaccion())
						.average().getAsDouble();
				if (interaccionMedia > 2.5) {
					//System.out.println(resAux.nombre() + ": " + interaccionMedia);
					res.add(resAux);
				}
			}

		}

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoA.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.colorIf(Color.blue, res.contains(v)), e -> GraphColors
						.colorIf(Color.blue, res.contains(g.getEdgeSource(e)) && res.contains(g.getEdgeTarget(e))));

		return res;

	}

	// Apartado B

	public static List<Set<Usuario>> ejercicio1B(Graph<Usuario, Relacion> g, String fichero) {

		var alg = new ConnectivityInspector<>(g);
		List<Set<Usuario>> res = alg.connectedSets();

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoB.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.color(coloreadoUsuario(v, res)),
				e -> GraphColors.color(ColoreadoRelacion(g, e, res)));

		return res;
	}

	private static Color ColoreadoRelacion(Graph<Usuario, Relacion> g, Relacion e, List<Set<Usuario>> res) {

		Usuario v = g.getEdgeSource(e);
		return coloreadoUsuario(v, res);
	}

	private static Color coloreadoUsuario(Usuario v, List<Set<Usuario>> res) {

		Color color = null;
		for (Set<Usuario> sc : res) {
			if (sc.contains(v)) {
				color = Color.values()[res.indexOf(sc)];
			}
		}
		return color;
	}

	// Apartado C

	public static Set<Usuario> ejercicio1C(Graph<Usuario, Relacion> g, String fichero) {

		GreedyVCImpl<Usuario, Relacion> greedy = new GreedyVCImpl<>(
				Graphs2.subGraph(g, v -> true, e -> true, Graphs2::simpleWeightedGraph));
		Set<Usuario> res = greedy.getVertexCover();

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoC.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.colorIf(Color.red, res.contains(v)),
				e -> GraphColors.color(Color.black));

		return res;
	}

	// Apartado D

	public static Set<Usuario> ejercicio1D(Graph<Usuario, Relacion> g, String fichero) {

		Set<Usuario> setVertex = g.vertexSet();
		Set<Usuario> res = new HashSet<>();

		for (Usuario resAux : setVertex) {
			if (g.inDegreeOf(resAux) >= 5 && resAux.aficiones().size() > 3 && resAux.indice() > 4.0) {
				res.add(resAux);
				if (res.size() == 2) {
					break;
				}
			}

		}

		GraphColors.toDot(g, carpetaResultados + fichero + "ApartadoD.gv", v -> v.nombre(),
				e -> "(" + e.toString() + ")", v -> GraphColors.colorIf(Color.red, res.contains(v)),
				e -> GraphColors.color(Color.black));

		return res;

	}

}
