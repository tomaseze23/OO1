package modelo;

public class Pelicula {
	//atributos
	private int idPelicula;
	private String pelicula;
	private Genero genero;
	
	//constructor
	public Pelicula(int idPelicula, String pelicula, Genero genero) {
		this.idPelicula = idPelicula;
		this.pelicula = pelicula;
		this.genero = genero;
	}
	public Pelicula(String pelicula, Genero genero) {
		this.idPelicula = (int)(Math.random()*(9999-1000+1)+1000);
		this.pelicula = pelicula;
		this.genero = genero;
	}
	//getter y setter
	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "ID Pelicula: " + idPelicula + " Nombre de Pelicula: " + pelicula + " - Genero: " + genero.getGenero()+"\n";
	}
	
}
