package controller;

import model.MetroEventsEnum;
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
    private static MetroFacade facade;

    public ControlCenterPaneController(MetroFacade facade) {
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.ACTIVATE_METROGATE);
        facade.registerObserver(this, MetroEventsEnum.DEACTIVATE_METROGATE);
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
        facade.registerObserver(this, MetroEventsEnum.ALERT);
        facade.registerObserver(this, MetroEventsEnum.METROCARD_SCANNED);
    }

    public static void openMetroStation() {
        facade.openMetroStation();
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }

    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {
        System.out.println("adminview: " + adminView + " updatemethode controclcenterpanecontroller");
        adminView.updateGates(facade.getMetroGates());
        adminView.updateErrors(facade.getErrors());
        adminView.updateNrOfCardsScanned(facade.getMetroGates());
    }

    public void activateGate(int gateID) {
        facade.activateGate(gateID);
    }

    public void deactivateGate(int gateID) {
        facade.deactivateGate(gateID);
    }

    public void closeMetroStation() {
        facade.closeMetroStation();
    }
}
