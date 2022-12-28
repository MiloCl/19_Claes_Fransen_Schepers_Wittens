package view.panels;

import controller.AdminOverviewViewController;
import controller.SetupPaneController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
    Button saveButton = new Button("save");
    ChoiceBox<String> itemFirst;

    public SetupPane(SetupPaneController setupPaneController) {

        //action to save button
        saveButton.setOnAction(event -> {
            System.out.println("save File Format");
            setupPaneController.saveFileFormat(fileFormat.getSelectionModel().getSelectedItem());
        });
        fileFormat.setValue(setupPaneController.getFileFormat());

        //intro text
        BorderPane introw = new BorderPane();
        introw.setCenter(intro);
        introw.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        intro.setFont(Font.font("Verdana", 15));
        introw.setPadding(new Insets(10, 10, 10, 10));

        //select how you want to read files
        BorderPane fileReading = new BorderPane();
        fileReading.setLeft(select);
        fileReading.setRight(fileFormat);
        fileReading.setPadding(new Insets(10, 40, 50, 20));
        select.setFont(Font.font("Verdana", 20));



        //add all to root
        this.getChildren().addAll(introw, fileReading, saveButton);
    }
}