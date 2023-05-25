package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Edificio;

public class EdificioDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	// CU 1
	public Edificio traerEdificioConAulas(int idEdificio) {
		Edificio objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Edificio e inner join fetch e.aulas where e.idEdificio =" + idEdificio;
			objeto = (Edificio) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


}
