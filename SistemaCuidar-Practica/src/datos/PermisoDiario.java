package datos;

import java.time.LocalDate;

public class PermisoDiario extends Permiso {
	private int idPermisoDiario;
	private String motivo;

	public PermisoDiario() {
	}

	public PermisoDiario(String motivo) {
		super();
		this.motivo = motivo;
	}

	public int getIdPermisoDiario() {
		return idPermisoDiario;
	}

	protected void setIdPermisoDiario(int idPermisoDiario) {
		this.idPermisoDiario = idPermisoDiario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [idPermisoDiario=" + idPermisoDiario + ", motivo=" + motivo + "]";
	}
	
    public boolean activo(LocalDate dia) {
        boolean activo = false;

        if (this.fecha.equals(dia))
            activo = true;

        return activo;

    }
}
