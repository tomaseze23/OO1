package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	private int idPersona;
	private int documento;
	private LocalDate fechaNacimiento;
	private boolean tieneComorbilidad;
	
	public Persona(){}

	public Persona(int documento, LocalDate fechaNacimiento, boolean tieneComorbilidad) {
		super();
		
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneComorbilidad = tieneComorbilidad;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", documento=" + documento + ", fechaNacimiento=" + fechaNacimiento
				+ ", tieneComorbilidad=" + tieneComorbilidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isTieneComorbilidad() {
		return tieneComorbilidad;
	}

	public void setTieneComorbilidad(boolean tieneComorbilidad) {
		this.tieneComorbilidad = tieneComorbilidad;
	}
	
	public int calcularEdad(LocalDate hoy) {
		
		return hoy.getYear()-fechaNacimiento.getYear();
	}
	
	
}
