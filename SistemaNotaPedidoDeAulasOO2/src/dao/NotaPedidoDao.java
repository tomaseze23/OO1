package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoDao {
	
	private static Session session;
	private Transaction tx;
	private static NotaPedidoDao instancia = null;
	
	protected NotaPedidoDao() {}
	
	public static NotaPedidoDao getInstance() {
		if(instancia == null) {
			instancia = new NotaPedidoDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
	}
	
	public NotaPedido traerMateria(int idNotaPedido) {
		NotaPedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (NotaPedido) session.createQuery("from NotaPedido np where np.idNotaPedido="+idNotaPedido).uniqueResult();
			Hibernate.initialize(objeto.getMateria());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public List<NotaPedido> traer(LocalDate fechaExamen) {
		List<NotaPedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Final f where f.fechaExamen='"+fechaExamen+"'").list();
			for(NotaPedido np : lista) {
				Hibernate.initialize(np.getMateria());
			}
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta) {
		List<NotaPedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Final f where f.fechaExamen>='"+desde+"'and f.fechaExamen<='"+hasta+"'").list();
			for(NotaPedido np : lista) {
				Hibernate.initialize(np.getMateria());
			}
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia) {
		List<NotaPedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Final f inner join fetch f.materia m where f.fechaExamen>='"+desde+"'and f.fechaExamen<='"+hasta+"'and m.idMateria='"+materia.getIdMateria()+"'").list();
			for(NotaPedido np : lista) {
				Hibernate.initialize(np.getMateria());
			}
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	public int agregar(Curso objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	} 

}
