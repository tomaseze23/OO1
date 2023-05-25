package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;

public class PermisoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos", he);
	}
	
	public Permiso traerPermiso(int idPermiso) {
		Permiso objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Permiso p where p.idPermiso=" + idPermiso;
			objeto = (Permiso) session.createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return objeto;
	}
	
	
}
