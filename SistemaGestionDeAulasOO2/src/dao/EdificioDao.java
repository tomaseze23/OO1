package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Edificio;

public class EdificioDao {
	
	private static Session session;
	private Transaction tx;
	private static EdificioDao instancia = null;
	
	public static EdificioDao getInstance() {
		if(instancia == null) {
			instancia = new EdificioDao();
		}
		return instancia;
	}

	protected void iniciaOperacion()throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaException(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acesso a datos", he);
	}
	
	public Edificio traer(int idEdificio) {
		Edificio objeto = null;
		try {
		iniciaOperacion();
		objeto = (Edificio) session.createQuery("from Edificio a where a.idEdificio ="+idEdificio).uniqueResult();
		Hibernate.initialize(objeto.getAulas());
		} finally {
		session.close();
		}
		return objeto;
	}
}
