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
    
    public String getFirstName() {
    	try {
            return getRandomLineText(this.firstNames);
            
		} catch (IOException e) {
            e.printStackTrace();
		}
    	return null;
    }
    
    public String getLastName() {
    	try {
            return getRandomLineText(this.lastNames);
			
		} catch (IOException e) {
            e.printStackTrace();
		}
    	return null;
    }
    
    public String getNoun() {
    	try {
            return getRandomLineText(this.nounList);
			
		} catch (IOException e) {
            e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * @return String of random line in parameter file
     * 
     * Gets location of byte at the start of a random line then returns it
     * Biased towards longer lines - should modify to use rejection sampling
     */
    public String getRandomLineText(RandomAccessFile f) throws IOException{
    	// Get position of random byte/character
    	long randomLocation = (long) (Math.random() * f.length());
    	// Move to start of line
    	while (true) {
    		f.seek(randomLocation);
    		if (f.readUTF().equals("\n")) {
    			return f.readLine();
    		} else {
    			randomLocation--;
    		}
    	}
    }
    
    public void testFiles() throws IOException {
    	System.out.println("Testing Files:");
    	System.out.println("firstNames pointer location: " + this.firstNames.getFilePointer());
    	System.out.println("lastNames pointer location: " + this.lastNames.getFilePointer());
    	System.out.println("nounList pointer location: " + this.nounList.getFilePointer());
    }
}
