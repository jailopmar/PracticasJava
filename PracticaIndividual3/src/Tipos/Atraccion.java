package Tipos;

public record Atraccion(String nombre, Integer tiempo, Double popularidad, Integer duracion) {
	
	public static Atraccion of(String nombre, Integer tiempo, Double popularidad, Integer duracion) {
		return new Atraccion(nombre, tiempo, popularidad, duracion);
	}
	
	public static Atraccion ofFormat(String[] partes) {

		String nombre = partes[0];
		Integer tiempo =Integer.parseInt(partes[1]);
		Double popularidad = Double.valueOf(partes[2]);
		Integer duracion = Integer.valueOf(partes[3]);

		return Atraccion.of(nombre, tiempo, popularidad, duracion);
	}
	
	public String toString() {

		return this.nombre + " " + this.tiempo + " " + this.popularidad + " " + this.duracion;
	}


}
