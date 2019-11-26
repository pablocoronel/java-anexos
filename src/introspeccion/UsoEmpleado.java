package introspeccion;

public class UsoEmpleado {

	public static void main(String[] args) {

		Persona Antonio = new Persona("Antonio");

		System.out.println(Antonio.getNombre());

		Empleado Ana = new Empleado("Ana", 3500);
		System.out.println(Ana.getNombre());
		System.out.println(Ana.getSalario());

		// devuelve class paquete.Clase
//		System.out.println(Antonio.getClass());

		Class cl_1 = Antonio.getClass();
		System.out.println(cl_1.getName()); // nombre de la clase

		String nombre_clase = "introspeccion.Empleado";
		try {
			Class cl_2 = Class.forName(nombre_clase);

			System.out.println(cl_2.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * Persona
 */
class Persona {
	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
}

/**
 * Empleado
 */
class Empleado extends Persona {
	private double salario;

	public Empleado(String nombre, double salario) {
		super(nombre);
		// TODO Auto-generated constructor stub

		this.salario = salario;
	}

	public void setIncentivo(double incentivo) {
		this.salario += incentivo;
	}

	public String getSalario() {
		return "El salario es: " + this.salario;
	}

}