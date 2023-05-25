package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Aula;

public class AulaDao {
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

	public Aula traer(int idAula) {
		Aula objeto = null;
		try {
			iniciaOperacion();
			objeto = (Aula) session.createQuery("from Aula a where a.idAula =" + idAula).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


}
