package main.java;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField numberField;
    @FXML
    private TextArea textArea;

    public void start() {
        try {
            EmailGenerator emailGenerator = new EmailGenerator();
            int numberToGenerate = Integer.parseInt(this.numberField.getText());
            textArea.setText(emailGenerator.makeDisplayText(numberToGenerate));

        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("IOException - something went wrong with the Email Generator!");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textArea.setText("Have you entered a number?");
        }
    }
}
