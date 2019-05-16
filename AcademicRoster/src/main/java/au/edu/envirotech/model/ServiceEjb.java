package au.edu.envirotech.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceEjb {
	
	public static void load() {
		try {
			ServiceEjb exampleBean = (ServiceEjb)InitialContext.doLookup("java:module/ExampleBean");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ServiceEjb() {
	}
	

}
