package geometria;

public class Circulo {
	//atributos
	private Punto origen;
	private double radio;
	
	//constructor
	public Circulo(Punto origen, double radio) {
		super();
		this.origen = origen;
		this.radio = radio;
	}

	//getters y setters
	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	public double getRadio() {
		return radio;
	}

	//setRadio redefinido
	public void setRadio(Punto p) {
		radio = origen.calcularDistancia(p);
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	//equals redefinido
	public boolean equals(Circulo c) {
		return((origen.equals(c.getOrigen()))&&(radio==c.getRadio()));
	}
	
	//toString redefinido
	public String toString() {
		return "Circulo [origen=" + origen + ", radio=" + radio + "]";
	}
	
	public double calcularPerimetro() {
		return (2*Math.PI*radio);
	}
	
	public double calcularArea() {
		return (Math.PI*(Math.pow(radio, 2)));
	}
	
	public double calcularDistancia(Circulo c) {
		return origen.calcularDistancia(c.getOrigen());
	}

	public void mover(double desplazamientoX, double desplazamientoY) {
		// hacemos una copia del origen para no modificar el atributo de
		// la clase
		Punto nuevoOrigen = new Punto(origen.getX(), origen.getY());
		// asignamos el nuevo origen de este círculo
		origen = nuevoOrigen;
		// ahora sí, movemos el círculo
		origen.mover(desplazamientoX, desplazamientoY);
	}
}
