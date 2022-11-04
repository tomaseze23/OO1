package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaSaludDispositivos {
	private List<Empresa> lstEmpresas;
	private List<Dispositivo> lstDispositivos;

	public SistemaSaludDispositivos() {
		lstEmpresas = new ArrayList<Empresa>();
		lstDispositivos = new ArrayList<Dispositivo>();
	}

	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}

	public List<Dispositivo> getLstDispositivos() {
		return lstDispositivos;
	}

	public boolean agregarEmpresa(String nombre) {
		int id = 1;
		if (!lstEmpresas.isEmpty()) {
			id = lstEmpresas.get(lstEmpresas.size() - 1).getId() + 1;
		}
		return lstEmpresas.add(new Empresa(id, nombre));
	}

	public Empresa traerEmpresa(String nombre) {
		int indice = 0;
		Empresa empresaAuxiliar = null;
		while (empresaAuxiliar == null && indice < lstEmpresas.size()) {
			if (lstEmpresas.get(indice).getNombre().equals(nombre)) {
				empresaAuxiliar = lstEmpresas.get(indice);
			}
			indice++;
		}
		return empresaAuxiliar;
	}

	public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		int id = 1;
		if (!lstDispositivos.isEmpty()) {
			id = lstDispositivos.get(lstDispositivos.size() - 1).getId() + 1;
		}
		return lstDispositivos.add(new Dispositivo(id, nombre, codigo, empresa));
	}

	public Dispositivo traerDispositivo(String codigo) {
		int indice = 0;
		Dispositivo dispositivoAuxiliar = null;
		while (dispositivoAuxiliar == null && indice < lstDispositivos.size()) {
			if (lstDispositivos.get(indice).getCodigo().equals(codigo)) {
				dispositivoAuxiliar = lstDispositivos.get(indice);
			}
			indice++;
		}
		return dispositivoAuxiliar;
	}

}
