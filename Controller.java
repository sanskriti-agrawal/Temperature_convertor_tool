package com.intershala.javaFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public Label labelfeild;

    @FXML
    public ChoiceBox<String> choicebox;


    @FXML
    public TextField textfeild;

    @FXML
    public Button buttonfeild;

    private static final String  C_TO_F_TEXT="Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT="Fahrenheit to Celsius";

    private boolean isC_to_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choicebox.getItems().add(C_TO_F_TEXT);
        choicebox.getItems().add(F_TO_C_TEXT);

        choicebox.setValue(C_TO_F_TEXT);

        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals(C_TO_F_TEXT)){
                isC_to_F=true;
            }
            else{
                isC_to_F=false;
            }
        });

        buttonfeild.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {

         String input=textfeild.getText();
         float enteredtemperature=0.0f;
         try {
             enteredtemperature = Float.parseFloat(input);
         }
         catch(Exception exception)
         {
             warnUser();
             return;
         }

         float newtemperature=0.0f;
         if(isC_to_F){
             newtemperature=(enteredtemperature*9/5)+32;
         }
         else{
             newtemperature =(enteredtemperature-32)*5/9;
         }
         display(newtemperature);
    }

    private void warnUser() {

        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setContentText("Please enter a valid Temperature");
        alert.show();


    }

    private void display(float newtemperature) {

        String unit=isC_to_F? " F" : " C";
        System.out.println("The new Temperature " + newtemperature + unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new Temperature: " + newtemperature + unit);
        alert.show();
    }
}




