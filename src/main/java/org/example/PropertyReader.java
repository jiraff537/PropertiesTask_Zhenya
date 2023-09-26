package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyReader {
    public static Properties loadProperties(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        }
    }
}
