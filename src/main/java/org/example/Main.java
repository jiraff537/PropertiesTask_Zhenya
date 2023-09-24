package org.example;
import org.example.PropertyReader;

import java.io.IOException;
import java.util.Properties;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties config = PropertyReader.loadProperties("files/ii.properties");
        List<String> keys = PropertyReader.getPropertyKeys(config);
        for (int i = 0; i < Math.min(keys.size(), 6); i++) {
            String key = keys.get(i);
            String value = PropertyReader.getValueForKey(config, key);
            System.out.println(key + ": " + value);
        }
    }
}