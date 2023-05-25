package datos;

import java.util.Objects;

public class Rodado {
	
	private int idRodado;
	private String dominio;
	private int categoria;
	private Abonado abonado;
	
	public Rodado() {}

	public Rodado(String dominio, int categoria, Abonado abonado) {
		super();
		this.dominio = dominio;
		this.categoria = categoria;
		this.abonado = abonado;
	}

	public int getIdRodado() {
		return idRodado;
	}

	protected void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Abonado getAbonado() {
		return abonado;
	}

	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRodado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rodado other = (Rodado) obj;
		return idRodado == other.idRodado;
	}

	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", dominio=" + dominio + ", categoria=" + categoria + "\nabonado="
				+ abonado + "]";
	}

}
