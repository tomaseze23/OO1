package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaYPF {
	private List<Tarjeta> tarjetas;
	
	public SistemaYPF() {
		tarjetas = new ArrayList<Tarjeta>();
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	
	public boolean agregarTarjeta(String codigo, String codigoCliente) throws Exception {
		int id=1;
		if(!tarjetas.isEmpty()) {
			id = tarjetas.get(tarjetas.size() - 1).getIdTarjeta() + 1;
		}
		return tarjetas.add(new Tarjeta(id, codigo, codigoCliente));
	}
	public Tarjeta traerTarjeta(String codigoCliente) {
		Tarjeta auxiliar=null;
		int indice=0;
		while(indice<tarjetas.size()) {
			if(tarjetas.get(indice).getCodigoCliente().equals(codigoCliente)) {
				auxiliar=tarjetas.get(indice);
			}
			indice++;
		}
		return auxiliar;
	}
}
