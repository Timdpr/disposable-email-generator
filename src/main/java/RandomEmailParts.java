package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomEmailParts {

    private RandomAccessFile firstNames;
    private RandomAccessFile lastNames;
    private RandomAccessFile emailList;
    private RandomAccessFile nounList;

    public RandomEmailParts() {
        try {
            this.firstNames = new RandomAccessFile("src/main/res/first_names.txt", "r");
            this.lastNames = new RandomAccessFile("src/main/res/last_names.txt", "r");
            this.emailList = new RandomAccessFile("src/main/res/email_list.txt", "r");
            this.nounList = new RandomAccessFile("src/main/res/noun_list.txt", "r");

        } catch (FileNotFoundException e) {
            System.out.println("Text file not found");
            e.printStackTrace();
        }
    }

    public String getFirstName() throws IOException {
        return getRandomLineText(this.firstNames);
    }

    public String getLastName() throws IOException {
        return getRandomLineText(this.lastNames);
    }

    public String getEmail() throws IOException {
        return getRandomLineText(this.emailList);
    }

    public String getNoun() throws IOException {
        return getRandomLineText(this.nounList);
    }

    /**
     * @return String of random line in parameter file
     * 
     * Line is chosen using rejection sampling:
     * Seeks backwards from random byte to find '\n' char; reads following line
     * Returns line with probability min line length (2) / line length
     * (2 is incorrect for email domains, but works well enough!)
     */
    private String getRandomLineText(RandomAccessFile f) throws IOException {
        long randomByteLocation = 1;
        while (randomByteLocation > 0) {
            randomByteLocation = getRandomByteLocation(f);

            f.seek(randomByteLocation); // Move pointer to location
            char c = (char) f.readByte(); // Get byte, cast to char

            if (c == '\n') { // Move to start of line
                String line = f.readLine();
                // Return line with probability of min line length / line length
                double probability = 2.0 / line.length();
                if (Math.random() < probability) {
                    return line;
                }
            } else {
                randomByteLocation--; // Else try again with previous char
            }
        }
        return "getRandomLineText failed";
    }

    /**
     * @return Location of random byte in parameter file, except 0
     */
    private long getRandomByteLocation(RandomAccessFile f) throws IOException {
        long randomByteLocation = (long) (Math.random() * f.length());
        if (randomByteLocation == 0) {
            randomByteLocation++;
        }
        return randomByteLocation;
    }
}
