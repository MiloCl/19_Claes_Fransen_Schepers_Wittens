package application;
	
import controller.AdminOverviewViewController;
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
		AdminView adminView = new AdminView(adminOverviewViewController);
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
