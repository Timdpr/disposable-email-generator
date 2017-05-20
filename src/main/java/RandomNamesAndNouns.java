package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomNamesAndNouns {

    private RandomAccessFile firstNames;
    private RandomAccessFile lastNames;
    private RandomAccessFile nounList;

    public RandomNamesAndNouns() {
        try {
            this.firstNames = new RandomAccessFile("src/main/res/firstnames.txt", "r");
            this.lastNames = new RandomAccessFile("src/main/res/lastnames.txt", "r");
            this.nounList = new RandomAccessFile("src/main/res/nounlist.txt", "r");

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

    public String getNoun() throws IOException {
        return getRandomLineText(this.nounList);
    }

    /**
     * @return String of random line in parameter file
     * 
     * Seeks backwards from random byte to find '\n' char; reads following line
     * Biased towards longer lines - should modify to use rejection sampling
     */
    public String getRandomLineText(RandomAccessFile f) throws IOException {
        long randomByteLocation = (long) (Math.random() * f.length()); 

        while (randomByteLocation >= 0) {
            f.seek(randomByteLocation);   // Move pointer to location
            char c = (char) f.readByte(); // Get byte, cast to char

            if (c == '\n') {
                return f.readLine();      // If newline char, return following line
            } else {
                randomByteLocation --;    // Else try again with previous char
            }
        }
        return "getRandomLineText failed";
    }

    public void testFiles() throws IOException {
        System.out.println("Testing Files:");
        System.out.println("firstNames pointer location: " + this.firstNames.getFilePointer());
        System.out.println("lastNames pointer location: " + this.lastNames.getFilePointer());
        System.out.println("nounList pointer location: " + this.nounList.getFilePointer());
    }
}
