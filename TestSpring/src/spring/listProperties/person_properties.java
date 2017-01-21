package spring.listProperties;

import java.util.Properties;

public class person_properties {
	private Properties properties;
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public person_properties() {
		super();
	}
	@Override
	public String toString() {
		return "person_properties [properties=" + properties + "]";
	}
	
	

}
