package dao;

import java.time.LocalDate;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
	
	private static Session session;
	private Transaction tx;
	private static EspacioDao instancia = null;
	
	public static EspacioDao getInstance() {
		if(instancia == null) {
			instancia = new EspacioDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion()throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acesso a datos", he);
	}
	
	public int agregar(Espacio objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}

		return id;
	} 
	
	public Espacio traer2(LocalDate fecha,char turno, Aula aula) {
		Espacio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Espacio) session.createQuery("from Espacio e inner join fetch e.aula a where a.idAula="+aula.getIdAula()+" and e.fecha='"+fecha+"' and e.turno='"+turno+"'").uniqueResult();
					//"from Espacio e inner join fetch e.aula a where e.fecha='"+fecha+"'and e.turno='" +turno+ "'and a.idAula="+aula.getIdAula();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Espacio traer(int idEspacio) {
		Espacio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Espacio) session.createQuery("from Espacio e where e.idEspacio="+idEspacio).uniqueResult();
			Hibernate.initialize(objeto.getAula());
			Hibernate.initialize(objeto.getAula().getEdificio());
		} finally {
			session.close();
		}
		return objeto;
	}

}
