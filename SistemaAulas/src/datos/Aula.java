package datos;

import java.util.Objects;

public abstract class Aula {
	protected int idAula;
	protected int numero;
	protected Edificio edificio;
	
	public Aula() {}
	
	public Aula(int numero, Edificio edificio) {
		super();
		this.numero = numero;
		this.edificio = edificio;
	}

	public int getIdAula() {
		return idAula;
	}

	protected void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", numero=" + numero + ", edificio=" + edificio.toString() +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return idAula == other.idAula;
	}
}
