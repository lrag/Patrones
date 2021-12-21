package curso.patrones.TemplateMethod;




public class Programa {
	public static void main(String[] args) {
		DarServicio curso=new DarUnCurso();
		curso.tareas();
		System.out.println("---------------");
		DarServicio soporte=new DarSoporte();
		soporte.tareas();
		System.out.println("---------------");
		DarServicio consultoria=new DarConsultoria();
		consultoria.tareas();
	}
}
