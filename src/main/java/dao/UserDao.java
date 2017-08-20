package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.User;
import util.HibernateUtil;

public class UserDao {

	private static UserDao instance;

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (null == instance) {
			instance = new UserDao();
		}
		return instance;
	}

	// metodo ritorno lista utenti
	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> aList = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from User");
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

	public User getUserById(int iduser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from User where idusers = :iduser");
			query.setParameter("iduser", iduser);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return user;
	}
	
	
	public User getUserByUsername(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from User where username = :username");
			query.setParameter("username", username);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return user;
	}

	// metodo aggiunta utente
	public void addUser(User an) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(an);
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
	public void updateUser(User an) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(an);
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
	public void deleteUser(User an) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.delete(an);
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
