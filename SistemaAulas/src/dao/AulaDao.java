package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;

public class AulaDao {
	private static Session session;
	@SuppressWarnings("unused")
	private Transaction tx;
	
	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public Aula traer(int idAula) {
		Aula objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Aula a inner join fetch a.edificio where a.idAula=" + idAula;
			objeto = (Aula) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
}
