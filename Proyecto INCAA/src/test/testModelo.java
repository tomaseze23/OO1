package test;

import modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

import modelo.Genero;
import modelo.Incaa;

public class testModelo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Genero genero1 = new Genero(1, "Ciencia Ficción");
		Genero genero2 = new Genero(2, "Acción");
		Genero genero3 = new Genero(3, "Comedia");
		Genero genero4 = new Genero(4, "Animada");
		Genero genero5 = new Genero(5, "Terror");
		Incaa incaa = new Incaa();
		incaa.agregarPelicula("El Señor de los Anillos", genero1);
		incaa.agregarPelicula("Harry Potter y la Piedra Filosofal", genero1);
		System.out.println("\n===========CASO DE PRUEBA 1===========\n");
		try {
			incaa.agregarPelicula("El Señor de los Anillos", genero1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			incaa.agregarPelicula("Shrek 2", genero4);
			incaa.agregarPelicula("Rapidos y Furiosos", genero2);
			incaa.agregarPelicula("Irené, Yo y Mi Otro Yo", genero3);
			incaa.agregarPelicula("Avengers: End Game", genero2);
			incaa.agregarPelicula("Esperando la Carroza", genero3);
			incaa.agregarPelicula("Cars", genero4);
			incaa.agregarPelicula("Iron Man", genero2);
			incaa.agregarPelicula("Star Wars", genero1);
			incaa.agregarPelicula("Son Como Niños", genero3);
			incaa.agregarPelicula("Harry Potter y la Orden del Fénix", genero3);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		System.out.println("\n===========CASO DE PRUEBA 2===========\n");
		try {
			System.out.println(incaa.traerPelicula(14));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n===========CASO DE PRUEBA 3===========\n");
		try {
			List<Pelicula> partePelicula = new ArrayList<Pelicula>();
			partePelicula = incaa.traerPelicula("Harry");
			mostrarCatalogo(partePelicula);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n===========CASO DE PRUEBA 4===========\n");
		try {
			System.out.println(incaa.traerPelicula(8));
			incaa.modificarPelicula(8, "Harry Potter", genero1);
			System.out.println(incaa.traerPelicula(8));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("\n===========CASO DE PRUEBA 5===========\n");
		try {
			System.out.println(incaa.traerPelicula(9));
			incaa.eliminarPelicula(9);
			System.out.println(incaa.traerPelicula(9));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n===========CASO DE PRUEBA 6===========\n");
		try {
			List<Pelicula> genero = new ArrayList<Pelicula>();
			genero = incaa.traerPelicula(genero5);
			mostrarCatalogo(genero);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println(incaa.toString());
	}

	public static void mostrarCatalogo(List<Pelicula> peliculas) {
		for(int i=0;i<peliculas.size();i++) {
			System.out.println("ID Pelicula: "+peliculas.get(i).getIdPelicula()+" Nombre: "
					+peliculas.get(i).getPelicula()+" -- "+peliculas.get(i).getGenero()+" \n");
		}
	}
}
