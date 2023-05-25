package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Espacio {
	private int idEspacio;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;
	
	public Espacio() {}

	public Espacio(int idEspacio, LocalDate fecha, char turno, Aula aula) {
		super();
		this.idEspacio = idEspacio;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = false;
		
	}

	public int getIdEspacio() {
		return idEspacio;
	}

	protected void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEspacio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return idEspacio == other.idEspacio;
	}

	@Override
	public String toString() {
		return "Espacio [idEspacio=" + idEspacio + ", fecha=" + fecha + ", turno=" + turno + ", libre=" + libre + "]";
	}
	
	
}
