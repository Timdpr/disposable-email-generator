package main.java;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		RandomNamesAndNouns test = new RandomNamesAndNouns();
		try {
			test.testFiles();
			System.out.println(test.getFirstName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
