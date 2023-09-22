package org.example;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;

public class HTML_Builder {
    public static void main(String[] args) {
        System.out.print(body(
                h1("Hello, World!")
        ).render());
    }
}
