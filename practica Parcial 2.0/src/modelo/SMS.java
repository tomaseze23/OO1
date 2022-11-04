package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class SMS extends Mensaje{
	private int numeroOrigen;
	private int numeroDestino;
	private String texto;
	private boolean visto;
	public SMS(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino,
			String texto, boolean visto) throws Exception {
		super(idMensaje, fechaEnvio, horaEnvio);
		setNumeroOrigen(numeroOrigen);
		setNumeroDestino(numeroDestino);
		this.texto = texto;
		this.visto = visto;
	}
	public int getNumeroOrigen() {
		return numeroOrigen;
	}
	public void setNumeroOrigen(int numeroOrigen) throws Exception {
		if(!validarTelefono(numeroOrigen)) {
			throw new Exception("ERROR: El telefono es incorrecto.");
		}
		this.numeroOrigen = numeroOrigen;
	}
	public int getNumeroDestino() {
		return numeroDestino;
	}
	public void setNumeroDestino(int numeroDestino) throws Exception {
		if(!validarTelefono(numeroDestino)) {
			throw new Exception("ERROR: El telefono es incorrecto.");
		}
		this.numeroDestino = numeroDestino;
	}
	public boolean validarTelefono(int telefono) {
		return String.valueOf(telefono).length()==10;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isVisto() {
		return visto;
	}
	public void setVisto(boolean visto) {
		this.visto = visto;
	}
	@Override
	public String toString() {
		return "NÚMERO DE ORIGEN: " + numeroOrigen + "\nNÚMERO DE DESTINO: " + numeroDestino + "\nTEXTO: " + texto
				+"\nMENSAJE: "+ super.toString() + "\nVisto: " + visto;
	}
	
	public void cambiarDeEstado(boolean estadoNuevo) {
		visto=estadoNuevo;
	}
	
}
