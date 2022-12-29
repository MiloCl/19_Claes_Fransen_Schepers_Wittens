package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MetroGatePane extends VBox {

    int gateID;
    Label gateNr = new Label();
    Label gateIDLabel = new Label("ID: ");
    static ChoiceBox<Integer> metroCardIds = new ChoiceBox<>();
    Button scanCard = new Button("Scan Card");
    Button walkTrough = new Button("Walk Through");
    Label status = new Label("Status: ");

    public MetroGatePane(MetroStationViewController metroStationViewController) {
        metroCardIds.show();
        this.getChildren().addAll(gateNr, gateIDLabel ,metroCardIds, scanCard, walkTrough, status);
    }

    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
        metroCardIds.setItems(FXCollections.observableArrayList(ids));

    }
}
