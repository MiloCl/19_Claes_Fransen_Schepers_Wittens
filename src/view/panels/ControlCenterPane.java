package view.panels;

import controller.AdminViewController;
import controller.ControlCenterPaneController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.domain.MetroCard;
import controller.ControlCenterPaneController;

import java.util.Collection;

public class ControlCenterPane extends VBox {

    Button openMetroStation = new Button("Open Metro Station");

    public ControlCenterPane() {
        this.getChildren().addAll(openMetroStation);
        openMetroStation.setOnAction(e -> ControlCenterPaneController.openMetroStation());
    }

}


