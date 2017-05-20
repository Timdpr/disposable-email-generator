package main.java;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        RandomNamesAndNouns test = new RandomNamesAndNouns();
        try {
            test.testFiles();
            System.out.println();
            System.out.println(test.getFirstName());
            System.out.println(test.getLastName());
            System.out.println(test.getNoun());
            System.out.println();
            test.testFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
