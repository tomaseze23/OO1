package test;

import negocio.LugarABM;
import negocio.PermisoABM;
import datos.Lugar;
import datos.Permiso;

public class Test {

	public static void main(String[] args) {
		LugarABM abmLugar = new LugarABM();
		PermisoABM abmPermiso = new PermisoABM();
		int idPermiso = 4;
		System.out.println("1) Traer permiso id=" + idPermiso);
		Permiso p = abmPermiso.traerPermiso(idPermiso);
		System.out.println("\n\n" + p);
		Lugar u;
		int idLocalidad=3;
		System.out.println("2)Traer objeto Localidad con todos sus atributos id=" + idLocalidad);
		try {
			u = abmLugar.traerLocalidad(idLocalidad);
			System.out.println("\n\n" + u);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int idLugar = 4;
		System.out.println("\n\n6) Traer objeto Ubicacion con todos sus atributos id=" + idLugar);
		Lugar u1;
		try {
			u1 = abmLugar.traerUbicacion(idLugar);
			System.out.println("\n\n" + u1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
