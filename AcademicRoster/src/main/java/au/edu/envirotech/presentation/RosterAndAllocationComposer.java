package au.edu.envirotech.presentation;

import org.zkoss.bind.BindComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.West;

import au.edu.envirotech.ejb.SessionBeanUtils;
import au.edu.envirotech.model.User;
import au.edu.envirotech.persistence.UserDao;

public class RosterAndAllocationComposer  extends BindComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		// executa os binds
		ConventionWires.wireFellows(getBinder().getView().getSpaceOwner(), this);

		getBinder().notifyChange(this, "*");
		
		
		
		((West)comp.getFellow("west", true)).setOpen(false);
		
	}
	
	public void runTest() {
		Clients.showNotification("All good!");
		
		User u = SessionBeanUtils.getDao(UserDao.class).findByCredentials("icaro.test@gmail.com", "7890-=");
		System.out.println(u.toString());
	}
}
