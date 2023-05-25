package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaAbm {
    

    private static PersonaAbm instancia = null;// Patrón Singleton

    protected PersonaAbm() {
    }

    public static PersonaAbm getInstance() {
        if (instancia == null) {
            instancia = new PersonaAbm();
        }

        return instancia;
    }


    //Traer Persona

    public Persona traer(int idPersona) {
        return PersonaDao.getInstance().traer(idPersona);
    }

}
