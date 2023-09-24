package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Reader {
    public static Properties newPropFile(String path) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties;
    }
    public static String getFromIndex(Properties properties, int i){
        Set<String> propertyNames = properties.stringPropertyNames();
        String[] propertyKeys = propertyNames.toArray(new String[0]);
        return properties.getProperty(propertyKeys[i]);
    }
    public static String getFromKey(Properties properties, String k){
        return properties.getProperty(k);
    }
    public static String[] getAll(Properties properties){
        return new String[10];
    }
    public static String[] getKey(Properties properties, int i){
        Set<String> propertyNames = properties.stringPropertyNames();
        String[] propertyKeys = propertyNames.toArray(new String[0]);
        if (i == -1){
            return propertyKeys;
        }
        return new String[]{propertyKeys[i]};
    }
}
