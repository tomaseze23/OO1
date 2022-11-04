package geometria;

public class Punto {
	//atributos
	private double x;
	private double y;
	
	//metodo constructor
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//metodos getter y setter
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void mover(double desplazamientoX, double desplazamientoY){
		x = x + desplazamientoX;
		y = y + desplazamientoY;
	}

	//equals redefinido
	public boolean equals(Punto p) {
		return ((x==p.getX())&&(y==p.getY()));
	}
	
	//toString redefinido
	public String toString() {
		return "("+x+";"+y+")";
	}
	
	public double calcularDistancia(Punto p) {
		double catetoX = x-p.getX();
		double catetoY = y-p.getY();
		double sumaCuadrados = Math.pow(catetoX, 2)+Math.pow(catetoY, 2);
		return Math.sqrt(sumaCuadrados);
	}
}
