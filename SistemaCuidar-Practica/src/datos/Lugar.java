package datos;

public class Lugar {
	private int idLugar;
	private String lugar;
	private String codigoPostal;

	public Lugar() {
	}

	public Lugar(String lugar, String codigoPostal) {
		super();
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	protected void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}

}
