package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Manual;
import datos.Telepeaje;

public class PeajeDao {
	
	private static Session session;
	private Transaction tx;
	private static PeajeDao instancia = null;
	
	protected PeajeDao() {}
	
	public static PeajeDao getInstance(){
		if(instancia==null)
		instancia=new PeajeDao();
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
	
	public List<Manual> traerManual() throws HibernateException {
		List<Manual> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Manual").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Telepeaje> traerTelepeaje() throws HibernateException {
		List<Telepeaje> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Telepeaje").list();
			for(Telepeaje t : lista) {
				Hibernate.initialize(t.getRodado());
				Hibernate.initialize(t.getRodado().getAbonado());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Telepeaje> traerTelepeaje(Abonado abonado) throws HibernateException {
		List<Telepeaje> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Telepeaje t inner join fetch t.rodado r inner join fetch r.abonado a where a.dni='"+abonado.getDni()+"'").list();
			for(Telepeaje t : lista) {
				Hibernate.initialize(t.getRodado());
				Hibernate.initialize(t.getRodado().getAbonado());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	
}
