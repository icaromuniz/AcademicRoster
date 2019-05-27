package au.edu.envirotech.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SessionBeanUtils {

	@SuppressWarnings("unchecked")
	public static <T extends Object> T getDao(Class<T> classeDao){
		
		try {
			return (T) InitialContext.doLookup("java:module/" + classeDao.getSimpleName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
