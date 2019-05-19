package au.edu.envirotech.persistence;

import javax.ejb.Stateless;

import au.edu.envirotech.architecture.AbstractDao;
import au.edu.envirotech.model.UnitOfCompetency;

@Stateless
public class UnitOfCompetencyDao extends AbstractDao {

	public UnitOfCompetency save(UnitOfCompetency unitOfCompetency) {
		return getEntityManager().merge(unitOfCompetency);
	}
}
