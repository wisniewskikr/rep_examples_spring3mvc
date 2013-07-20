package pl.kwi.services;

import java.util.Properties;


public class NameService {
	
	
	private static final String NAME_PROPERTY = "name";
	private Properties props;

	
	public NameService(){		
		props = System.getProperties();
	}

	
	public void save(String name){
		props.setProperty(NAME_PROPERTY, name);
	}
	
	public String load() {
		return props.getProperty(NAME_PROPERTY);
	}
	
	
}
