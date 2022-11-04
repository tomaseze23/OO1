package modelo;

public class Genero {
	//atributos
	private int idGenero;
	private String genero;

	//constructor
	public Genero(int idGenero, String genero) {
		this.idGenero = idGenero;
		this.genero = genero;
	}

	//getters y setters
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "ID Genero: " + idGenero + " Genero: " + genero + " ";
	}
	
	
}
