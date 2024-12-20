

package geogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoGameApp extends Application {


    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("GeoGame");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Ui.fxml"))));
        primaryStage.show();


    }

    public static void main(String[] args) {
        GeoGameApp.launch(args);
    }
}
