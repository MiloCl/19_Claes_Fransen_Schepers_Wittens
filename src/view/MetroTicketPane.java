package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class MetroTicketPane extends VBox {

    private static ChoiceBox<Integer> metroCardIdsChoiceBox = new ChoiceBox<>();
    Button newMetroCard = new Button("New MetroCard");
    Label enterNumberOfRides = new Label("Enter number of rides:");
    TextField numberOfRides = new TextField();

    CheckBox age64Plus = new CheckBox("64+?");
    CheckBox student = new CheckBox("Student?");
    Button addRides = new Button("Add rides");
    Button confirm = new Button("Confirm request");
    Label priceCalculation = new Label("");
    Label priceDescription = new Label("");

    public MetroTicketPane(MetroTicketViewController metroTicketViewController) throws IOException {
        this.getChildren().addAll(newMetroCard, metroCardIdsChoiceBox, enterNumberOfRides, numberOfRides, age64Plus, student,addRides);

        newMetroCard.setOnAction(e -> metroTicketViewController.newMetroCard());

        addRides.setOnAction(e ->
        {
            try {
                priceCalculation.setText("Total price: " + metroTicketViewController.addRides(age64Plus.isSelected(), student.isSelected(), Integer.parseInt(numberOfRides.getText())));
                priceDescription.setText(metroTicketViewController.addDescription(age64Plus.isSelected(), student.isSelected()));
                this.getChildren().addAll(confirm, priceCalculation, priceDescription);
                confirm.setOnAction(event -> metroTicketViewController.confirm(metroCardIdsChoiceBox.getValue(), Integer.parseInt(numberOfRides.getText())));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
        metroCardIdsChoiceBox.setItems(FXCollections.observableArrayList(ids));
    }

    public static int getMetroCardId() {
        return metroCardIdsChoiceBox.getValue();
    }
}

