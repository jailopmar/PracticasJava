package Ejercicios;

import Tipos.Vecindad;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ei = "Barco Pirata, Casa del Terror, 150, 2.0";
		
		String[] partes = ei.split(",");
		 
		Vecindad u = Vecindad.ofFormat(partes);
		
		System.out.println(u.toString());
		

	}

}
