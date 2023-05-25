package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Permiso;
import datos.PermisoPeriodo;

public class PermisoDao {
    private static Session session;
    private Transaction tx;
    private static PermisoDao instancia = null; // Patrón Singleton

    protected PermisoDao() {
    }

    public static PermisoDao getInstance() {
        if (instancia == null)
            instancia = new PermisoDao();
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
    public int agregar(Permiso objeto) {
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
    public void actualizar(Permiso objeto) throws HibernateException {
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
    public void eliminar(Permiso objeto) throws HibernateException {
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

    // -----------------TRAER POR ID-----------------
    public Permiso traer(long dni) {
        Permiso objeto = null;
        try {
            iniciaOperacion();
            objeto = (Permiso) session.createQuery("from Permiso p where p.dni =" + dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    // -----------------TRAER POR ID-----------------
    public Permiso traer(int id) {
        Permiso objeto = null;
        try {
            iniciaOperacion();
            objeto = (Permiso) session.get(Permiso.class, id);

            Hibernate.initialize(objeto.getPersona());
            if (objeto instanceof PermisoPeriodo) { 
                Hibernate.initialize(((PermisoPeriodo)objeto).getRodado()); 
            }

        } finally {
            session.close();
        }
        return objeto;
    }


    // Traer por Todos
    @SuppressWarnings("unchecked")
    public List<Permiso> traer() throws HibernateException {
        List<Permiso> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Permiso").list();
        } finally {
            session.close();
        }
        return lista;
    }
}
