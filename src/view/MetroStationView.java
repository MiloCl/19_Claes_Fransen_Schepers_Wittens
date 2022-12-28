package view;

import controller.MetroStationViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class MetroStationView {
	
	private Stage stage = new Stage();
	MetroStationViewController metroStationViewController;
	
	public MetroStationView(MetroStationViewController metroStationViewController){
		this.metroStationViewController = metroStationViewController;
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 300);
		MetroStationPane metroStationPane = new MetroStationPane(metroStationViewController);
		root.getChildren().add(metroStationPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		metroStationViewController.setView(this); // controller.Observer
	}

	public void updateMetroCardIDList(ArrayList<Integer> ids) {
		MetroStationPane.updateMetroCardIDList(ids);
	}
}
