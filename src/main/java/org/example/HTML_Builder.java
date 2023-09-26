package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class HTML_Builder {
    public static void Build(Properties properties, String filePath){
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n<html>\n");
        htmlContent.append("<head>\n<title>Резюме</title>\n<meta charset=\"UTF-8\">\n</head>\n");
        htmlContent.append("<body>\n");
        htmlContent.append("<h1>Мое резюме</h1>\n");

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value.contains("http")){
                htmlContent.append("<p>").append(key).append(": ").append("<img src='").append(value).append("' width='100' >").append("</p>\n");
            }else{
                htmlContent.append("<p>").append(key).append(": ").append(value).append("</p>\n");
            }

        }

        htmlContent.append("</body>\n");
        htmlContent.append("</html>");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlContent.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
