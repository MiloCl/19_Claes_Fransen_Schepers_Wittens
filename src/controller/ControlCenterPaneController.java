package controller;

import model.MetroFacade;
import model.database.MetroCardDatabase;
import view.AdminMainPane;
import view.AdminView;
import view.panels.ControlCenterPane;
import view.panels.MetroCardOverviewPane;

import javax.naming.ldap.Control;
import java.util.Observable;
import java.util.Observer;


public class ControlCenterPaneController implements Observer {
    private AdminView adminView;
    private static MetroFacade facade = MetroFacade.getInstance();
    public static MetroCardDatabase metroCardDatabase = facade.getMetroCardDatabase();

    public static void openMetroStation() {
        metroCardDatabase.load();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
