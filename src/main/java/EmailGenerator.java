package main.java;

import java.io.IOException;
import java.util.Random;

public class EmailGenerator {

    private RandomEmailParts rP = new RandomEmailParts();
    private Random random = new Random();

    public void start(int howMany) throws IOException{
        while (howMany > 0) {
            switch (getCombo()) {
            case 1: System.out.println(rP.getFirstName() +rP.getLastName()+ rP.getEmail());
                    break;
            case 2: System.out.println(rP.getFirstName() + rP.getNoun() + rP.getEmail());
                    break;
            case 3: System.out.println(rP.getNoun() + rP.getFirstName() + rP.getEmail());
                    break;
            case 4: System.out.println(rP.getFirstName() + rP.getLastName()
                                     + random.nextInt(100) + rP.getEmail());
                    break;
            }
            howMany--;
        }
    }

    public int getCombo() {
        double d = random.nextDouble();
        if (d < 0.5) {
            return 1;
        } else if (d < 0.65) {
            return 2;
        } else if (d < 0.85) {
            return 3;
        } else {
            return 4;
        }
    }
}
