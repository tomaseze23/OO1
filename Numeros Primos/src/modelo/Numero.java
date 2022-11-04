package modelo;

public class Numero {
	private int n;

	public Numero(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public boolean esPrimo() {
		int x=2;
		boolean primo = !(n == 0 || n == 1 || n == 4);
		while(primo && x < n/2) {
			primo = !(n%x==0);
			x++;
		}
		return primo;
	}
	public boolean esPrimo(int n) {
		int x=2;
		boolean primo = !(n == 0 || n == 1 || n == 4);
		while(primo && x < n/2) {
			primo = !(n%x==0);
			x++;
		}
		return primo;
	}
	public boolean esPrimoMellizo(Numero n) {
		return esPrimo(this.n)&&esPrimo(n.getN())&&Math.abs(this.n-n.getN())==2;
	}

	@Override
	public String toString() {
		return n+ " ";
	}
	
	public String imprimirPrimos() {
		String ret="";
		for(int i=0;i<=n;i++) {
			if(esPrimo(i)) {
				ret=ret+i+" ";
			}
		}
		return ret;
	}

}
