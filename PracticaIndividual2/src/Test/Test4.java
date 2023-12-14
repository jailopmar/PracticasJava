package Test;

import java.util.List;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Test4 {

	public static void main(String[] args) {

		String fichero = "ficheros/PI2Ej4DatosEntradaBinary.txt";
		String fichero2 = "ficheros/PI2Ej4DatosEntradaNary.txt";
		List<String> ls = Files2.streamFromFile(fichero).toList();
		List<String> ls2 = Files2.streamFromFile(fichero2).toList();

		System.out.println("Ejercicio 4 Binario\n");

		for (String line : ls) {

			System.out.println("Arbol de entrada: " + line);
			BinaryTree<Integer> tree = BinaryTree.parse(line, s -> Integer.parseInt(s));
			List<List<Integer>> aux = Ejercicios.Ejercicio4.ejercicio4Binario(tree);
			System.out.println("Caminos: ");
			for (List<Integer> list : aux) {

				System.out.println(list);

			}

			System.out.println("\n");

		}
		
		System.out.println("======================================================================");
		
		System.out.println("Ejercicio 4 N-ario\n");
		
		for (String line : ls2) {

			System.out.println("Arbol de entrada: " + line);
			Tree<Integer> tree = Tree.parse(line, s -> Integer.parseInt(s));
			List<List<Integer>> aux = Ejercicios.Ejercicio4.ejercicio4Nario(tree);
			System.out.println("Caminos: ");
			for (List<Integer> list : aux) {

				System.out.println(list);

			}

			System.out.println("\n");

		}
		

	}

}
