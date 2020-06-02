package com.dermentli.task6;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button starButtonStart;

    @FXML
    private Button snowmanButtonStart;

    @FXML
    void initialize() {
        snowmanButtonStart.setOnAction(event -> {
            snowmanButtonStart.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/snowmanController.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("FX homework");
            stage.showAndWait();
        });
        starButtonStart.setOnAction(event -> {
            starButtonStart.getScene().getWindow().hide();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/starController.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("FX homework");
            stage.showAndWait();
        });

    }
}
