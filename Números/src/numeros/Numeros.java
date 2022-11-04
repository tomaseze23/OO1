package numeros;

public class Numeros {
	//atributos
	private int numero;

	//constructor
	public Numeros(int numero) {
		this.numero = numero;
	}

	//getter y setter
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//metodos pedidos
	public int sumar(int numero) {
		return this.numero+numero;
	}

	public int multiplicar (int numero) {
		return this.numero*numero;
	}
	public boolean esPar() {
		return ((numero%2)==0);
	}
	public boolean esPrimo() {
		int x=2;
		boolean primo = !(numero == 0 || numero == 1 || numero == 4);
		while(x < numero/2) {
			primo = !(numero%x==0);
			x++;
		}
		return primo;
	}
	public String convertirAString() {
		return String.valueOf(numero);
	}
	public double convertirADouble() {
		return Double.parseDouble(convertirAString());
	}
	public double calcularPotencia(int exponente) {
		return Math.pow(numero, exponente);
	}
	public String pasarBase2() {
		String numeroBinario = "";
		int n=numero;
		if (n<=0) {
			numeroBinario ="0";
		}else {
			while(n>0) {
				numeroBinario=(n%2)+numeroBinario;
				n/=2;
			}
		}
		return numeroBinario;
	}
	public int calcularFactorial(int numero) {
		int factorial=1;
		int numAuxiliar=numero;
		if(numAuxiliar>0) {
			while(numAuxiliar!=0) {
				factorial*=numAuxiliar;
				numAuxiliar--;
			}
		}
		return factorial;
	}
	public int calcularFactorial() {
		return calcularFactorial(numero);
	}
	public float numeroCombinatorio(int n1) {
		return this.calcularFactorial()/(calcularFactorial(n1)*calcularFactorial(numero-n1));
	}
}
