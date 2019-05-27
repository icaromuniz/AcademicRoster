package au.edu.envirotech;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import au.edu.envirotech.model.UnitOfCompetency;
import au.edu.envirotech.persistence.UnitOfCompetencyDao;

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
		
//		EntityManager entityManager = Persistence.createEntityManagerFactory("AcademicRosterPU").createEntityManager();
//
		UnitOfCompetency unitOfCompetency = new UnitOfCompetency();
		unitOfCompetency.setCode("123456");
		unitOfCompetency.setUnitSector("Sector");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(unitOfCompetency);
//		entityManager.getTransaction().commit();
		
		try {
			
			UnitOfCompetencyDao dao = InitialContext.doLookup("java:module/UnitOfCompetencyDao");
			UnitOfCompetency uoc = dao.save(unitOfCompetency );
			uoc.setCode(uoc.getCode() + count);
			dao.save(uoc);
			
//			UnitOfCompetency uocOne = dao.entityManager().find(UnitOfCompetency.class, 1);
//			uocOne.setCode(uocOne.getCode() + (count-100));
//			dao.save(uocOne);
			
//			TaskDao taskDao = (TaskDao)InitialContext.doLookup("java:module/TaskDao");
//			Task t = new Task();
//			t.setDate(new Date());
//			t.setDepartment("DPT");
//			t.setDescription("Desc");
//			t.setUser(new User());
//			t.getUser().setId(2);
//			t.setStartTime(new Time(t.getDate().getTime()));
//			t.setFinishTime(t.getStartTime());
//			t.setUnderPlan(true);
			
//			Task task = taskDao.save(t);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCount() {
		return count;
	}
}
