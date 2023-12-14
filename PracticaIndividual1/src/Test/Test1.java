package Test;

import java.util.List;

import us.lsi.common.Files2;

public class Test1 {

	public static void main(String[] args) {

		Integer bucle = 1;
		String fichero = "ficheros/PI1Ej1DatosEntrada.txt";
		List<String> ls = Files2.streamFromFile(fichero).toList();

		for (String line : ls) {

			String[] partes = line.split(",");
			Integer varA = Integer.parseInt(partes[0]);
			Integer varB = Integer.parseInt(partes[1]);

			System.out
					.println("Test Iterativa " + bucle + ": " + Ejercicios.Ejercicio1.ejercicio1Iterativa(varA, varB));
			System.out.println("Test Recursiva Final " + bucle + ": "
					+ Ejercicios.Ejercicio1.ejercicio1RecursivaFinal(varA, varB));
			System.out.println("---------------------------------------------------------- \n");

			bucle++;

		}

	}

}
