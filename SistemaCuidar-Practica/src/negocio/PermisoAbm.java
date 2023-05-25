package negocio;


import java.util.List;

import dao.PermisoDao;

import datos.Permiso;
import datos.PermisoDiario;
import datos.PermisoPeriodo;


public class PermisoAbm {

    private static PermisoAbm instancia = null;// Patrón Singleton

    protected PermisoAbm() {
    }

    public static PermisoAbm getInstance() {
        if (instancia == null) {
            instancia = new PermisoAbm();
        }

        return instancia;
    }

 


    // -----------------TRAER-----------------


    public Permiso traerPermisoDiario(int idPermiso) throws Exception {

        Permiso permiso = PermisoDao.getInstance().traer(idPermiso);

        if (permiso instanceof PermisoPeriodo) {
           throw new Exception("\n **El permiso seleccionado no corresponde a la clase solicitada (PermisoDiario)** \n");
        }

        return permiso;
    }

    public Permiso traerPermisoPeriodo(int idPermiso) throws Exception {

        Permiso permiso = PermisoDao.getInstance().traer(idPermiso);

        if (permiso instanceof PermisoDiario) {
           throw new Exception("\n **El permiso seleccionado no corresponde a la clase solicitada (PermisoPeriodo)** \n");
        }

        return permiso;
    }

    public List<Permiso> traer() {

        return PermisoDao.getInstance().traer();
    }

    // -----------------ingresoHabilitado-----------------

}
