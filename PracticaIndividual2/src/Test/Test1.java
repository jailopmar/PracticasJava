package Test;

public class Test1 {

	public static void main(String[] args) {
		
		Ejercicios.Ejercicio1.recursivaDoubleGenData();
		Ejercicios.Ejercicio1.recursivaBigGenData();
		Ejercicios.Ejercicio1.iterativaDoubleGenData();
		Ejercicios.Ejercicio1.iterativaBigGenData();
		
		Ejercicios.Ejercicio1.showGraph("ficheros/recursivaDouble.txt", "Recursiva-Double");
		Ejercicios.Ejercicio1.showGraph("ficheros/recursivaBigInteger.txt", "Recursiva-BigInteger");
		Ejercicios.Ejercicio1.showGraph("ficheros/iterativaDouble.txt", "Iterativa-Double");
		Ejercicios.Ejercicio1.showGraph("ficheros/iterativaBigInteger.txt", "Iterativa-BigInteger");
		
		Ejercicios.Ejercicio1.showCombined();
		Ejercicios.Ejercicio1.showCombinedDouble();

	}

}

