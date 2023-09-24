package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
    public static Properties loadProperties(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        }
    }

    public static List<String> getPropertyKeys(Properties properties) {
        Set<String> propertyNames = properties.stringPropertyNames();
        return new ArrayList<>(propertyNames);
    }

    public static String getValueAtIndex(Properties properties, int index) {
        Set<String> propertyNames = properties.stringPropertyNames();
        String[] propertyKeys = propertyNames.toArray(new String[0]);
        if (index >= 0 && index < propertyKeys.length) {
            return properties.getProperty(propertyKeys[index]);
        } else {
            return null; // Обработка неверного индекса
        }
    }

    public static String getValueForKey(Properties properties, String key) {
        return properties.getProperty(key);
    }

    public static String[] getAllValues(Properties properties) {
        Set<String> propertyNames = properties.stringPropertyNames();
        String[] propertyKeys = propertyNames.toArray(new String[0]);
        String[] values = new String[propertyKeys.length];
        for (int i = 0; i < propertyKeys.length; i++) {
            values[i] = properties.getProperty(propertyKeys[i]);
        }
        return values;
    }

    public static String[] getAllKeys(Properties properties) {
        Set<String> propertyNames = properties.stringPropertyNames();
        return propertyNames.toArray(new String[0]);
    }
}
