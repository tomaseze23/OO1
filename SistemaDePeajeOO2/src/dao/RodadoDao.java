package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rodado;

public class RodadoDao {
	
	private static Session session;
	private Transaction tx;
	private static RodadoDao instancia = null;
	
	protected RodadoDao() {}
	
	public static RodadoDao getInstance() {
		if(instancia == null) {
			instancia = new RodadoDao();
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
	
	public Rodado traerRodado(String dominio) {
		Rodado objeto = null;
		try {
			iniciaOperacion();
			objeto=(Rodado) session.createQuery("from Rodado r where r.dominio='"+dominio+"'").uniqueResult();
			Hibernate.initialize(objeto.getAbonado());
		}finally {
			session.close();
		}
		
		return objeto;
	}

}
