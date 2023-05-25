package datos;

import java.util.Objects;

public class Materia {
	
	private int idMateria;
	private String nombre;
	private String carrera;
	
	public Materia() {}

	public Materia(String nombre, String carrera) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
	}

	public int getIdMateria() {
		return idMateria;
	}

	protected void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMateria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return idMateria == other.idMateria;
	}

	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", nombre=" + nombre + ", carrera=" + carrera + "]";
	}

}
