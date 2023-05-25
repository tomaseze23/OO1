package datos;

public class Tradicional extends Aula{
	
	private int cantBancos;
	private String pizarron; //seguramente es n/y
	private boolean tieneProyector;
	
	public Tradicional() {}
	
	public Tradicional(int numero, Edificio edificio, int cantBancos, String pizarron, boolean tieneProyector) {
		super(numero, edificio);

		this.cantBancos = cantBancos;
	}

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public String getPizarron() {
		return pizarron;
	}

	public void setPizarron(String pizarron) {
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
		return super.toString()+"Tradicional [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector=" + tieneProyector
				+ "]";
	}
	
	

}
