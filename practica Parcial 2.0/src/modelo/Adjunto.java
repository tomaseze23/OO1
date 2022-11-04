package modelo;

public class Adjunto {
	private String nombre;
	private String extension;
	public Adjunto(String nombre, String extension) {
		this.nombre = nombre;
		this.extension = extension;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "Archivo Adjunto: " + nombre + "." + extension;
	}
	
}
