package controller;

import model.MetroEventsEnum;
import model.MetroFacade;
import model.domain.MetroCard;
import view.MetroStationView;

import java.util.ArrayList;
import java.util.TreeMap;

public class MetroStationViewController implements Observer{
    MetroFacade facade = MetroFacade.getInstance();
    private MetroStationView metroStationView;

    public MetroStationViewController(MetroFacade facade) {
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
        facade.registerObserver(this, MetroEventsEnum.BUY_NEW_METROCARD);
        facade.registerObserver(this, MetroEventsEnum.BUY_METROCARD_TICKETS);
        facade.registerObserver(this, MetroEventsEnum.METROCARD_SCANNED);
    }

    public MetroFacade getFacade() {
        return facade;
    }

    public void setView(MetroStationView metroStationView) {
        this.metroStationView = metroStationView;
    }

    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {
        ArrayList<Integer> IDS = facade.getMetroCardIDList();
        metroStationView.updateMetroCardIDList(IDS);
        metroStationView.updateGatesStatusses(facade.getMetroGates());
    }


    public void scanCard(int gateID, Integer cardID) {
        facade.scanCard(gateID, cardID);
    }
}
