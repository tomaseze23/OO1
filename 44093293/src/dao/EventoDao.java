package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;
import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos");
	}

	public int agregar(Evento evento) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(evento).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) throws HibernateException{
		Evento objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e inner join fetch e.dispositivo d where "
					+ "d.idDispositivo=" + dispositivo.getIdDispositivo() + " and e.fechaHora='" + fechaHora + "'";
			objeto = (Evento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> traer() {
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			String hql = "From Evento";
			lista = session.createQuery(hql).list();
			for(Evento e: lista) {
				Hibernate.initialize(e.getDispositivo());
			}
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta) {
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e where e.fechaHora >='" + fechaHoraDesde + "' and e.fechaHora<='" + fechaHoraHasta + "'";
			lista = session.createQuery(hql).list();
			for (Evento e : lista) {
				Hibernate.initialize(e.getDispositivo());
			}
		} finally {
			session.close();
		}

		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e inner join fetch e.dispositivo d where e.fechaHora >='" + 
					fechaHoraDesde + "' and e.fechaHora<='" + fechaHoraHasta + "'" + "and d.nombre='" + 
					dispositivo.getNombre() +"'";
			lista = session.createQuery(hql).list();
			for (Evento e : lista) {
				Hibernate.initialize(e.getDispositivo());
			}
		} finally {
			session.close();
		}

		return lista;
	}
	
	
}
