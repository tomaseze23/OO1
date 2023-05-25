package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;

import java.util.List;
public class DispositivoDao {
	private static Session session;
	@SuppressWarnings("unused")
	private Transaction tx;
	
	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	@SuppressWarnings("unchecked")
	public List<Dispositivo> traer(){
		List<Dispositivo> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Dispositivo";
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public Dispositivo traer(String nombre) {
		Dispositivo objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Dispositivo d where d.nombre='" + nombre + "'";
			objeto = (Dispositivo) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
		
}
