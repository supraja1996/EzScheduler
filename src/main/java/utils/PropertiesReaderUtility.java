package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReaderUtility {

	private Properties properties = new Properties();

	
	public PropertiesReaderUtility(String filePath) {
		try {
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assert !properties.isEmpty();
	}

	
	public String getProperty(final String key) {
		String property = properties.getProperty(key);
		return property != null ? property.trim() : property;
	}
}
