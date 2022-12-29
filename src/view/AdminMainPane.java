package view;

import controller.AdminOverviewViewController;
import controller.ControlCenterPaneController;
import controller.SetupPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.MetroFacade;
import model.domain.MetroCard;
import view.panels.ControlCenterPane;
import view.panels.MetroCardOverviewPane;
import view.panels.SetupPane;


public class AdminMainPane extends BorderPane {


    public AdminMainPane(AdminOverviewViewController adminOverviewViewController, ControlCenterPaneController controlCenterPaneController) {
        {
            TabPane tabPane = new TabPane();
            HBox overviewPane = new HBox();
            HBox controlPane = new HBox();
            HBox setup = new HBox();

            MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane(adminOverviewViewController);


            ControlCenterPane controlCenterPane = new ControlCenterPane(controlCenterPaneController);

            SetupPaneController setupPaneController = new SetupPaneController();
            SetupPane setupPane = new SetupPane(setupPaneController);

            overviewPane.getChildren().addAll(metroCardOverviewPane);
            controlPane.getChildren().addAll(controlCenterPane);
            setup.getChildren().addAll(setupPane);
            Tab controlCenterTab = new Tab("Control Center", controlPane);
            Tab metroCardOverviewTab = new Tab("Metro Card Overview", overviewPane);
            Tab setupTab = new Tab("Setup", setup);

            tabPane.getTabs().add(controlCenterTab);
            tabPane.getTabs().add(metroCardOverviewTab);
            tabPane.getTabs().add(setupTab);
            this.setCenter(tabPane);

        }
    }
}