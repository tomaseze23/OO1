package test;

import java.util.Scanner;

import arregloBidimensional.ArregloBidimensional;

public class testArregloBidimensional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// caso de uso 1 - suma
		ArregloBidimensional matriz1 = new ArregloBidimensional();
		double[][] matriz2 = new double[3][3];
		iniciarMatrizAleatoria(matriz2);
		ArregloBidimensional matrizSuma = new ArregloBidimensional(matriz1.sumar(matriz2));
		System.out.println("\nCaso de Uso - SUMA: ");
		matrizSuma.mostrarMatriz();
		System.out.println("====================================================");
		
		// caso de uso 2 - resta
		double[][] matriz3 = new double[3][3];
		iniciarMatrizAleatoria(matriz3);
		ArregloBidimensional matrizResta = new ArregloBidimensional(matriz1.restar(matriz3));
		System.out.println("\nCaso de Uso - RESTA: ");
		matrizResta.mostrarMatriz();
		System.out.println("====================================================");
		
		// caso de uso 3 - transpuesta
		ArregloBidimensional transpuesta = new ArregloBidimensional(matriz1.transpuesta());
		matriz1.mostrarMatriz();
		System.out.println("\nCaso de Uso - MATRIZ TRANSPUESTA: ");
		transpuesta.mostrarMatriz();
		System.out.println("====================================================");
		
		// caso de uso 4 - multiplicacion por escalar
		matriz1.mostrarMatriz();
		ArregloBidimensional multiplicacion = new ArregloBidimensional(matriz1.multiplicar(3));
		System.out.println("\nCaso de Uso - MATRIZ POR UN ESCALAR: ");
		multiplicacion.mostrarMatriz();
		System.out.println("====================================================");
		
		// caso de uso 5 - multiplicacion de matrices
		ArregloBidimensional matrizA = new ArregloBidimensional();
		double[][] mat2 = iniciarMatriz();
		ArregloBidimensional matrizC = new ArregloBidimensional(matrizA.multiplicar(mat2));
		System.out.println("\nCaso de Uso - MULTIPLICACIÓN DE MATRICES: ");
		matrizC.mostrarMatriz();
		System.out.println("====================================================");
		 */
		double [][] matriz1 = {{3,4,2},{6,3,6},{9,7,5}};
		
		ArregloBidimensional m1 = new ArregloBidimensional(matriz1);
		m1.mostrarMatriz();
	}
	/*
	private static void mostrarMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	*/
	private static void iniciarMatrizAleatoria(double[][] matriz) {
		// TODO Auto-generated method stub
		int rand = (int)(Math.random()*10-1)+1;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j] = rand; 
            }
        }
	}
	private static double[][] iniciarMatriz() {

		Scanner teclado = new Scanner(System.in);

		System.out.print("Por favor ingrese la cantidad de filas: ");
		int f = teclado.nextInt();
		System.out.print("Por favor ingrese la cantidad de columnas: ");
		int c = teclado.nextInt();
		double[][]matriz = new double[f][c];

		for (int i = 0; i < f; i++) {
			for (int j = 0; j <c; j++) {
				System.out.print("Ingrese dato para la posición ["+i+"] ["+j+"] : ");
				matriz[i][j] = teclado.nextInt();
			}
		}
		return matriz;
	}

}
