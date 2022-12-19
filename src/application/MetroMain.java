package application;
	
import controller.AdminViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Facade;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		Facade facade = Facade.getInstance();

		AdminViewController adminViewController = new AdminViewController(facade);
		AdminView adminView = new AdminView(adminViewController);
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
