package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;

public class VacunaDao {
	
	private static Session session;
	private Transaction tx;
	private static VacunaDao instancia = null;
	
	public static VacunaDao getInstance () {
		if(instancia == null) {
			instancia = new VacunaDao();
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
	
	public Vacuna traer(long codigo) {
		Vacuna objeto = null;
		try {
			iniciaOperacion();
			objeto = (Vacuna) session.createQuery("from Vacuna v where v.codigo="+codigo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}
