package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Almacen;
import datos.Lote;
import datos.NotaPedido;
import datos.Pedido;
import datos.Producto;

public class StockDao {
	
	public static Session session;
	public Transaction tx;
	public static StockDao instancia = null;
	
	public static StockDao getInstance() {
		if(instancia == null) {
			instancia = new StockDao();
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

	public Almacen traer(Producto p) {
		Almacen objeto = null;
		try {
			iniciaOperacion();
			objeto = (Almacen) session.createQuery("from Almacen a inner join fetch a.producto p where p.idProducto="+p.getIdProducto()).uniqueResult();
			Hibernate.initialize(objeto.getProducto());
			Hibernate.initialize(objeto.getLotes());
			for(Lote l : objeto.getLotes()) {
				Hibernate.initialize(l);
			}
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Pedido traerPedido(Producto p) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.createQuery("from Pedido p inner join fetch p.producto pr where pr.idProducto="+p.getIdProducto()).uniqueResult();
			Hibernate.initialize(objeto.getProducto());
			Hibernate.initialize(objeto.getNotasPedidos());
			for(NotaPedido np : objeto.getNotasPedidos()) {
				Hibernate.initialize(np.getCliente());
			}
		} finally {
			session.close();
		}
		return objeto;
	}
	
}
