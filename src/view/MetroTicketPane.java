package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MetroTicketPane extends VBox {
    private static ChoiceBox<Integer> metroCardIdsChoiceBox = new ChoiceBox<>();

    Button newMetroCard = new Button("New MetroCard");

    public MetroTicketPane(MetroTicketViewController metroTicketViewController){
        this.getChildren().add(metroCardIdsChoiceBox);
        this.getChildren().add(newMetroCard);
        newMetroCard.setOnAction(e -> metroTicketViewController.newMetroCard());
    }

    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
        metroCardIdsChoiceBox.setItems(FXCollections.observableArrayList(ids));
    }
}
