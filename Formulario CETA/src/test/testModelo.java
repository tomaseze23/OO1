package test;

import java.time.LocalDate;

import modelo.Ceta;
import modelo.Contribuyente;
import modelo.Rodado;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====TEST 1: CUIL INCORRECTO=====");
		Contribuyente contribuyente1=new Contribuyente(0, "Tomás", "Zarich", 44093293, 'M', "20-44093293-5");
		System.out.println("=====TEST 2: DOMINIO INCORRECTO=====");
		Rodado rodado1 = new Rodado(0, "AC 123", 10, "Ford");
		Rodado rodado2 = new Rodado(0, "AB 13 CD", 10, "Ford");
		System.out.println("=====TEST 3: COMPRADOR Y VENDEDOR SON EL MISMO=====");//se chequea cuil de ambas personas.
		Contribuyente comprador=new Contribuyente(0, "Tomás", "Zarich", 44093293, 'M', "20-44093293-3");
		Contribuyente vendedor=new Contribuyente(1, "Tomás", "Zarich", 44093293, 'M', "20-44093293-3");
		Ceta ceta1= new Ceta(0, LocalDate.of(2022, 8, 10), comprador, comprador, 1500);
		System.out.println("=====TEST 4: FECHA POSTERIOR A LA ACTUAL=====");
		Contribuyente contribuyente2=new Contribuyente(1, "Nora", "Leone", 13597893, 'F', "27-13597893-6");
		Ceta ceta2= new Ceta(0, LocalDate.of(2022, 9, 17), comprador, contribuyente2, 1500);
		System.out.println("=====TEST 5: FUNCIONANDO TODO BIEN=====");
		Contribuyente compr=new Contribuyente(0, "Tomás", "Zarich", 44093293, 'M', "20-44093293-3");
		Contribuyente contr=new Contribuyente(1, "Nora", "Leone", 13597893, 'F', "27-13597893-6");
		Rodado rodado = new Rodado(0, "ABC 123", 10, "Ford");
		System.out.println(rodado);
		Ceta ceta= new Ceta(0, LocalDate.of(2022, 8, 10), compr, contr, 1500);
		System.out.println(ceta);
	}

}
