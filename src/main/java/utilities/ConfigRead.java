package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

	static Properties prop;

	static {
		try {
			FileReader file = new FileReader("./src/test/resources/properties/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String properties(String key) {
		return prop.getProperty(key);
	}

}
