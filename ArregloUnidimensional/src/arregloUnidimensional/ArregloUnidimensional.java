package arregloUnidimensional;

import java.util.Arrays;
import java.util.Scanner;

public class ArregloUnidimensional {
	// atributos
	private int[] vector;

	// constructor
	public ArregloUnidimensional(int[] vector) {
		this.vector = vector;
	}

	public ArregloUnidimensional() {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Por favor ingrese el tamaño del vector: ");
		int n = teclado.nextInt();
		this.vector = new int[n];

		for (int i = 0; i < vector.length; i++) {
			System.out.print("Ingrese dato " + (i + 1) + ": ");
			vector[i] = teclado.nextInt();
		}
	}

	// getter y setter
	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public void mostrarVector() {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " - ");
		}
	}

	public int traerElMenor() {
		int menor = vector[0];
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < menor) {
				menor = vector[i];
			}
		}
		return menor;
	}

	public int traerElMayor() {
		int mayor = vector[0];
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > mayor) {
				mayor = vector[i];
			}
		}
		return mayor;
	}

	public double calcularPromedio() {
		double suma = 0;
		for (int i = 0; i < vector.length; i++) {
			suma += vector[i];
		}
		return suma / vector.length;
	}

	public int[] ordenarAscendente() {
		int[] vector = this.vector;
		int aux = vector[0];
		for (int x = 0; x < vector.length; x++) {
			for (int y = 0; y < vector.length - 1; y++) {
				if (vector[y] > vector[y + 1]) {
					aux = vector[y];
					vector[y] = vector[y + 1];
					vector[y + 1] = aux;
				}
			}
		}
		return vector;
	}

	public int[] ordenarDescendente() {
		int[] vector = this.vector;
		int aux = vector[0];
		for (int x = 0; x < vector.length; x++) {
			for (int y = 0; y < vector.length - 1; y++) {
				if (vector[y] < vector[y + 1]) {
					aux = vector[y];
					vector[y] = vector[y + 1];
					vector[y + 1] = aux;
				}
			}
		}
		return vector;
	}

	public double traerFrecuencia(int numero) {
		double frecuencia = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == numero) {
				frecuencia++;
			}
		}
		return frecuencia / vector.length;
	}

	public int traerModa() {
		int maximoRepetido = 0;
		int moda = 0;
		for (int i = 0; i < vector.length; i++) {
			int numRepeticiones = 0;
			for (int j = 0; j < vector.length; j++) {
				if (vector[i] == vector[j]) {
					numRepeticiones++;
				}
				if (numRepeticiones > maximoRepetido) {
					moda = vector[i];
					maximoRepetido = numRepeticiones;
				}
			}
		}
		return moda;
	}

	public boolean equals(int[] arreglo) {
		return (Arrays.equals(vector, arreglo));
	}
}
