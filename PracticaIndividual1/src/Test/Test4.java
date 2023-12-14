package Test;

import java.util.List;

import us.lsi.common.Files2;

public class Test4 {

	public static void main(String[] args) {

		int bucle = 1;
		String fichero = "ficheros/PI1Ej4DatosEntrada.txt";
		List<String> ls = Files2.streamFromFile(fichero).toList();

		for (String line : ls) {

			String[] partes = line.split(",");
			Integer a = Integer.parseInt(partes[0]);
			Integer b = Integer.parseInt(partes[1]);

			System.out.println(
					"Test Recursiva Sin Memoria " + bucle + ": " + Ejercicios.Ejercicio4.ejercicio4SinMemoria(a, b));
			System.out.println(
					"Test Recursiva Con Memoria " + bucle + ": " + Ejercicios.Ejercicio4.ejercicio4ConMemoria(a, b));
			System.out.println(
					"Test Iterativa " + bucle + ": " + Ejercicios.Ejercicio4.ejercicio4Iterativa(a, b));
			System.out.println("------------------------------------------------------------------------------------\n");
			bucle++;
		}

	}

}
