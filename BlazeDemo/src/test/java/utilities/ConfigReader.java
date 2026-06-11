package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}