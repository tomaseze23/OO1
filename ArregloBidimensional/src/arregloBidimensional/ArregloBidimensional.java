package arregloBidimensional;

import java.util.Arrays;
import java.util.Scanner;

public class ArregloBidimensional {
	//atributos
	private double [][] matrizA;

	//constructor
	public ArregloBidimensional(double[][] matrizA) {
		this.matrizA = matrizA;
	}
	
	//constructor redefinido
	public ArregloBidimensional(){
		Scanner teclado = new Scanner(System.in);

		System.out.print("Por favor ingrese la cantidad de filas: ");
		int f = teclado.nextInt();
		System.out.print("Por favor ingrese la cantidad de columnas: ");
		int c = teclado.nextInt();
		this.matrizA = new double[f][c];

		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				System.out.print("Ingrese dato para la posición ["+i+"] ["+j+"] : ");
				matrizA[i][j] = teclado.nextInt();
			}
		}
	}
	
	//getter y setter
	public double[][] getMatrizA() {
		return matrizA;
	}

	public void setMatrizA(double[][] matrizA) {
		this.matrizA = matrizA;
	}

	public void mostrarMatriz() {
		if (matrizA!=null) {
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j < matrizA[i].length; j++) {
					System.out.print(matrizA[i][j]+" \t");
				}
				System.out.println("\n");
			}
		}else {
			System.out.println("La matriz no se pudo mostrar porque las dimensiones para hacer dicha operación no coinciden.");
		}
	}


	public double[][] sumar(double[][] matrizB){
		double [][] matrizSuma;
		if(matrizA.length==matrizB.length&&matrizA[0].length==matrizB[0].length) {
			matrizSuma = new double[matrizA.length][matrizA[0].length];
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j < matrizB[0].length; j++) {
					matrizSuma[i][j] = matrizA[i][j] + matrizB[i][j];
				}
			}
			return matrizSuma;
		}else {
			return null;
		}
	}
	public double[][] restar(double[][] matrizB){
		double[][] matrizResta;
		if(matrizA.length==matrizB.length&&matrizA[0].length==matrizB[0].length) {
			matrizResta=new double[matrizA.length][matrizA[0].length];
			for (int i = 0; i < matrizA.length; i++) {
				for (int j = 0; j <matrizA[i].length; j++) {
					matrizResta[i][j]=matrizA[i][j]-matrizB[i][j];
				}
			}
			return matrizResta;
		}else {
			return matrizResta=null;
		}
	}
	public double[][] transpuesta(){
		double[][] matrizTranspuesta=new double[matrizA[0].length][matrizA.length];
		for(int i=0;i<matrizA.length;i++) {
			for(int j=0;j<matrizA[i].length;j++) {
				matrizTranspuesta[j][i]=matrizA[i][j];
			}
		}
		return matrizTranspuesta;
	}
	public double[][] multiplicar(double numero) {
		double[][]matrizMultiplicacionEscalar=new double[matrizA.length][matrizA[0].length];
		for(int i=0;i<matrizA.length;i++) {
			for(int j=0;j<matrizA[i].length;j++) {
				matrizMultiplicacionEscalar[i][j]=matrizA[i][j]*numero;
			}
		}
		return matrizMultiplicacionEscalar;
	}
	public double[][] multiplicar (double[][] matrizB){
		double[][] multiplicacion=new double [matrizA.length][matrizB[0].length];
		if(matrizA[0].length==matrizB.length) {
	        for (int i = 0; i < matrizA.length; i++) {
	            for (int j = 0; j < matrizB[0].length; j++) {
	                for (int k = 0; k < matrizA[0].length; k++) {
	                    // aquí se multiplica la matriz
	                    multiplicacion[i][j] += matrizA[i][k] * matrizB[k][j];
	                }
	            }
	        }
	        return multiplicacion;
		}else {
			return null;
		}
	}
}
