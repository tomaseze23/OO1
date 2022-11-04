package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	List<Servicio> lstServicio;

	public Sistema() {
		lstServicio = new ArrayList<Servicio>();
	}
	public Servicio traerServicio(String codServicio) {
		Servicio auxiliar = null;
		int indice=0;
		while(indice<lstServicio.size()) {
			if(lstServicio.get(indice).getCodServicio().equals(codServicio)) {
				auxiliar=lstServicio.get(indice);
			}
			indice++;
		}
		return auxiliar;
	}
	
	public boolean agregarGastronomia (String codServicio, double porcentajeDescuento, boolean enPromocion, String
			gastronomia, double precio, int diaSemDesc) throws Exception {
		if(traerServicio(codServicio)!=null) {
			throw new Exception("ERROR: El servicio gastronomico que intenta agregar ya existe.");
		}
		return lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
	}
	
	public boolean agregarHospedaje (String codServicio, double porcentajeDescuento, boolean enPromocion, String
			hospedaje,double precioPorNoche) throws Exception {
		if(traerServicio(codServicio)!=null) {
			throw new Exception("ERROR: El servicio de hospedaje que intenta agregar ya existe.");
		}
		return lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
	}
	
	public List<Servicio> traerServicio(boolean enPromocion){
		List<Servicio> coincidentes = new ArrayList<Servicio>();
		for(int i=0;i<lstServicio.size();i++){
			if(lstServicio.get(i).isEnPromocion() == enPromocion) {
				coincidentes.add(lstServicio.get(i));
			}
		}
		return coincidentes;
	}
	
	public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia){
		List<Servicio> coincidentes = new ArrayList<Servicio>();
		List<Servicio> auxiliar = traerServicio(enPromocion);
		for(int i=0;i<auxiliar.size();i++) {
			if(auxiliar.get(i) instanceof Gastronomia) {
				Gastronomia aux = (Gastronomia) auxiliar.get(i);
				if(aux.getDiaSemDesc() == dia.getDayOfWeek().getValue()) {
					coincidentes.add(aux);
				}
			}
		}
		return coincidentes;
	}
	public List<Servicio> getLstServicio() {
		return lstServicio;
	}
}
