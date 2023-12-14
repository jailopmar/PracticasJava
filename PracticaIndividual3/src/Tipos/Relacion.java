package Tipos;

public record Relacion(Integer id, Double interaccion) {
	
	private static Integer numId = 0;
	
	public static Relacion of(Double interaccion) {
		Integer id = numId;
		numId += 1;
		return new Relacion(id, interaccion);
	}
	
	public static Relacion ofFormat(String[] partes) {
		
		Double indice = Double.valueOf(partes[2].trim());
		return Relacion.of(indice);
	}
	
	public String toString() {
		
		return this.interaccion + "";
	}
	
	

}
