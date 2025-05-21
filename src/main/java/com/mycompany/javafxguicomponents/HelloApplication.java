package com.mycompany.javafxguicomponents;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));


        Label userName = new Label("Enter your name:");
        TextField userTextField = new TextField();
        VBox userBox = new VBox(userName, userTextField);
        grid.add(userBox, 0, 0);

        Label optionLabel = new Label("Radio button option:");

        RadioButton option1 = new RadioButton("Choice-1");
        RadioButton option2 = new RadioButton("Choice-2");

        VBox optionBox = new VBox(optionLabel, option1, option2);
        grid.add(optionBox, 0, 1);

        ToggleGroup optionGroup = new ToggleGroup();
        option1.setToggleGroup(optionGroup);
        option2.setToggleGroup(optionGroup);

        Label checkLabel = new Label("Checkbox option:");
        CheckBox checkBox1 = new CheckBox("Option A");
        CheckBox checkBox2 = new CheckBox("Option B");



        VBox checkBoxBox = new VBox(checkLabel, checkBox1, checkBox2);
        grid.add(checkBoxBox, 0, 2);


        Label comboBoxLabel = new Label("Combo box option:");

        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Option 1", "Option 2", "Option 3");
        combo.setValue("Option 1");

        VBox comboBox = new VBox(comboBoxLabel, combo);
        grid.add(comboBox, 0, 3);

        Label featureLabel = new Label("List option: ");
        ObservableList<String> features = FXCollections.observableArrayList("Feature 1", "Feature 2", "Feature 3");
        ListView<String> listView = new ListView<String>(features);
        listView.setMaxSize(300, 100);
        grid.add(listView, 0, 4);

        VBox featureBox = new VBox(featureLabel, listView);
        grid.add(featureBox, 0, 5);

        Label dateLabel = new Label("Date option: ");
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());

        VBox dateBox = new VBox(dateLabel, datePicker);
        grid.add(dateBox, 0, 6);



        Slider volume = new Slider();
        volume.setMin(0);
        volume.setMax(100);

        Label volumeLabel = new Label("Volume: " + volume.getValue());
        volume.valueProperty().addListener((observable, oldValue, newValue) -> {
           volumeLabel.setText("Volume: " +  newValue.intValue());
        });
        VBox volumeBox = new VBox(volume, volumeLabel);
        grid.add(volumeBox, 0, 7);

        Button checkButton = new Button("Check Values");
        HBox checkBox = new HBox(checkButton);
        checkBox.setAlignment(Pos.CENTER);
        grid.add(checkBox, 0, 8);

        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                TextArea textArea = new TextArea();

                String name = userTextField.getText();
                String selection = "Not selected";
                if (option1.isSelected()) {
                    selection = "Choice 1";
                }
                else if (option2.isSelected()) {
                    selection = "Choice 2";
                }
                boolean chBox1 = checkBox1.isSelected();
                boolean chBox2 = checkBox2.isSelected();

                String feature = combo.getValue();

                String date;
                if (datePicker.getValue() != null) {
                    date = datePicker.getValue().toString();
                } else {
                    date = "Not selected";
                }

                String msg = "Hi, " + name + "!\n"
                        + "Choice: " + selection + "\n"
                        + "Check: " + chBox1 + "\n"
                        + "Check: " + chBox2 + "\n"
                        + "Feature: " + feature + "\n"
                        + "Date: " + date + "\n";

                textArea.setText(msg);
                textArea.setMaxSize(300, 30);
                grid.add(textArea, 0, 10);

            }

        });



        ListView<String> output = new ListView<String>();
        output.setMaxSize(300, 30);
        grid.add(output, 0, 9);

        Button closeButton = new Button("Close");
        HBox closeBox = new HBox(closeButton);
        closeBox.setAlignment(Pos.CENTER);
        grid.add(closeBox, 0, 10);

        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        Scene scene = new Scene(grid, 500, 500);
        stage.setTitle("Java GUI Components");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



