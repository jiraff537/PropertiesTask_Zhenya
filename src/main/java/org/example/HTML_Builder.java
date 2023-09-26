package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class HTML_Builder {
    public static void Build(Properties properties, String filePath){
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html>\n");
        htmlContent.append("<head><title>Резюме</title></head>\n");
        htmlContent.append("<body>\n");
        htmlContent.append("<h1>Мое резюме</h1>\n");

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value.contains("http")){
                htmlContent.append("<p>").append(key).append(": ").append("<a href=").append(value).append(">").append(value).append("</a>").append("</p>\n");
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
