package datos;

import java.util.Objects;

public class Abonado {
	
	private int idAbonado;
	private String apellido;
	private String nombres;
	private int dni;
	
	public Abonado() {}

	public Abonado(String apellido, String nombre, int dni) {
		super();
		
		this.apellido = apellido;
		this.nombres = nombre;
		this.dni = dni;
	}

	public int getIdAbonado() {
		return idAbonado;
	}

	protected void setIdAbonado(int idAbonado) {
		this.idAbonado = idAbonado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombre) {
		this.nombres = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAbonado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonado other = (Abonado) obj;
		return idAbonado == other.idAbonado;
	}

	@Override
	public String toString() {
		return "Abonado [idAbonado=" + idAbonado + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni
				+ "]";
	}

}
