package Tipos;

public record Vecindad(Integer id, Double distanciaKm, Double tiempo) {

	private static Integer numId = 0;

	public static Vecindad of(Double distanciaKm, Double tiempo) {

		Integer id = numId;
		numId += 1;

		return new Vecindad(id, distanciaKm, tiempo);
	}

	public static Vecindad ofFormat(String[] partes) {

		Double distanciaKm = Double.valueOf(partes[2].trim());
		Double tiempo = Double.valueOf(partes[3].trim());

		return Vecindad.of(distanciaKm, tiempo);
	}
	
public String toString() {
		
		return this.distanciaKm + ", " + this.tiempo;
	}
	

}
