package com.ui.automation.environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfigurator {

    //    protected static final Logger LOGGER = LogManager.getLogger(EnvironmentConfigurator.class);
    private static volatile EnvironmentConfigurator environmentConfigurator;
    private static Properties properties = new Properties();

    private EnvironmentConfigurator() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream i18nStream = loader.getResourceAsStream("env.properties");
        try {
            properties.load(i18nStream);
            i18nStream.close();
        } catch (IOException e) {
//            LOGGER.error("", e);
        }
    }

    public static EnvironmentConfigurator getInstance() {
        EnvironmentConfigurator sysProps = environmentConfigurator;
        if (sysProps == null) {
            synchronized (EnvironmentConfigurator.class) {
                sysProps = environmentConfigurator;
                if (sysProps == null) {
                    try {
                        environmentConfigurator = sysProps = new EnvironmentConfigurator();
                    } catch (IOException e) {
//                        LOGGER.error("", e);
                    }
                }
            }
        }
        return sysProps;
    }

    //Get value of System variable (which we are providing from pom.xml or command line).
    // If not specified - then get default value from properties file

    //get specific environment properties.

    public Boolean isGridUsed() {
        return Boolean.parseBoolean(System.getProperty("grid.isUsed", properties.getProperty("grid.isUsed")));
    }

    public String getSeleniumHub() {
        return System.getProperty("grid.seleniumHub", properties.getProperty("grid.seleniumHub"));
    }

    public String getTestClient() {
        return System.getProperty("browserClient", properties.getProperty("browserClient"));
    }

    public String getAppUrl() {
        return System.getProperty("url", properties.getProperty("url"));
    }

    public String getLogin() {
        return System.getProperty("users.login", properties.getProperty("users.login"));
    }

    public String getPassword() {
        return System.getProperty("users.password",properties.getProperty("users.password"));
    }

}
