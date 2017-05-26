package main.java;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController {

    @FXML
    private TextField numberField;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView imageView;

    public void start() {
        try {
            this.textArea.setText("");
            EmailGenerator emailGenerator = new EmailGenerator();

            String input = this.numberField.getText();
            if (input.equals("cat")) {
                Image image = new Image("/main/res/secret_image.jpg");
                this.imageView.setImage(image);
            }

            int numberToGenerate = Integer.parseInt(input);
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
