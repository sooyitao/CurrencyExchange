package com.example.currencyexchange;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Main extends Application{
    double[] exchangeRate = {0.7741, 0.6843, 109.9219, 0.5868, 1.1352, 1.0059, 0.6424, 5.3005};
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);

        //Input TextField
        TextField inputSGD = new TextField();

        //Output TextField
        TextField outputUSD = new TextField();
        TextField outputEUR = new TextField();
        TextField outputJPY = new TextField();
        TextField outputGBP = new TextField();
        TextField outputAUD = new TextField();
        TextField outputCAD = new TextField();
        TextField outputCHF = new TextField();
        TextField outputCNY = new TextField();

        //Labels for all currencies
        Text SGD = new Text("   Singapore Dollar (SGD) : ");
        SGD.setFont(Font.font("Open Sans", FontWeight.BOLD, FontPosture.REGULAR, 14));
        Text USD = new Text("   United States Dollar(USD) : ");
        USD.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text EUR = new Text("   Euro(EUR) : ");
        EUR.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text JPY = new Text("   Japanese Yen (JPY) : ");
        JPY.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text GBP = new Text("   Pound Sterling (GBP) : ");
        GBP.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text AUD = new Text("   Australian Dollar (AUD) : ");
        AUD.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text CAD = new Text("   Canadian Dollar (CAD) : ");
        CAD.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text CHF = new Text("   Swiss Franc (CHF) : ");
        CHF.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        Text CNY = new Text("   Chinese Yuan (CNY) : ");
        CNY.setFont(Font.font("Open Sans", FontWeight.NORMAL, FontPosture.REGULAR, 14));

        Button convertbtn = new Button("Convert!");
        convertbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Rate rates = new Rate();
                Convert convert1 = new Convert(Double.parseDouble(inputSGD.getText()));
                try {
                    convert1.setExchangeRate(rates.getRate());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Double[] convertor = convert1.convertor();
                outputUSD.setText(String.format("%.2f",convertor[0]));
                outputEUR.setText(String.format("%.2f",convertor[1]));
                outputJPY.setText(String.format("%.2f",convertor[2]));
                outputGBP.setText(String.format("%.2f",convertor[3]));
                outputAUD.setText(String.format("%.2f",convertor[4]));
                outputCAD.setText(String.format("%.2f",convertor[5]));
                outputCHF.setText(String.format("%.2f",convertor[6]));
                outputCNY.setText(String.format("%.2f",convertor[7]));
            }
        });

        Scene scene=new Scene(root,500,350);

        root.addRow(0, SGD, inputSGD, convertbtn);
        root.addRow(1,USD, outputUSD);
        root.addRow(2,EUR, outputEUR);
        root.addRow(3,JPY, outputJPY);
        root.addRow(4,GBP, outputGBP);
        root.addRow(5,AUD, outputAUD);
        root.addRow(6,CAD, outputCAD);
        root.addRow(7,CHF, outputCHF);
        root.addRow(8,CNY, outputCNY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}