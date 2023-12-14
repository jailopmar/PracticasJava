package Tipos;

public record Tarea(String nombre) {

	public static Tarea of(String nombre) {
		return new Tarea(nombre);
	}

	public static Tarea ofFormat(String[] partes) {
		
		String nombre = partes[0];
		
		return Tarea.of(nombre);
	}
	
	public String toString() {
		
		return this.nombre;
	}
	
	

}
