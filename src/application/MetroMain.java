package application;
	
import controller.AdminOverviewViewController;
import controller.ControlCenterPaneController;
import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MetroFacade;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;

import java.io.IOException;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		MetroFacade facade = MetroFacade.getInstance();

		AdminOverviewViewController adminOverviewViewController = new AdminOverviewViewController(facade);
		ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController(facade);
		AdminView adminView = new AdminView(adminOverviewViewController, controlCenterPaneController);

		MetroStationViewController metroStationViewController = new MetroStationViewController(facade);
		MetroStationView metroStationView = new MetroStationView(metroStationViewController);

		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(facade);
		MetroTicketView metroTicketView = new MetroTicketView(metroTicketViewController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
