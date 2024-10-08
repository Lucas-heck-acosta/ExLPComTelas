package exerciciotelas.classesobjetostelas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppObjetos extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppObjetos.class.getResource("TestaClasseMenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu Objetos!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}