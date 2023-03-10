package view.panels;

import controller.AdminOverviewViewController;
import controller.SetupPaneController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SetupPane extends VBox {
    AdminOverviewViewController adminOverviewViewController;
    Label intro = new Label("Change settings");
    Label select = new Label("Select here the type of file structure");
    ChoiceBox<String> fileFormat = new ChoiceBox<>(FXCollections.observableArrayList("Excel", "Text"));
    Label discounts = new Label("Select Discounts");
    CheckBox age64PlusDiscount = new CheckBox("Age 64+ discount");
    CheckBox christmasLeaveDiscount = new CheckBox("Christmas leave discount");
    CheckBox studentDiscount = new CheckBox("Student discount");
    CheckBox frequentTravellerDiscount = new CheckBox("Frequent traveller discount");
    Button saveButton = new Button("save");


    public SetupPane(SetupPaneController setupPaneController) {

        //action to save button
        saveButton.setOnAction(event -> {
            System.out.println("save File Format");
            setupPaneController.saveSettings(fileFormat.getSelectionModel().getSelectedItem(), age64PlusDiscount.isSelected(), christmasLeaveDiscount.isSelected(), studentDiscount.isSelected(), frequentTravellerDiscount.isSelected());
        });

        //Values uit proerties laten zien
        fileFormat.setValue(setupPaneController.getFileFormat());
        age64PlusDiscount.setSelected(setupPaneController.getAge64PlusDiscount());
        christmasLeaveDiscount.setSelected(setupPaneController.getChristmasLeaveDiscount());
        studentDiscount.setSelected(setupPaneController.getStudentDiscount());
        frequentTravellerDiscount.setSelected(setupPaneController.getFrequentTravellerDiscount());







        //add all to root
        this.getChildren().addAll(intro, select, fileFormat, discounts, age64PlusDiscount, christmasLeaveDiscount, studentDiscount, frequentTravellerDiscount, saveButton);
    }
}