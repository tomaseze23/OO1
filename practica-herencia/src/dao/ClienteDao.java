package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en el acceso a la capa de datos", he);
	}

	public Cliente traer(int idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente=" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente").list();
		} finally {
			session.close();
		}
		return lista;
	}
}
