package ClasesProyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.management.openmbean.ArrayType;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declaraci�n de nuestras variables
		// Librer�a: son clases desarrollados por alguien m�s para que nuestras
		// aplicaciones funcionen correctamente

		Scanner lectura = null;

		String clave;
		String marca;
		String modelo;
		int existencia;
		float precio;

		// Variable del tipo objeto
		Computadoras computadora = null;

		// Declaraci�n de lista
		List<Computadoras> lista = new ArrayList<Computadoras>();

		// Variables de tipo entero
		int menuPrin, subMenu, indice;

		do {
			System.out.println("Bienvenido al sistema");
			System.out.println("1) Alta");
			System.out.println("2) Mostrar");
			System.out.println("3) Buscar por �ndice");
			System.out.println("4) Editar");
			System.out.println("5) Eliminar por �ndice");
			System.out.println("6) Buscar por modelo");
			System.out.println("7) Buscar por marca");
			System.out.println("8) Calcular el dinero invertido");
			System.out.println("9) Eliminar por modelo");
			System.out.println("10) Salir");

			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();

			switch (menuPrin) {
			case 1:

				try {
					System.out.println("Ingrese la clave");
					lectura = new Scanner(System.in);
					clave = lectura.nextLine();

					System.out.println("Ingresa la marca");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();

					System.out.println("Ingresa el modelo");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();

					System.out.println("Ingrese la existencia");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					System.out.println("Ingrese el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();
					// Crear el objeto

					computadora = new Computadoras(clave, marca, modelo, existencia, precio);

					// Agregar el objeto a la lista
					lista.add(computadora);
					System.out.println("Se agrego nuevo registro");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar" + e.getMessage());
				}

				break;

			case 2:
				System.out.println(lista);
				break;

			case 3:
				System.out.println("Registros por �ndice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingresa el �ndice a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Busqueda
					computadora = lista.get(indice);
					System.out.println("Se encontro" + computadora);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar" + e.getMessage());
				}
				break;

			case 4:
				// Para editar primero hay que buscar
				System.out.println("Registros por �ndice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingresa el �ndice a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Busqueda
					computadora = lista.get(indice);
					System.out.println("Se encontro" + computadora.getMarca());

					// Precio y modelo
					do {
						System.out.println("Submen� para editar");
						System.out.println("1) Modelo");
						System.out.println("2) Precio");
						System.out.println("3) Regresar men� principal");
						lectura = new Scanner(System.in);
						subMenu = lectura.nextInt();

						switch (subMenu) {
						case 1:
							System.out.println("Ingrese el nuevo modelo.");
							lectura = new Scanner(System.in);
							modelo = lectura.nextLine();

							// Actualizaci�n

							computadora.setModelo(modelo);
							System.out.println("Se edit� con �xito el modelo.");
							break;

						case 2:
							System.out.println("Ingrese el nuevo precio");
							lectura = new Scanner(System.in);
							precio = lectura.nextFloat();

							// Actualizaci�n

							computadora.setPrecio(precio);
							System.out.println("Se edit� con �xito el precio.");
							break;

						case 3:
							System.out.println("Regresando al men� principal.");
							break;
						}

					} while (subMenu < 3);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar" + e.getMessage());
				}

				break;

			case 5:
				System.out.println("Registros por �ndice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingrese el �ndice a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Eliminaci�n
					lista.remove(indice);
					System.out.println("Se elimin� con �xito.");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al eliminar");
				}

				break;

			case 6: // "Buscar por modelo"
				System.out.println("�Qu� modelo desea buscar?");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getModelo());
				}

				try {
					System.out.println("Ingrese el �ndice qu� desea buscar.");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					computadora = lista.get(indice);
					System.out.println("Se encontr� la siguiente informaci�n" + computadora);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar" + e.getMessage());
				}
				break;

			case 7: // Buscar por marca
				System.out.println("Registros por masrcas en la lista.");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingrese la marca que desea buscar.");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();

					for (Computadoras mark : lista) {
						if (mark.getMarca().equalsIgnoreCase(marca)) {
							System.out.println("Se encontr�: " + mark);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar " + e.getMessage());
				}
				break;

			case 8: // Calcular el dinero invertido
				System.out.println("A continuaci�n se va a calcular el dinero invertido");
				float total = 0;
				for (int i = 0; i < lista.size(); i++) {
					total += lista.get(i).getExistencia() * lista.get(i).getPrecio();
				}
				System.out.println("El total invertido es: " + total);
				break;

			case 9: // Eliminar por modelo
				System.out.println("Registros por modelo en la lista.");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getModelo());
				}
				try {
					System.out.println("Ingrese el modelo a eliminar.");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();
					for (int i = 0; i < lista.size(); i++) {
						if (lista.get(i).getModelo().equalsIgnoreCase(modelo)) {
							lista.remove(i);
							System.out.println("Se elimino con �xito.");
							break;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al eliminar");
				}
				break;
			case 10: // Salir

				break;
			}

		} while (menuPrin < 10); // Vamos a estar entrando mientras menuPrin sea menor a 6.

	}

}
