package main.java;

import java.io.IOException;
import java.util.Random;

public class EmailGenerator {

    private RandomEmailParts rP = new RandomEmailParts();
    private Random random = new Random();

    public String makeDisplayText(int n) throws IOException {
        String emailText = "";
        for (int i = n; i > 0; i--) {
            emailText += start();
            if (i != 1) {
                emailText += "\n";
            }
        }
        return emailText;
    }

    public String start() throws IOException {
        switch (getCombo()) {
        case 1: return rP.getFirstName() +rP.getLastName()+ rP.getEmail();
        case 2: return rP.getFirstName() + rP.getNoun() + rP.getEmail();
        case 3: return rP.getNoun() + rP.getFirstName() + rP.getEmail();
        case 4: return rP.getFirstName() + rP.getLastName() +
                       random.nextInt(100) + rP.getEmail();
        }
        return null;
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
