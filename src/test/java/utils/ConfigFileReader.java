package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final String propertyFilePath = "config/Configuration.properties";
    private final Properties properties;

    public ConfigFileReader() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUserName() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String pwd = properties.getProperty("pwd");
        if (pwd != null) return pwd;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public String getAPIBaseUrl() {
        String apibaseurl = properties.getProperty("apibaseurl");
        if (apibaseurl != null) return apibaseurl;
        else throw new RuntimeException("apibaseurl not specified in the Configuration.properties file.");
    }

    public String getAppId() {
        String appid = properties.getProperty("appid");
        if (appid != null) return appid;
        else throw new RuntimeException("appid not specified in the Configuration.properties file.");
    }
}





