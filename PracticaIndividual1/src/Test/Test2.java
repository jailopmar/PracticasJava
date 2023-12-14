package Test;

import java.util.List;

import us.lsi.common.Files2;

public class Test2 {

	public static void main(String[] args) {

		Integer bucle = 1;
		String fichero = "ficheros/PI1Ej2DatosEntrada.txt";
		List<String> ls = Files2.streamFromFile(fichero).toList();

		for (String line : ls) {

			String[] partes = line.split(",");
			Integer a = Integer.parseInt(partes[0]);
			Integer b = Integer.parseInt(partes[1]);

			System.out.println("Test Iterativa " + bucle + ": " + Ejercicios.Ejercicio2.ejercicio2Iterativa(a, b));
			System.out.println(
					"Test Recursiva Final " + bucle + ": " + Ejercicios.Ejercicio2.ejercicio2RecursivaFinal(a, b));
			System.out.println(
					"Test Recursiva No Final " + bucle + ": " + Ejercicios.Ejercicio2.ejercicio2Iterativa(a, b));
			System.out.println("----------------------------------------------------------------------\n");
			bucle++;

		}

	}

}
