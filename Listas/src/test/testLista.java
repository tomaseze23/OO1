package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;

public class testLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Rellenaremos una lista de datos de tipo String\n");
		List<String> lista = new ArrayList<String>();
		String elemento = "";
		while(!(elemento.equalsIgnoreCase("stop"))) {
			System.out.println("Cuando desee finalizar ingrese 'stop': ");
			elemento = in.nextLine();
			if(!(elemento.equals("stop"))) {
				lista.add(elemento);
			}
		}
		
		//tipos de impresion de una lista
		System.out.println("1- con un for each");
		for(String s: lista) {
			System.out.println(s);
		}
		
		System.out.println("2- con un for con indice");
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println("3- con Iterator<tipo>");
		for(Iterator<String> iter = lista.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
		
		in.close();
	}

}
