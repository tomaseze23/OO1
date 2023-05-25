package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lugar;

public class LugarDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos", he);
	}
	
	public Lugar traer(int idLugar) {
		Lugar objeto = null;
		try {
			iniciaOperacion();
			String hql = "From Lugar l where l.idLugar=" + idLugar;
			objeto = (Lugar) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
}
