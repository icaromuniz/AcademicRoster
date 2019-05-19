package au.edu.envirotech.persistence;

import javax.ejb.Stateless;

import au.edu.envirotech.architecture.AbstractDao;
import au.edu.envirotech.model.Task;

@Stateless
public class TaskDao extends AbstractDao {

	public Task save(Task task) {
		return getEntityManager().merge(task);
	}
}
