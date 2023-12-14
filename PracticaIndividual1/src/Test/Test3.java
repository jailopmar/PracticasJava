package Test;

import java.util.List;

import us.lsi.common.Files2;

public class Test3 {

	public static void main(String[] args) {

		String fichero1A = "ficheros/PI1Ej3DatosEntrada1A.txt";
		List<String> ls1A = Files2.streamFromFile(fichero1A).toList();
		String fichero1B = "ficheros/PI1Ej3DatosEntrada1B.txt";
		List<String> ls1B = Files2.streamFromFile(fichero1B).toList();

		System.out.println("Test Iterativa 1: " + Ejercicios.Ejercicio3.ejercicio3Iterativa(ls1A, ls1B));
		System.out.println("Test Recursiva Final 1: " + Ejercicios.Ejercicio3.ejercicio3RecursivaFinal(ls1A, ls1B));
		System.out.println("---------------------------------------------------------------------------------------\n");

		String fichero2A = "ficheros/PI1Ej3DatosEntrada2A.txt";
		List<String> ls2A = Files2.streamFromFile(fichero2A).toList();
		String fichero2B = "ficheros/PI1Ej3DatosEntrada2B.txt";
		List<String> ls2B = Files2.streamFromFile(fichero2B).toList();

		System.out.println("Test Iterativa 2: " + Ejercicios.Ejercicio3.ejercicio3Iterativa(ls2A, ls2B));
		System.out.println("Test Recursiva Final 2: " + Ejercicios.Ejercicio3.ejercicio3RecursivaFinal(ls2A, ls2B));
		System.out.println("---------------------------------------------------------------------------------------\n");
		
		String fichero3A = "ficheros/PI1Ej3DatosEntrada3A.txt";
		List<String> ls3A = Files2.streamFromFile(fichero3A).toList();
		String fichero3B = "ficheros/PI1Ej3DatosEntrada3B.txt";
		List<String> ls3B = Files2.streamFromFile(fichero3B).toList();
		
		System.out.println("Test Iterativa 3: " + Ejercicios.Ejercicio3.ejercicio3Iterativa(ls3A, ls3B));
		System.out.println("Test Recursiva Final 3: " + Ejercicios.Ejercicio3.ejercicio3RecursivaFinal(ls3A, ls3B));
		System.out.println("---------------------------------------------------------------------------------------\n");
		

	}

}
