package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lugar;


public class LugarDao {
    private static Session session;
    private Transaction tx;
    private static LugarDao instancia = null; // Patrón Singleton

    protected LugarDao() {
    }

    public static LugarDao getInstance() {
        if (instancia == null)
            instancia = new LugarDao();
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

    // -----------------Actualizar-----------------
    public void actualizar(Lugar objeto) throws HibernateException {
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

    // -----------------TRAER LUGAR POR ID-----------------
    public Lugar traerLugar(int id) {
        Lugar objeto = null;
        try {
            iniciaOperacion();
            objeto = (Lugar) session.get(Lugar.class, id);

        } finally {
            session.close();
        }
        return objeto;
    }




}
