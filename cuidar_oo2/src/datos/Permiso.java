package datos;

import java.time.LocalDate;
import java.util.Set;

public class Permiso {
	private int idPermiso;
	private Persona persona;
	private LocalDate fecha;
	private int cantDias;
	private Rodado rodado;
	private Set<Lugar> desdeHasta;
	
	public Permiso() {}

	public Permiso(Persona persona, LocalDate fecha, int cantDias, Rodado rodado, Set<Lugar> desdeHasta) {
		super();
		this.persona = persona;
		this.fecha = fecha;
		this.cantDias = cantDias;
		this.rodado = rodado;
		this.desdeHasta = desdeHasta;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	protected void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", fecha=" + fecha + ", cantDias="
				+ cantDias + "]";
	}
	
	public boolean ingresoHabilitado( int idPermiso, LocalDate dia){
		boolean variable=false;
		for (Lugar p: this.desdeHasta){
			if(p instanceof Ubicacion) {
				if(this.fecha.equals(dia)) {
					variable = true;
				}
			}else {
				if(this.fecha.plusDays(cantDias).equals(dia)) {
					variable=true;
				}
			}
		}
		return variable;
	}
}
