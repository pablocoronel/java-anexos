package introspeccion;

import java.lang.reflect.*;
import java.util.Scanner;

public class Prueba_Introspeccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce el nombre de la clase");

		String nombre_clase;

		nombre_clase = entrada.next();

		// imprimir clase y superclase

		try {
			Class cl = Class.forName(nombre_clase);
			Class super_cl = cl.getSuperclass();

			System.out.println("Clase: " + nombre_clase);

			// ver el nombre de su superclase
			if (super_cl != null && super_cl != Object.class) {
				System.out.println("hereda de: " + super_cl.getName());
			}

			System.out.println();

			imprimirConstructores(cl);
			System.out.println();

			imprimirMetodos(cl);

			System.out.println();

			imprimirCampos(cl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * ver los constructores
	 */
	public static void imprimirConstructores(Class cl) {

		Constructor[] constructores = cl.getDeclaredConstructors();

		for (Constructor c : constructores) {
			String nombre = c.getName();

			System.out.print(" " + Modifier.toString(c.getModifiers()));
			System.out.print(" " + nombre + "(");

			// imprimir parametros
			Class[] tipo_params = c.getParameterTypes();
			for (int i = 0; i < tipo_params.length; i++) {
				if (i > 0) {
					System.out.print(", ");
				}

				System.out.print(tipo_params[i].getName());
			}

			// cerrar el parentesis del constructor
			System.out.print(");");
		}
	}

	/**
	 * todos los metodos de la clase
	 */
	public static void imprimirMetodos(Class cl) {
		Method[] metodos = cl.getDeclaredMethods();

		for (Method m : metodos) {
			Class tipo = m.getReturnType();

			String nombre = m.getName();

			// imprimir modificadores, tipo y nombre
			System.out.print(" " + Modifier.toString(m.getModifiers()));
			System.out.print(" " + tipo.getName() + " " + nombre + "(");

			// imprime tipo de parametros
			Class[] tipo_params = m.getParameterTypes();

			for (int i = 0; i < tipo_params.length; i++) {
				if (i > 0) {
					System.out.print(", ");
				}

				System.out.print(tipo_params[i].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * todos los campos
	 */
	public static void imprimirCampos(Class cl) {
		Field[] campos = cl.getDeclaredFields();

		for (Field f : campos) {
			Class tipo_campo = f.getType();
			String nombre = f.getName();

			System.out.print(" " + Modifier.toString(f.getModifiers()));
			System.out.println(" " + tipo_campo.getName() + " " + nombre + ";");
		}
	}
}
