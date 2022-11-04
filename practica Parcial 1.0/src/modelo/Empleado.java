package modelo;

public class Empleado extends Persona {
	private int nroLegajo;

	public Empleado(int id, String apellido, String nombre, int dni, int nroLegajo) {
		super(id, apellido, nombre, dni);
		this.nroLegajo = nroLegajo;
	}

	public int getNroLegajo() {
		return nroLegajo;
	}

	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	@Override
	public String toString() {
		return "Empleado: " + super.toString() + " Número de Legajo: " + nroLegajo;
	}

	public boolean equals(Empleado empleado) {
		return nroLegajo == empleado.getNroLegajo();
	}

}
