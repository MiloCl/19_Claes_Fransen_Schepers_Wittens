package view.panels;

import controller.ControlCenterPaneController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ControlCenterPane extends VBox {

    Button openMetroStation = new Button("Open Metro Station");

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) {
        this.getChildren().addAll(openMetroStation);

        openMetroStation.setOnAction(e -> controlCenterPaneController.openMetroStation());
    }

}


