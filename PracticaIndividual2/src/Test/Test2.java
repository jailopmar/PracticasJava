package Test;


public class Test2 {
	

	public static void main(String[] args) {
		
		Ejercicios.Ejercicio2.MergeSortGenDataUmbral1();
		Ejercicios.Ejercicio2.MergeSortGenDataUmbral4();
		Ejercicios.Ejercicio2.MergeSortGenDataUmbral16();
		Ejercicios.Ejercicio2.MergeSortGenDataUmbral64();
		Ejercicios.Ejercicio2.MergeSortGenDataUmbral256();
		
		Ejercicios.Ejercicio2.showGraph("ficheros/Ej2-1.txt", "Umbral 1: ");
		Ejercicios.Ejercicio2.showGraph("ficheros/Ej2-4.txt", "Umbral 4: ");
		Ejercicios.Ejercicio2.showGraph("ficheros/Ej2-16.txt", "Umbral 16: ");
		Ejercicios.Ejercicio2.showGraph("ficheros/Ej2-64.txt", "Umbral 64: ");
		Ejercicios.Ejercicio2.showGraph("ficheros/Ej2-256.txt", "Umbral 256: ");
		
		Ejercicios.Ejercicio2.showCombined();

	}

}
