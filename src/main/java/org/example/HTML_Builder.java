package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class HTML_Builder {
    public static void Build(Properties properties, String filePath) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n<html>\n");
        htmlContent.append("<head>\n<title>Резюме</title>\n<meta charset=\"UTF-8\">\n");
        htmlContent.append("<link rel=\"stylesheet\" href=\"path/to/bootstrap.min.css\">\n");
        htmlContent.append("<style>");
        htmlContent.append("html, body {");
        htmlContent.append("  height: 100%;");
        htmlContent.append("  margin: 0;");
        htmlContent.append("  padding: 0;");
        htmlContent.append("}");

        htmlContent.append("body {");
        htmlContent.append("  background: linear-gradient(to bottom, #4e6fe2, #864cbf);"); // Сине-фиолетовый градиентный фон
        htmlContent.append("}");

        htmlContent.append(".custom-box { border: 1px solid #ccc; border-radius: 10px; padding: 20px; margin: 0 auto; max-width: 600px; background-color: #fff; }"); // Фон контейнера белый
        htmlContent.append("</style>\n");
        htmlContent.append("</head>\n");
        htmlContent.append("<body>\n<div class=\"container\">\n");
        htmlContent.append("<div class=\"custom-box\">\n"); // Добавили класс custom-box для рамочки

        htmlContent.append("<h1 class=\"text-center\">Мое резюме</h1>\n"); // Выравнивание по центру

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            htmlContent.append("<div class=\"row\">\n");
            htmlContent.append("<div class=\"col-md-6\">\n");
            htmlContent.append("<strong>").append(key).append(":</strong>\n");
            htmlContent.append("</div>\n");
            htmlContent.append("<div class=\"col-md-6\">\n");

            if (value.contains("http")) {
                htmlContent.append("<a href='").append(value).append("'>");
                htmlContent.append("<img src='").append(value).append("' width='60' alt='ССЫЛКА'>");
                htmlContent.append("</a>\n");
            } else {
                htmlContent.append(value).append("\n");
            }

            htmlContent.append("</div>\n");
            htmlContent.append("</div>\n");
        }

        htmlContent.append("</div>\n"); // Закрыли div с классом custom-box
        htmlContent.append("</div>\n");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlContent.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

