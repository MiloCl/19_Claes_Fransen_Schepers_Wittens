package view;

import controller.AdminOverviewViewController;
import controller.ControlCenterPaneController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.domain.MetroGate;
import view.panels.ControlCenterPane;
import view.panels.OverviewPane;

import java.util.ArrayList;

public class AdminView{

	private Stage stage = new Stage();
	AdminOverviewViewController adminOverviewViewController;
	ControlCenterPaneController controlCenterPaneController;


	public AdminView(AdminOverviewViewController adminOverviewViewController, ControlCenterPaneController controlCenterPaneController){
		this.adminOverviewViewController = adminOverviewViewController;
		this.controlCenterPaneController = controlCenterPaneController;
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(660);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 690, 680);
		BorderPane borderPane = new AdminMainPane(adminOverviewViewController, controlCenterPaneController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		adminOverviewViewController.setView(this); // controller.Observer
		controlCenterPaneController.setView(this);
	}
	public void update() {
		OverviewPane.update(adminOverviewViewController);
	}

	public void updateGates(ArrayList<MetroGate> metroGates) {
		ControlCenterPane.updateGates(metroGates);
	}


	public void updateErrors(ArrayList<String> errors) {
		ControlCenterPane.updateErrors(errors);
	}

	public void updateNrOfCardsScanned(ArrayList<MetroGate> metroGates) {
		ControlCenterPane.updateNrOfCardsScanned(metroGates);
	}
}
