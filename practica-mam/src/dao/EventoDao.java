package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos", he);
	}
	
	public int agregar(Evento objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar (Evento objeto) throws HibernateException{
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Evento objeto) throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public Evento traer(long idEvento) throws HibernateException{
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.get(Evento.class, idEvento);
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> traer() throws HibernateException{
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e order by e.fecha asc";
			lista = session.createQuery(hql).list();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return lista;
	}
	
	public Evento traerEventoYClientes(long idEvento) throws HibernateException {
		Evento objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e where e.idEvento=" + idEvento;
			objeto = (Evento) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getClientes());
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return objeto;
	}
}