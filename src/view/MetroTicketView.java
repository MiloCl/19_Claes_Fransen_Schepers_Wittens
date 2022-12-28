package view;

import controller.MetroTicketViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class MetroTicketView {
	private Stage stage = new Stage();
	MetroTicketViewController metroTicketViewController;
		
	public MetroTicketView(MetroTicketViewController metroTicketViewController){
		this.metroTicketViewController = metroTicketViewController;

		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 350);
		MetroTicketPane metroTicketPane = new MetroTicketPane(metroTicketViewController);
		root.getChildren().add(metroTicketPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();

		metroTicketViewController.setView(this); // controller.Observer

	}

	public void updateMetroCardIDList(ArrayList<Integer> ids) {
		MetroTicketPane.updateMetroCardIDList(ids);
	}



}
