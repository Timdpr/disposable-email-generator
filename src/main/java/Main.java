package main.java;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        EmailGenerator emailGenerator = new EmailGenerator();
        try {
            emailGenerator.start(5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
