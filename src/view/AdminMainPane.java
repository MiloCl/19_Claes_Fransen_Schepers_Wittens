package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Facade;
import view.panels.MetroCardOverviewPane;


public class AdminMainPane extends BorderPane {
    public AdminMainPane(Facade facade){
        TabPane tabPane = new TabPane();
        //Tab spelVerloopTab = new Tab("Spelverloop");
        HBox panes = new HBox();
        MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane(facade.getMetroCardDatabase().getMetrosorts().values());
        panes.getChildren().addAll(metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Controller");
        Tab metroCardOverviewTab = new Tab("Metro Card Overview",panes);
        Tab setupTab = new Tab("Setup");
        //tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);
        this.setCenter(tabPane);

    }
}