package Ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio3 {

	public static Boolean ejercicio3Binario(BinaryTree<Character> tree) {

		Boolean res = false;
		return recursivaBinario(tree, res);

	}

	private static Boolean recursivaBinario(BinaryTree<Character> tree, Boolean res) {

		return switch (tree) {

		case BEmpty<Character> t -> true;
		case BLeaf<Character> t -> true;

		case BTree<Character> t -> {

			int alturaNodoIzquierdo = t.left().height();
			int alturaNodoDerecho = t.right().height();
			int diferencia = Math.abs(alturaNodoDerecho - alturaNodoIzquierdo);

			if (diferencia <= 1) {

				res = recursivaBinario(t.left(), res);
				res = recursivaBinario(t.right(), res);
			}

			else {
				res = false;
			}

			yield res;
		}

		};

	}

	public static Boolean ejercicio3Nario(Tree<Character> tree) {

		Boolean res = true;
		return recursivaNario(tree, res);

	}

	private static Boolean recursivaNario(Tree<Character> tree, Boolean res) {

		return switch (tree) {

		case TEmpty<Character> t -> true;
		case TLeaf<Character> t -> true;
		
		case TNary<Character> t -> {

			int i = tree.height() - 1;

			for (Tree<Character> hijo : t.children()) {
				int altura = hijo.height();
				int diferenciaAltura = Math.abs(i - altura);
				Boolean aux = diferenciaAltura <= 1;

				if (res == true && aux == true) {
					res = recursivaNario(hijo, res);
				} else {
					res = false;
				}
			}
			yield res;
		}

		};

	}

}
