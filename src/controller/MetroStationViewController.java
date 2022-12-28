package controller;

import model.MetroEventsEnum;
import model.MetroFacade;
import model.domain.MetroCard;
import view.MetroStationView;

import java.util.TreeMap;

public class MetroStationViewController implements Observer{
    MetroFacade facade = MetroFacade.getInstance();
    private MetroStationView metroStationView;
    MetroTicketViewController metroTicketViewController = new MetroTicketViewController(facade);

    public MetroStationViewController(MetroFacade facade) {
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
    }

    public MetroFacade getFacade() {
        return facade;
    }

    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {

    }
}
