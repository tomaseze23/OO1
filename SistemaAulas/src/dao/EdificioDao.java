package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Edificio;

public class EdificioDao {
	private static Session session;
	@SuppressWarnings("unused")
	private Transaction tx;
	
	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public Edificio traerEdificioConAulas(int idEdificio) {
		Edificio objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Edificio e inner join fetch e.aulas where e.idEdificio=" + idEdificio;
			objeto = (Edificio) session.createQuery(hql).uniqueResult();
			
		}finally {
			session.close();
		}
		return objeto;
	}
}
