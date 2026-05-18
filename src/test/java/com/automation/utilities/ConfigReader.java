package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	protected Properties properties;
	
	public ConfigReader(String env) {
		properties=new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/GlobalConfiguration/config"+env+".properties");
			properties.load(fis);
		}
		catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String getBrowserName() {
		return properties.getProperty("browser");
	}
	
	public String getURL() {
		return properties.getProperty("URL");
	}

}
