package org.example;

import static j2html.TagCreator.*;

public class HTML_Builder {
    public static void main(String[] args) {
        System.out.print(body(
                h1("Hello, World!")
        ).render());
    }
}
