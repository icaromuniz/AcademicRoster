package au.edu.envirotech.architecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T extends AbstractEntity> {

//	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	@PersistenceContext
	protected EntityManager entityManager;

	public T save(T entity) {
		return entityManager.merge(entity);
	}

	public void remove(T entity) {
		entityManager.remove(entity);
	}
}
