package au.edu.envirotech.presentation;

import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import au.edu.envirotech.architecture.AbstractComposer;
import au.edu.envirotech.model.Campus;
import au.edu.envirotech.model.Room;

public class CampusComposer extends AbstractComposer<Campus> {

	public CampusComposer() {
		super(Campus.class);
	}

	private static final long serialVersionUID = 1L;

	@Wire
	private Listbox listbox;

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);

		// executa os binds
		ConventionWires.wireFellows(getBinder().getView().getSpaceOwner(), this);

		// notify any change of property
		getBinder().notifyChange(this, "*");
	}

	public void addRoom() {
		this.getModel().addRoom(new Room());
		getBinder().notifyChange(this, "*");
	}

	public void removeRoom() {
		Set<?> set = ((ListModelList<?>) listbox.getModel()).getSelection();
		this.getModel().getRoomList().removeAll(set);
		getBinder().notifyChange(this, "*");
	}
}
