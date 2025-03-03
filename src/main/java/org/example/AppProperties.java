package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private Properties properties;

    public AppProperties(String host, String port) {
//        File fileProperties = new File("application.properties");
        properties = new Properties();
        properties.put("host", host);
        properties.put("port", port);
    }

    public String getHost() {
        if (properties != null) {
            return properties.getProperty("host");
        } else {
            throw new NullPointerException();
        }
    }

    public int getPort() {
        if (properties != null) {
            return Integer.parseInt(properties.getProperty("port"));
        } else {
            throw new NullPointerException();
        }
    }
}
