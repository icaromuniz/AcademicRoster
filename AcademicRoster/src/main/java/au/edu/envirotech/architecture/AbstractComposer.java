package au.edu.envirotech.architecture;

import org.zkoss.bind.BindComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.metainfo.ComponentInfo;

@SuppressWarnings("serial")
public abstract class AbstractComposer<T extends AbstractEntity> extends BindComposer<Component> {

	private T model;

	public AbstractComposer(Class<T> modelClass) {
		try {
			this.model = modelClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent, ComponentInfo compInfo) throws Exception {

		if (!isUserAuthorized()) {
			Executions.sendRedirect("/login.zul");
			return null;
		}

		return super.doBeforeCompose(page, parent, compInfo);
	}

	private boolean isUserAuthorized() {

		if (Sessions.getCurrent().getAttribute("auth_usr") != null) {
			return true;
		}

		return false;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
