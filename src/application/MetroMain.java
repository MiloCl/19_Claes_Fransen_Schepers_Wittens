package application;
	
import controller.AdminOverviewViewController;
import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MetroFacade;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		MetroFacade facade = MetroFacade.getInstance();

		AdminOverviewViewController adminOverviewViewController = new AdminOverviewViewController(facade);
		MetroStationViewController metroStationViewController = new MetroStationViewController(facade);
		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(facade);
		
		AdminView adminView = new AdminView(adminOverviewViewController);
		MetroTicketView metroTicketView = new MetroTicketView(metroTicketViewController);
		MetroStationView metroStationView = new MetroStationView(metroStationViewController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
