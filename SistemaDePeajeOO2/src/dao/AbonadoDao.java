package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;

public class AbonadoDao {
	
	public static Session session;
	public Transaction tx;
	public static AbonadoDao instancia = null;
	
	protected AbonadoDao() {}
	
	public static AbonadoDao getInstancia() {
		if(instancia == null) {
			instancia = new AbonadoDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Abonado traer(int dni) {
		Abonado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Abonado) session.createQuery("from Abonado a where a.dni="+dni).uniqueResult();
		} finally {
			session.close();	
		}
		return objeto;
	}

}
