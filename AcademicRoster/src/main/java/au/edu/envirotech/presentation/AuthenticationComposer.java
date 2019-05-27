package au.edu.envirotech.presentation;

import org.zkoss.bind.BindComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import au.edu.envirotech.ejb.SessionBeanUtils;
import au.edu.envirotech.model.User;
import au.edu.envirotech.persistence.UserDao;

public class AuthenticationComposer extends BindComposer<Component> {

	private static final long serialVersionUID = -2537702490116215106L;
	
	private Textbox textboxEmail;
	private Textbox textboxPassword;
	private Textbox textboxConfirmation;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);

		// execute bindings
		ConventionWires.wireFellows(getBinder().getView().getSpaceOwner(), this);
	}

	public void registerUser() {
		
		if ((textboxEmail.getValue() != null || !textboxEmail.getValue().isEmpty()) &&
				textboxPassword.getValue() != null || !textboxPassword.getValue().isEmpty() ) {
			
			User user;

			if (!textboxPassword.getValue().equals(textboxConfirmation.getValue())) {
				throw new WrongValueException(textboxConfirmation, "Not matching with the password. Please, try again.");
			}
			
			user = new User(textboxEmail.getValue(), textboxPassword.getValue());
			user = SessionBeanUtils.getDao(UserDao.class).save(user);
			
			if (user.getId() == 0) {
				Messagebox.show("Something went wrong during registration.", "Registration error", 1, Messagebox.ERROR);
			} else {
				
				EventListener<Event> eventListener = new EventListener<Event>() {
					public void onEvent(Event event) throws Exception {
						Executions.sendRedirect("/index.zul");
					}
				};
				
				Messagebox.show("User successfully registered!", "Registration success.", 1, Messagebox.INFORMATION, eventListener);
			}
		}
	}
	
	public void doLogin() {
		
		if ((textboxEmail.getValue() != null || !textboxEmail.getValue().isEmpty()) &&
				textboxPassword.getValue() != null || !textboxPassword.getValue().isEmpty() ) {
			
			User authorizedUser = null;
			
			authorizedUser = SessionBeanUtils.getDao(UserDao.class).findByCredentials(textboxEmail.getValue(), textboxPassword.getValue());
				
			if (authorizedUser != null) {
				
				Sessions.getCurrent().setAttribute("auth_usr", authorizedUser);
				Executions.sendRedirect("/");
			
			} else {
				Messagebox.show("Authentication information doesn't match with registry.", "Login failed", 1, Messagebox.EXCLAMATION);
			}
		}
	}
}
