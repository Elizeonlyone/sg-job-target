package com.slotegrator.core;

import com.google.common.base.Strings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Config {

    private static final Log log = LogFactory.getLog(Config.class);
    private static final Map properties = getProperties();

    //API
    public static final String API_URL = getProperty("api.url");
    public static final String API_BASIC_AUTH = getProperty("api.basic_auth");

    //UI
    public static final String UI_URL = getProperty("ui.url");
    public static final String UI_USERNAME = getProperty("ui.username");
    public static final String UI_PASSWORD = getProperty("ui.password");

    private static Map getProperties() {
        String env = getEnvironment();

        log.info("Стартовали тесты на окружении: " + env + "\n");
        Properties localProperties = new Properties();
            try {
                FileReader reader = new FileReader(System.getProperty("user.dir")
                        + String.format("/src/test/resources/environment/%s.properties", env));
                localProperties.load(reader);

            } catch (IOException e) {
                log.error(e.getMessage());
            }
        return localProperties;
    }

    protected static String getProperty(String key) {
        return (String) properties.get(key);
    }

    private static String getEnvironment() {
        return Strings.isNullOrEmpty(System.getProperty("env")) ? "default" : System.getProperty("env").toLowerCase();
    }
}
