package lk.wsrp.sameera;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/MainView.fxml")).load()));
        primaryStage.setHeight(200);
        primaryStage.setResizable(false);
        primaryStage.setTitle("File/Directory Handling App");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
