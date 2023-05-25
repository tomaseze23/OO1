package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;

public class AulaDao {
	
	private static Session session;
	private Transaction tx;
	private static AulaDao instancia = null;
	
	public static AulaDao getInstance () {
		if(instancia == null) {
			instancia = new AulaDao();
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
	
	public Aula traer(int idAula) {
		Aula objeto = null;
		try {
			iniciaOperacion();
			objeto = (Aula) session.createQuery("from Aula a where a.idAula="+idAula).uniqueResult();
			Hibernate.initialize(objeto.getEdificio());
		} finally {
			session.close();
		}
		
		return objeto;
	}

}
