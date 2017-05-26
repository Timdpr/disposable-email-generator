package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/java/GUI.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Disposable Email Generator");

            primaryStage.getIcons().addAll(
                    // JavaFX is bad at auto choosing icons, so, many are given:
                    new Image(getClass().getResourceAsStream("/main/res/icon16.png")), 
                    new Image(getClass().getResourceAsStream("/main/res/icon32.png")),
                    new Image(getClass().getResourceAsStream("/main/res/icon64.png")),
                    new Image(getClass().getResourceAsStream("/main/res/icon48.png")));

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();    
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
