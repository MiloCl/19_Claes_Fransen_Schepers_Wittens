package view.panels;


import controller.ControlCenterPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControlCenterGatePane extends VBox {

    int gateID;

    Label gateIDLabel = new Label("ID: ");
    Button activate = new Button("Activate");
    Button deactivate = new Button("Deactivate");
    Label scannedCardsLabel = new Label("Nr Of Scanned Cards: ");
    Label nrOfScannedCards = new Label("0");

    public ControlCenterGatePane(ControlCenterPaneController controlCenterPaneController) {
        this.getChildren().addAll(gateIDLabel, activate, deactivate, scannedCardsLabel, nrOfScannedCards);
        this.setStyle("-fx-background-color: lightgrey");

        //activate.setOnAction(e -> controlCenterPaneController.activateGate(gateID));
        //deactivate.setOnAction(e -> controlCenterPaneController.deactivateGate(gateID));
        deactivate.setOnAction(e -> setStyle("-fx-background-color: orange"));
        activate.setOnAction(e -> setStyle("-fx-background-color: lightgrey"));
    }
}
