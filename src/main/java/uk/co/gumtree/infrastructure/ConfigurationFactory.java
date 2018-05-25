package uk.co.gumtree.infrastructure;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationFactory {
    final private Properties localProperties = new Properties();

    public ConfigurationFactory() throws IOException {
        localProperties.load(ConfigurationFactory.class.getClassLoader().getResourceAsStream("config.properties"));
    }

    public String getValue(String keyName) {
        return localProperties.getProperty(keyName);
    }
}