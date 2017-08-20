package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Carrello;
import entity.CarrelloPK;
import entity.Item;
import entity.User;
import util.HibernateUtil;

public class CarrelloDao {

	private static CarrelloDao instance;

	private CarrelloDao() {
	}

	public static CarrelloDao getInstance() {
		if (null == instance) {
			instance = new CarrelloDao();
		}
		return instance;
	}
	
	public List<Carrello> getAllItemsSelected(int usersIdusers) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Carrello> aList = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("FROM Carrello C WHERE C.carrelloPK.usersIdusers = :usersIdusers");
			query.setParameter("usersIdusers", usersIdusers);
			aList = query.list();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return aList;
	}
	
	public Carrello getItemSelectedByID(int usersIdusers , int itemsIditems) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Carrello item = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("FROM Carrello C WHERE C.carrelloPK.usersIdusers = :usersIdusers "
					+ "AND C.carrelloPK.itemsIditems = :itemsIditems ");
			query.setParameter("usersIdusers", usersIdusers);
			query.setParameter("itemsIditems", itemsIditems);
			item = (Carrello) query.uniqueResult();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return item;
	}
	
	
	public void addSelectedItem(Carrello cr) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();			
			session.save(cr);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
	
	public void deleteItemSelected(Carrello cr) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.delete(cr);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
	
}
