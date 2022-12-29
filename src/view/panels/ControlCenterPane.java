package view.panels;

import controller.ControlCenterPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlCenterPane extends VBox {

    static ControlCenterGatePane gate1;
    static ControlCenterGatePane gate2;
    static ControlCenterGatePane gate3;

    Label alerts = new Label("Alerts: ");

    Button openMetroStation = new Button("Open Metro Station");

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) {
        this.getChildren().addAll(openMetroStation);

        gate1 = new ControlCenterGatePane(controlCenterPaneController);
        gate2 = new ControlCenterGatePane(controlCenterPaneController);
        gate3 = new ControlCenterGatePane(controlCenterPaneController);

        gate1.gateIDLabel.setText("Gate 1");
        gate2.gateIDLabel.setText("Gate 2");
        gate3.gateIDLabel.setText("Gate 3");

        gate1.gateID = 1;
        gate2.gateID = 2;
        gate3.gateID = 3;

        HBox gatesControl = new HBox();

        gatesControl.setSpacing(15);
        gatesControl.getChildren().addAll(gate1, gate2, gate3);
        this.getChildren().addAll(gatesControl, alerts);


        openMetroStation.setOnAction(e -> controlCenterPaneController.openMetroStation());
    }

}


