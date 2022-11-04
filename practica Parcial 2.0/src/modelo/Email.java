package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email extends Mensaje{
	private String origen;
	private String destino;
	private String asunto;
	private String cuerpo;
	private boolean recibido;
	private Adjunto adjunto;
	public Email(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto,
			String cuerpo, boolean recibido, Adjunto adjunto) throws Exception{
		super(idMensaje, fechaEnvio, horaEnvio);
		setOrigen(origen);
		setDestino(destino);
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.recibido = recibido;
		this.adjunto = adjunto;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) throws Exception {
		if(!validarMail(origen)) {
			throw new Exception("ERROR: Mail incorrecto.");
		}
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) throws Exception {
		if(!validarMail(destino)) {
			throw new Exception("ERROR: Mail incorrecto.");
		}
		this.destino = destino;
	}
	
	public boolean validarMail(String mail) {
		return mail.contains("@");
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public boolean isRecibido() {
		return recibido;
	}
	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}
	public Adjunto getAdjunto() {
		return adjunto;
	}
	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}
	@Override
	public String toString() {
		return "ORIGEN: " + origen + "\nDESTINO: " + destino + "\nASUNTO: " + asunto + "\nCUERPO: " + cuerpo
				+ "\nRecibido: " + recibido + "\nMENSAJE: " + super.toString() + "\nADJUNTO: " + adjunto.toString();
	}
	
	public void cambiarDeEstado(boolean estadoNuevo) {
		recibido=estadoNuevo;
	}
	
}
