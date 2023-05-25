package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Persona;

public class PersonaDao {
    private static Session session;
    private Transaction tx;
    private static PersonaDao instancia = null; // Patrón Singleton

    protected PersonaDao() {
    }

    public static PersonaDao getInstance() {
        if (instancia == null)
            instancia = new PersonaDao();
        return instancia;
    }

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    // -----------------AGREGAR-----------------
    public int agregar(Persona objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    // -----------------Actualizar-----------------
    public void actualizar(Persona objeto) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // -----------------ELIMINAR-----------------
    public void eliminar(Persona objeto) throws HibernateException {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // -----------------TRAER POR dni-----------------
    public Persona traer(long dni) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            objeto = (Persona) session.createQuery("from Persona p where p.dni =" + dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    // -----------------TRAER POR ID-----------------
    public Persona traer(int id) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            objeto = (Persona) session.get(Persona.class, id);

           // Hibernate.initialize(objeto.getPersona());

        } finally {
            session.close();
        }
        return objeto;
    }

    // Traer por Todos
    @SuppressWarnings("unchecked")
    public List<Persona> traer() throws HibernateException {
        List<Persona> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Persona").list();
        } finally {
            session.close();
        }
        return lista;
    }
}
