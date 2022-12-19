package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Facade;
import model.database.MetroCardDatabase;
import model.domain.MetroStation;
import view.panels.MetroCardOverviewPane;
import view.panels.PaneTest;

import java.util.TreeMap;

public class AdminMainPane extends BorderPane {


    public AdminMainPane(){
	    TabPane tabPane = new TabPane();
        HBox panes= new HBox();
        Facade facade = new Facade();
        MetroCardOverviewPane metroCardOverviewPane = new PaneTest(facade.getMetroCardDatabase().getDatabase().values());
        panes.getChildren().add(metroCardOverviewPane);
	//maak een controlCenterPane aan
	//maak een setupPane aan
        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center");
        Tab setupTab = new Tab("Setup");
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);
        this.setCenter(tabPane);

	}
}
