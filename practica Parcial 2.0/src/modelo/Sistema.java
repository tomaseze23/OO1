package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Mensaje> listaMensajes;

	public Sistema() {
		listaMensajes = new ArrayList<Mensaje>();
	}

	public boolean agregarEmail(LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino , String
			asunto, String cuerpo, Adjunto adjunto) throws Exception {
		int id=1;
		if(!listaMensajes.isEmpty()) {
			id = listaMensajes.get(listaMensajes.size()-1).getIdMensaje() + 1;
		}
		return listaMensajes.add(new Email(id, fechaEnvio, horaEnvio, origen, destino, asunto, cuerpo, false, adjunto));
	}
	
	public boolean agregarSMS(LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino,
			String texto) throws Exception {
		int id=1;
		if(!listaMensajes.isEmpty()) {
			id = listaMensajes.get(listaMensajes.size() - 1).getIdMensaje() + 1;
		}
		return listaMensajes.add(new SMS(id, fechaEnvio, horaEnvio, numeroOrigen, numeroDestino, texto, false));
	}
	
	public Mensaje traerMensaje(int idMensaje) {
		Mensaje auxiliar=null;
		int indice=0;
		while(auxiliar==null&&indice<listaMensajes.size()) {
			if(listaMensajes.get(indice).getIdMensaje() == idMensaje) {
				auxiliar=listaMensajes.get(indice);
			}
			indice++;
		}
		return auxiliar;
	}
	
	public List<Mensaje> traerMensaje(String extension){
		List<Mensaje> coincidentes = new ArrayList<Mensaje>();
		for(int i=0;i<listaMensajes.size();i++) {
			if(listaMensajes.get(i) instanceof Email) {
				Email auxiliar = (Email) listaMensajes.get(i);
				if(auxiliar.getAdjunto().getExtension().equals(extension)) {
					coincidentes.add(auxiliar);
				}
			}
		}
		return coincidentes;
	}
	
	public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta){
		List<Mensaje> coincidentes = new ArrayList<Mensaje>();
		for(int i=0;i<listaMensajes.size();i++) {
			if (listaMensajes.get(i).getFechaEnvio().equals(fecha)
					&& (listaMensajes.get(i).getHoraEnvio().isAfter(horaDesde) && listaMensajes.get(i).getHoraEnvio().isBefore(horaHasta))) {
				coincidentes.add(listaMensajes.get(i));
			}
		}		
		return coincidentes;
	}
	
	public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String extension){
		List<Mensaje> coincidentes = new ArrayList<Mensaje>();
		List<Mensaje> auxiliar = traerMensaje(fecha, horaDesde, horaHasta);
		for(int i=0;i<auxiliar.size();i++) {
			if(auxiliar.get(i) instanceof Email) {
				Email mailAux = (Email) auxiliar.get(i);
				if (mailAux.getAdjunto().getExtension().equals(extension)) {
					coincidentes.add(mailAux);
				}
			}
		}		
		return coincidentes;
		
	}
	
	public List<Mensaje> getListaMensajes() {
		return listaMensajes;
	}
}
