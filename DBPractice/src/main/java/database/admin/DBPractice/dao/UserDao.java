package database.admin.DBPractice.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import database.admin.DBPractice.model.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	public User findByUsername(String username) {
		try {
		return em.createQuery("FROM User WHERE username = :username", User.class).setParameter("username", username).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
	public void update(User user) {
		em.merge(user);
	}
}
