package com.dermentli.task6;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SnowmanController {

    @FXML
    private AnchorPane root;

    @FXML
    private Button createCircleButton;

    @FXML
    private TextField numberOfCirles;

    @FXML
    private TextField minimalRadius;

    @FXML
    private TextField maximalRadius;

    @FXML
    private Button paintInRed;

    @FXML
    private Button addGradient;

    @FXML
    private Button back;

    @FXML
    void initialize() {
        ArrayList<Circle> snowmanBody = new ArrayList<>();

        createCircleButton.setOnAction(event -> {
            int numOfCircles = Integer.parseInt(numberOfCirles.getText());
            int minRadius = Integer.parseInt(minimalRadius.getText());
            int maxRadius = Integer.parseInt(maximalRadius.getText());
            double radius = 0.0;
            double prevRadius = 0.0;
            double centerY = 100.0;
            for (int i = 0; i < numOfCircles; i++) {
                radius = minRadius + (Math.random() * ((maxRadius - minRadius) + 1));
                centerY += (radius + prevRadius);
                Circle circle = new Circle(125.0, centerY, radius, null);
                circle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                prevRadius = radius;
                root.getChildren().add(circle);
                snowmanBody.add(circle);
            }
            double radiusLeftEye = snowmanBody.get(0).getRadius()/5;
            double radiusRightEye = snowmanBody.get(0).getRadius()/5;
            double radiusNose = snowmanBody.get(0).getRadius()/7;
            Circle leftEye = new Circle(110.0, 130.0, radiusLeftEye, Color.BLUEVIOLET);
            leftEye.setStroke(Color.BLACK);
            root.getChildren().add(leftEye);
            Circle rightEye = new Circle(150.0, 130.0, radiusRightEye, Color.BLUEVIOLET);
            rightEye.setStroke(Color.BLACK);
            root.getChildren().add(rightEye);
            Circle nose = new Circle(130.0, 150.0, radiusNose, Color.YELLOWGREEN);
            nose.setStroke(Color.BLACK);
            root.getChildren().add(nose);
        });

        // Не подходит красит глаза снеговику
//        paintInRed.setOnAction(event -> {
//            ObservableList<Node> children = root.getChildren();
//            for (Node child : children)
//                if (child instanceof Circle) {
//                    Circle nodeCircle = (Circle) child;
//                    nodeCircle.setFill(Color.RED);
//                }
//        });

        paintInRed.setOnAction(event -> {
            for (Circle a : snowmanBody) {
                a.setFill(Color.RED);
            }
        });

        addGradient.setOnAction(event -> {
            int gradientCount = snowmanBody.size();
            for (int i = 0; i < gradientCount; i++) {
                snowmanBody.get(i).setFill(Color.rgb((255-255/(gradientCount-1)*(i)), (255-255/(gradientCount-1)*(i)), (255-255/(gradientCount-1)*(i))));
            }
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
