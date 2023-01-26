import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI/Introduction.fxml")));
        primaryStage.setTitle("COUP");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}