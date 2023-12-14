package Ejercicios;


public class Ejercicio1 {
	
	public static record EnteroCadena(Integer a, String s) {
		public static EnteroCadena of(Integer numero, String cadena) {
			return new EnteroCadena(numero, cadena);
		}
	}

	public static String ejercicio1Iterativa(Integer varA, Integer varB) {
		
		String res = "";
		EnteroCadena elem = new EnteroCadena(varA, "A");
		
		while(elem.a() < varB) {
			if(elem.a()%10 != 0) {
				res = res + elem.s() + "-";
			}
			if(elem.a() % 2 == 0) {
				elem = EnteroCadena.of(elem.a() + 3, elem.a() + "*");
			
			}else {
				elem = EnteroCadena.of(elem.a() + 3, elem.a() + "!");
			}
		}
		
		return res;
	}
	
	public static String ejercicio1RecursivaFinal(Integer varA, Integer varB) {
		
		String ac = "";
		EnteroCadena elem = new EnteroCadena(varA, "A");
		return recursiva(varA, varB, elem, ac);
	}

	private static String recursiva(Integer varA, Integer varB, EnteroCadena elem, String ac) {
		
		String res = "";
		
		if(elem.a() >= varB) {
			res = ac;
		}
		if(elem.a() < varB) {
			if(elem.a()%10 != 0) {
				ac = ac + elem.s() + "-";
			}
			if(elem.a() % 2 == 0) {
				
				res = recursiva(varA, varB, EnteroCadena.of(elem.a() + 3, elem.a() + "*"), ac);
			}else {
				res = recursiva(varA, varB, EnteroCadena.of(elem.a() + 3, elem.a() + "!"), ac);
			}
		}
		
		return res;
	}

}
