package com.dermentli.task6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class StarController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField xCoordinate;

    @FXML
    private TextField yCoordinate;

    @FXML
    private TextField radius;

    @FXML
    private Button buildStar;

    @FXML
    private Button back;

    @FXML
    void initialize() {
        buildStar.setOnAction(event -> {
            //getting initial coordinates
            double x = Double.parseDouble(xCoordinate.getText());
            double y = Double.parseDouble(yCoordinate.getText());
            double r = Double.parseDouble(radius.getText());
            //building star
            root.getChildren().add(new Line(x, y-r, x+(0.225*r), y-(0.325*r)));
            root.getChildren().add(new Line(x+(0.225*r), y-(0.325*r), x+r, y-(0.325*r)));
            root.getChildren().add(new Line(x+r, y-(0.325*r), x+(0.375*r), y+(0.125*r)));
            root.getChildren().add(new Line(x+(0.375*r), y+(0.125*r), x+(0.625*r), y+(0.85*r)));
            root.getChildren().add(new Line(x+(0.625*r), y+(0.85*r), x, y+(0.4*r)));
            root.getChildren().add(new Line(x, y+(0.4*r), x-(0.625*r), y+(0.85*r)));
            root.getChildren().add(new Line(x-(0.625*r), y+(0.85*r), x-(0.375*r), y+(0.125*r)));
            root.getChildren().add(new Line(x-(0.375*r), y+(0.125*r), x-r, y-(0.325*r)));
            root.getChildren().add(new Line(x-r, y-(0.325*r), x-(0.225*r), y-(0.325*r)));
            root.getChildren().add(new Line(x-(0.225*r), y-(0.325*r), x, y-r));
        });

        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            try {
                root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("FX homework");
            stage.show();
        });

    }
}
