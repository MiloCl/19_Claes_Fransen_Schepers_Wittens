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
        facade.registerObserver(this, MetroEventsEnum.BUY_METROCARD);
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
        System.out.println("IDS: " + IDS + "(update methode in MetroStationViewController");
        System.out.println("MetroStationView: " + metroStationView);
        metroStationView.updateMetroCardIDList(IDS);
    }


}
