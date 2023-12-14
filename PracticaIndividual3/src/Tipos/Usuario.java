package Tipos;

import java.util.HashSet;
import java.util.Set;

public record Usuario(String nombre, Double indice, Set<String> aficiones) {

	public static Usuario of(String nombre, Double indice, Set<String> aficiones) {
		return new Usuario(nombre, indice, aficiones);
	}

	public static Usuario ofFormat(String[] partes) {

		String nombre = partes[0];
		Double indice = Double.valueOf(partes[1]);
		Set<String> aficiones = new HashSet<>();
		String[] elementos = partes[2].substring(1, partes[2].length() - 1).split(";");	
		for (String aficionesIndividual : elementos) {	
			aficiones.add(aficionesIndividual);
		}

		return Usuario.of(nombre, indice, aficiones);
	}

	public String toString() {

		return this.nombre + " " + this.indice + " " + this.aficiones;
	}

}
