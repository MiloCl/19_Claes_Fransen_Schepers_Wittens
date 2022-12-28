package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MetroTicketPane extends VBox {

    private static ChoiceBox<Integer> metroCardIdsChoiceBox = new ChoiceBox<>();
    Button newMetroCard = new Button("New MetroCard");
    Label enterNumberOfRides = new Label("Enter number of rides:");
    TextField numberOfRides = new TextField();
    Button addRides = new Button("Add rides");
    Label priceCalculation = new Label("");

    public MetroTicketPane(MetroTicketViewController metroTicketViewController){
        this.getChildren().addAll(newMetroCard, metroCardIdsChoiceBox, enterNumberOfRides, numberOfRides, addRides, priceCalculation);

        newMetroCard.setOnAction(e -> metroTicketViewController.newMetroCard());

        addRides.setOnAction(e -> metroTicketViewController.addRides(metroCardIdsChoiceBox.getValue(), Integer.parseInt(numberOfRides.getText())));
    }

    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
        metroCardIdsChoiceBox.setItems(FXCollections.observableArrayList(ids));
    }
}
