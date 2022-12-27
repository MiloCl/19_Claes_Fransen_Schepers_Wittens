package controller;

import model.MetroFacade;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import view.AdminMainPane;
import view.AdminView;
import view.panels.ControlCenterPane;
import view.panels.MetroCardOverviewPane;

import javax.naming.ldap.Control;
import java.util.TreeMap;


public class ControlCenterPaneController implements Observer {
    private AdminView adminView;
    private static MetroFacade facade = MetroFacade.getInstance();
    public static MetroCardDatabase metroCardDatabase = facade.getMetroCardDatabase();

    public static void openMetroStation() {
        facade.openMetroStation();
    }




    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {

    }
}
