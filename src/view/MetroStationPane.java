package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;

import java.util.ArrayList;

public class MetroStationPane extends VBox {
    static ChoiceBox<Integer> metroCardIds = new ChoiceBox<>();
    public MetroStationPane(MetroStationViewController metroStationViewController) {
        this.getChildren().add(metroCardIds);
    }

    /*public static void update(MetroStationViewController metroStationViewController) {
        MetroCardDatabase metroCardDatabase = MetroCardDatabase.getInstance();
        metroCardIds.setItems(FXCollections.observableArrayList(metroCardDatabase.getMetrocardIDlist()));
    }*/

    public static void updateMetroCardIDList(ArrayList<Integer> ids) {
        metroCardIds.setItems(FXCollections.observableArrayList(ids));
    }
}
