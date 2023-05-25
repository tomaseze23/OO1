package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Persona;
import datos.Vacuna;

public class PersonaDao {
	
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null;
	
	public static PersonaDao getInstance () {
		if(instancia == null) {
			instancia = new PersonaDao();
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
	
	public List<Persona> traer() {
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

