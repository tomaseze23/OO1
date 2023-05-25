package datos;

public class Laboratorio extends Aula {
	private int cantPC;
	private int cantSillas;

	public Laboratorio() {
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
		return "Laboratorio [cantPC=" + cantPC + ", cantSillas=" + cantSillas + "]\n";
	}

}
