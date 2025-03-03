/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 340);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

*/


package com.example.assign5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Calculator extends Application {

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Label section
        HBox labelHBox = new HBox(20);
        labelHBox.setPadding(new Insets(15, 15, 15, 15));

        Label operand1Label = new Label("Operand 1");
        TextField operand1TextField = new TextField();
        operand1TextField.setPrefColumnCount(2);

        Label operatorLabel = new Label("Operator");
        TextField operatorTextField = new TextField();
        operatorTextField.setPrefColumnCount(1);

        Label operand2Label = new Label("Operand 2");
        TextField operand2TextField = new TextField();
        operand2TextField.setPrefColumnCount(2);


        Label Result = new Label("Result");
        TextField resultTextField = new TextField();
        resultTextField.setPrefColumnCount(3);

        labelHBox.getChildren().addAll(operand1Label, operand1TextField, operand2Label, operand2TextField, operatorLabel, operatorTextField, Result, resultTextField);
        root.setTop(labelHBox);
        labelHBox.setAlignment(Pos.CENTER);







/*
        labelHBox.getChildren().addAll(operand1Label, operand1TextField,
                operatorLabel, operatorTextField, operand2Label, operand2TextField);
        root.setTop(labelHBox);*/

        // Button section
        HBox buttonHBox = new HBox(20);
        buttonHBox.setPadding(new Insets(15, 15, 15, 15));

        buttonHBox.setAlignment(Pos.CENTER);   //

        buttonHBox.setMinHeight(75);

        Button solveButton = new Button("Solve");
        buttonHBox.getChildren().add(solveButton);
        root.setBottom(buttonHBox);

        // Result field section
        TextField resultField = new TextField();

       //??? labelHBox.getChildren().addAll( resultField, resultTextField);


        resultField.setPrefColumnCount(2);
        resultField.setEditable(false);
        root.setCenter(resultField);

        // Scene setup
        Scene scene = new Scene(root, 600, 150);
        primaryStage.setTitle("Rational Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Button action setup
        solveButton.setOnAction(e -> {
            try {
                // Operand parsing
                String[] operand1Str = operand1TextField.getText().split("/");
                int num1 = Integer.parseInt(operand1Str[0]);
                int denom1 = Integer.parseInt(operand1Str[1]);

                String[] operand2Str = operand2TextField.getText().split("/");
                int num2 = Integer.parseInt(operand2Str[0]);
                int denom2 = Integer.parseInt(operand2Str[1]);

                // Rational creation
                FastRational rational1 = new FastRational(num1, denom1);
                FastRational rational2 = new FastRational(num2, denom2);

                // Operator processing
                String operator = operatorTextField.getText();
                FastRational result = new FastRational();

                switch (operator) {
                    case "+":
                        result = rational1.add(rational2);
                        break;
                    case "-":
                        result = rational1.subtract(rational2);
                        break;
                    // Add more cases for other operators if needed

                }

                // Display result
                resultField.setText(result.toString());

            } catch (Exception ex) {
                // Handle exceptions (e.g., division by zero, invalid input)
                resultField.setText("Error");
            }
        });
    }
}