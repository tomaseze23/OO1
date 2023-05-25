package negocio;


import dao.LugarDao;

import datos.Lugar;

public class LugarAbm {

    private static LugarAbm instancia = null;// Patrón Singleton

    protected LugarAbm() {
    }

    public static LugarAbm getInstance() {
        if (instancia == null) {
            instancia = new LugarAbm();
        }

        return instancia;
    }

    // -----------------TRAER-----------------
 
    public Lugar traerLugar(int id) {
        return LugarDao.getInstance().traerLugar(id);
    }


}
