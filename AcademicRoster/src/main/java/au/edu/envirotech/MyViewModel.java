package au.edu.envirotech;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import au.edu.envirotech.model.UnitOfCompetency;

public class MyViewModel {

	private int count;

	@Init
	public void init() {
		count = 100;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		
		++count;
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("AcademicRosterPU").createEntityManager();

		UnitOfCompetency unitOfCompetency = new UnitOfCompetency();
		unitOfCompetency.setCode("123");
		unitOfCompetency.setUnitSector("Sector");
		
		entityManager.getTransaction().begin();
		entityManager.persist(unitOfCompetency);
		entityManager.getTransaction().commit();
		
//		InitialContext.doLookup("TaskDao")
	}

	public int getCount() {
		return count;
	}
}
