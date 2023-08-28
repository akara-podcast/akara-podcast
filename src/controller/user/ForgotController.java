package controller.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ForgotController implements Initializable {

    @FXML
    private BorderPane forgotPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loginSwitchClicked(MouseEvent event) throws IOException {
        forgotPane.setTop(null);
        BorderPane login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/Login.fxml")));
        forgotPane.setCenter(login);
    }
}
