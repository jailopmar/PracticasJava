package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio4 {

	private static Predicate<List<Integer>> pred = ls -> {

		int size = ls.size(); // Tamaño lista

		if (size <= 1) { // Verificar si el tamaño es <= 1
			return false;
		}

		int sum = 0; // Variable para almacenar la suma de los elementos de la lista

		for (int i : ls) { // Iterar sobre la lista y sumar los elementos
			sum += i;
		}

		return sum % (size - 1) == 0; // Verificar si la suma es divisible entre la longitud (size -1)
	};

	public static List<List<Integer>> ejercicio4Binario(BinaryTree<Integer> tree) {

		return recursivaBinario(tree).stream().filter(pred).collect(Collectors.toList());
	}

	private static List<List<Integer>> recursivaBinario(BinaryTree<Integer> tree) {

		List<Integer> ls = new ArrayList<>(); // ls va guardando cada camino
		List<Integer> aux = new ArrayList<>(); // Lista aux sirve para volver una vez se encuentra camino
		List<List<Integer>> res = new ArrayList<>(); // Resultado

		return switch (tree) {

		case BEmpty<Integer> t -> {

			res.add(List.of(0)); // Para los elementos "/_"
			yield res;
		}

		case BLeaf<Integer> t -> {

			ls.add(t.label()); // Añadir etiqueta a la lista
			res.add(new ArrayList<Integer>(ls));

			yield res;
		}

		case BTree<Integer> t -> {

			ls.add(t.label()); // Añadir etiqueta a la lista
			aux.addAll(ls); // agregamos a ls la lista aux

			for (List<Integer> lsLeft : recursivaBinario(t.left())) { // Hijo izquierdo
				ls.addAll(lsLeft); // Cada camino del hijo izquierdo se añade a la lista ls
				res.add(new ArrayList<Integer>(ls));
				ls.clear(); // Limpiar ls
				ls.addAll(aux); // Todos los elementos de aux se añaden al final de ls
			}
			for (List<Integer> lsRight : recursivaBinario(t.right())) { // Hijo derecho
				ls.addAll(lsRight); // Cada camino del hijo derecho se añade a la lista ls
				res.add(new ArrayList<Integer>(ls));
				ls.clear(); // Limpiar ls
				ls.addAll(aux); // Todos los elementos de aux se añaden al final de ls

			}

			yield res;
		}

		};

	}

	public static List<List<Integer>> ejercicio4Nario(Tree<Integer> tree) {

		return recursivaNario(tree).stream().filter(pred).collect(Collectors.toList());
	}

	private static List<List<Integer>> recursivaNario(Tree<Integer> tree) {

		List<Integer> ls = new ArrayList<>(); // ls va guardando cada camino
		List<Integer> aux = new ArrayList<>(); // Lista aux sirve para volver una vez se encuentra camino
		List<List<Integer>> res = new ArrayList<>(); // Resultado

		return switch (tree) {

		case TEmpty<Integer> t -> {

			res.add(List.of(0)); // Para los elementos "/_"
			yield res;
		}

		case TLeaf<Integer> t -> {

			ls.add(t.label()); // Añadir etiqueta a la lista
			res.add(new ArrayList<Integer>(ls));

			yield res;
		}

		case TNary<Integer> t -> {

			ls.add(t.label()); // Añadir etiqueta a la lista
			aux.addAll(ls); // agregamos a ls la lista aux
			t.children().stream().forEach(child -> {
				for (List<Integer> lsPaths : recursivaNario(child)) {
					ls.addAll(lsPaths);
					res.add(new ArrayList<Integer>(ls));
					ls.clear();
					ls.addAll(aux);
				}
			});

			yield res;
		}

		};

	}

}
