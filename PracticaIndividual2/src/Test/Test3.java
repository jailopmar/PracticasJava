package Test;

import java.util.List;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Test3 {
	
	

	public static void main(String[] args) {

		String fichero = "ficheros/PI2Ej3DatosEntradaBinary.txt";
		List<String> ls = Files2.streamFromFile(fichero).toList();

		System.out.println("Ejercicio 3 Binario\n");

		for (String line : ls) {

			System.out.println("Arbol de entrada: " + line);
			BinaryTree<Character> tree = BinaryTree.parse(line, s -> s.charAt(0));
			System.out.println("Equilibrado?: " + Ejercicios.Ejercicio3.ejercicio3Binario(tree));
		}
		
		String fichero2 = "ficheros/PI2Ej3DatosEntradaNary.txt";
		List<String> ls2 = Files2.streamFromFile(fichero2).toList();
		
		System.out.println("\nEjercicio 3 N-ario\n");
		
		for (String line2 : ls2) {
			
			System.out.println("Arbol Entrada: " + line2);
			Tree<Character> tree2 = Tree.parse(line2, s -> s.charAt(0));
			System.out.println("Equilibrado?: " +  Ejercicios.Ejercicio3.ejercicio3Nario(tree2));
		}

	}

}
