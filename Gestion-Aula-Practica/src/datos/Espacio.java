package datos;

import java.time.LocalDate;

public class Espacio {
	private int idEspacio;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;

	public Espacio() {
	}

	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
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
	public String toString() {
		return "Espacio [idEspacio=" + idEspacio + ", fecha=" + fecha + ", turno=" + turno + ", aula=" + aula
				+ ", libre=" + libre + "]";
	}

	@Override
	public int hashCode() { // Generado junto al equals (Generado solamente con el idEspacio)
		final int prime = 31;
		int result = 1;
		result = prime * result + idEspacio;
		return result;
	}

	public boolean equals(Espacio espacio) { // Compara por id
		return (espacio.getIdEspacio() == this.getIdEspacio());
	}	
}
