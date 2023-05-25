package datos;

import java.util.Objects;

public class Tradicional extends Aula{
	private int idTradicional;
	private int cantBancos;
	private char pizarron;
	private boolean tieneProyector;
	
	public Tradicional() {}
	
	public Tradicional(int numero, Edificio edificio, int cantBancos, char pizarron) {
		super(numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = false;
	}

	public int getIdTradicional() {
		return idTradicional;
	}

	public void setIdTradicional(int idTradicional) {
		this.idTradicional = idTradicional;
	}

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public char getPizarron() {
		return pizarron;
	}

	public void setPizarron(char pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Tradicional [idTradicional=" + idTradicional + ", cantBancos=" + cantBancos + ", pizarron=" + pizarron
				+ ", tieneProyector=" + tieneProyector + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idTradicional);
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
		Tradicional other = (Tradicional) obj;
		return idTradicional == other.idTradicional;
	}
	
	
}
