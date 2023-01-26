import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Introduction implements Initializable {

    private static Stage stage;

    @FXML
    private ImageView CoupGame;

    public void startNewGame(ActionEvent event) throws IOException {

        // change scene to game table
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI/GameTable.fxml")));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(pane));
        window.show();
        window.centerOnScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // set coup game image
        CoupGame.setImage(new Image("Images\\CoupGame.jpg"));
    }
}
