package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Item;

import util.HibernateUtil;

public class ItemDao {

	private static ItemDao instance;

	private ItemDao() {
	}

	public static ItemDao getInstance() {
		if (null == instance) {
			instance = new ItemDao();
		}
		return instance;
	}

	// metodo ritorno lista utenti
	public List<Item> getAllItems() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Item> aList = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Item");
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

	public Item getItemById(int iditems) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Item item = null;
		try {
			session.getTransaction().begin();
			Query query = session
					.createQuery("from Item where iditems = :iditems");
			query.setParameter("iditems", iditems);
			item = (Item) query.uniqueResult();
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

	// metodo aggiunta utente
	public void addItem(Item it) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(it);
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

	// metodo modifica utente
	public void updateItem(Item it) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(it);
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

	// metodo eliminazione utente
	public void deleteItem(Item it) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.delete(it);
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
