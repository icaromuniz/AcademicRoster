package au.edu.envirotech.persistence;

import javax.ejb.Stateless;

import au.edu.envirotech.architecture.AbstractDao;
import au.edu.envirotech.model.User;

@Stateless
public class UserDao extends AbstractDao<User> {

	public User findByCredentials(String email, String password) {
		return (User) entityManager.createQuery("from User where email = :email and password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}
}
