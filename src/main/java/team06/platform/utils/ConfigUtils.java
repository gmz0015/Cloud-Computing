package team06.platform.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtils {

    public Map<String, String> getConfig() {
        Map<String, String> config = new HashMap<>();
        Properties prop = new Properties();
        try {
            InputStream InputStream = new BufferedInputStream(new FileInputStream(new File(ConfigUtils.class.getClassLoader().getResource("configTomcat.properties").toURI().getPath())));
            prop.load(InputStream);
            config.put("PORT", prop.getProperty("PORT"));
            config.put("USERNAME", prop.getProperty("USERNAME"));
            config.put("PASSWORD", prop.getProperty("PASSWORD"));
        } catch (Exception e) {
            System.out.printf("[%-23s][%-20s][%-20s] Catch Exception: %s\n", new Timestamp(new Date().getTime()), "ConfigUtils", "getConfig", e);
        }
        return config;
    }
}
