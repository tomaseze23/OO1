package datos;

public abstract class Aula {
	protected int idAula;
	protected int numero;
	protected Edificio edificio;

	public Aula() {
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
		return "Aula [idAula=" + idAula + ", numero=" + numero + ", edificio=" + edificio.toString() + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAula;
		return result;	}

	public boolean equals(Aula aula) {
		return (aula.getIdAula()==idAula);
	}

	
}
