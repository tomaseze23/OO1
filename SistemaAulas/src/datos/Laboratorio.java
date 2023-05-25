package datos;

import java.util.Objects;

public class Laboratorio extends Aula {
	private int idLaboratorio;
	private int cantPC;
	private int cantSillas;
	
	public Laboratorio() {}
	
	public Laboratorio(int numero, Edificio edificio, int cantPC, int cantSillas) {
		super(numero, edificio);
		this.cantPC = cantPC;
		this.cantSillas = cantSillas;
	}

	public int getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public int getCantPC() {
		return cantPC;
	}

	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}

	@Override
	public String toString() {
		return "Laboratorio [idLaboratorio=" + idLaboratorio + ", cantPC=" + cantPC + ", cantSillas=" + cantSillas
				+ super.toString() +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idLaboratorio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laboratorio other = (Laboratorio) obj;
		return idLaboratorio == other.idLaboratorio;
	}
	
	
}
