package datos;

import java.time.LocalDate;

public class PermisoPeriodo extends Permiso {
	private int idPermisoPeriodo;
	private int cantDias;
	private boolean vacaciones;
	private Rodado rodado;

	public PermisoPeriodo() {
	}

	public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getIdPermisoPeriodo() {
		return idPermisoPeriodo;
	}

	protected void setIdPermisoPeriodo(int idPermisoPeriodo) {
		this.idPermisoPeriodo = idPermisoPeriodo;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [idPermisoPeriodo=" + idPermisoPeriodo + ", cantDias=" + cantDias + ", vacaciones="
				+ vacaciones + ", rodado=" + rodado + "]";
	}

    @Override
    public boolean activo(LocalDate dia) {
        boolean activo = false;

        LocalDate fechaVencimiento = this.fecha.plusDays(cantDias);

        if ((dia.isAfter(this.fecha)) && dia.isBefore(fechaVencimiento) || dia.equals(this.fecha)
                || dia.equals(fechaVencimiento)) {
            activo = true;

        }

        return activo;
    }
}
