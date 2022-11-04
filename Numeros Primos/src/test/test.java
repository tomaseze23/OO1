package test;
import modelo.Numero;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numero n= new Numero(3);
		Numero n1 = new Numero(19);
		System.out.println("TEST 1: ");
		System.out.println("¿Es Primo?: "+n.esPrimo());
		System.out.println("¿Es Primo?: "+n1.esPrimo());
		System.out.println("¿Son gemelos?: "+ n.esPrimoMellizo(n1));
		System.out.println("=======================================");
		System.out.println(n1.imprimirPrimos());
		System.out.println(n.imprimirPrimosMellizos(n1));
	}
}
