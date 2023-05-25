package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;

public class ProductoDao {
	
	private static Session session;
	private Transaction tx;
	private static ProductoDao instancia = null;
	
	public static ProductoDao getInstance () {
		if(instancia == null) {
			instancia = new ProductoDao();
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
	
	public Producto traer(String codigo) {
		Producto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Producto) session.createQuery("from Producto p where p.codigo="+codigo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}
