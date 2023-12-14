package Tipos;

public record RelacionTareas(Integer id) {
	
	private static Integer numId = 0;
	
	public static RelacionTareas of() {

		Integer id = numId;
		numId += 1;

		return new RelacionTareas(id);
	}
	
	public static RelacionTareas ofFormat(String[] partes) {
		


		return RelacionTareas.of();
	}
}
