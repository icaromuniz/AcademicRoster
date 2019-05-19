package au.edu.envirotech.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TaskDao {

	@PersistenceContext
	public EntityManager em;

}
