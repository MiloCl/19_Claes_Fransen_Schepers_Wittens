package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;

import java.util.ArrayList;

public class MetroStationPane extends VBox {

    static MetroGatePane gate1;
    static MetroGatePane gate2;
    static MetroGatePane gate3;


    public MetroStationPane(MetroStationViewController metroStationViewController) {
        gate1 = new MetroGatePane(metroStationViewController);
        gate2 = new MetroGatePane(metroStationViewController);
        gate3 = new MetroGatePane(metroStationViewController);

        gate1.gateNr.setText("Gate 1");
        gate2.gateNr.setText("Gate 2");
        gate3.gateNr.setText("Gate 3");

        gate1.gateID = 1;
        gate2.gateID = 2;
        gate3.gateID = 3;

        HBox gates = new HBox();

        gates.setSpacing(20);
        gates.getChildren().addAll(gate1, gate2, gate3);

        this.getChildren().addAll(gates);
    }



    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
       gate1.updateMetroCardIDList(ids);
       gate2.updateMetroCardIDList(ids);
       gate3.updateMetroCardIDList(ids);
    }
}
