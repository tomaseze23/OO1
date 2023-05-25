package datos;

public abstract class Lugar {
	protected int idLugar;
	protected String lugar;
	
	public Lugar() {}

	public Lugar(String lugar) {
		super();
		this.lugar = lugar;
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

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + "]";
	}

	public boolean equals(Lugar lugar) {
		return this.idLugar == lugar.getIdLugar();
	}
	
}
