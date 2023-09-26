package org.example;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties config = PropertyReader.loadProperties("files/ii.properties");
        HTML_Builder.Build(config, "resume.html");
    }
}