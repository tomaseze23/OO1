package dao;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Persona;
import datos.Vacuna;

public class DosisDao {
		
		private static Session session;
		private Transaction tx;
		private static DosisDao instancia = null;
		
		public static DosisDao getInstance () {
			if(instancia == null) {
				instancia = new DosisDao();
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
		
		public List<Dosis> traer(Vacuna vacuna) {
			List<Dosis> lista = null;
			try {
				iniciaOperacion();
				lista = session.createQuery("from Dosis d inner join fetch d.vacuna v where v.idVacuna="+vacuna.getIdVacuna()).list();
				for(Dosis d : lista) {
					Hibernate.initialize(d.getPersona());
					Hibernate.initialize(d.getVacuna());
				}
			} finally {
				session.close();
			}
			return lista;
		}
		
		public List<Dosis> traer(LocalTime horaDesde, LocalTime horaHasta) {
			List<Dosis> lista = null;
			try {
				iniciaOperacion();
				lista = session.createQuery("from Dosis d where d.hora >='"+horaDesde+"'and d.hora<='"+horaHasta+"'").list();
				for(Dosis d : lista) {
					Hibernate.initialize(d.getPersona());
					Hibernate.initialize(d.getVacuna());
				}
			} finally {
				session.close();
			}
			return lista;
		}

}
