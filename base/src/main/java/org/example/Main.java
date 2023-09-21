package org.example;

import static j2html.TagCreator.*;

public class Main {
    public static void main(String[] args) {
        System.out.print(body(
                h1("Hello, World!"),
                img().withSrc("/img/hello.png")
        ).render());
    }
}