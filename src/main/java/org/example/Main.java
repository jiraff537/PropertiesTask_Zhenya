package org.example;
import org.example.Reader;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties config = Reader.newPropFile("files/ii.properties");
        for (int i = 0; i < 6; i++){
            System.out.println(Reader.getFromIndex(config, i));
        }

    }
}