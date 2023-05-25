package datos;

import java.time.LocalDate;
import java.util.Objects;

public abstract class NotaPedido {
	
	protected int idNotaPedido;
	protected LocalDate fecha;
	protected int cantEstudiantes;
	protected Materia materia;
	
	public NotaPedido() {}

	public NotaPedido(LocalDate fecha, int cantEstudiantes, Materia materia) {
		super();
		this.fecha = fecha;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
	}

	public int getIdNotaPedido() {
		return idNotaPedido;
	}

	protected void setIdNotaPedido(int idPedido) {
		this.idNotaPedido = idPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantEstudiantes() {
		return cantEstudiantes;
	}

	public void setCantEstudiantes(int cantEstudiantes) {
		this.cantEstudiantes = cantEstudiantes;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNotaPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaPedido other = (NotaPedido) obj;
		return idNotaPedido == other.idNotaPedido;
	}

	@Override
	public String toString() {
		return "NotaPedido [idPedido=" + idNotaPedido + ", fecha=" + fecha + ", cantEstudiantes=" + cantEstudiantes
				+ ", materia=" + materia + "]";
	}

}
