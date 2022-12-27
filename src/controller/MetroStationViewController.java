package controller;

import model.MetroEventsEnum;
import model.MetroFacade;
import model.domain.MetroCard;
import view.MetroStationView;

import java.util.TreeMap;

public class MetroStationViewController implements Observer{
    MetroFacade facade = MetroFacade.getInstance();
    MetroStationView metroStationView = new MetroStationView();


    public MetroStationViewController(MetroFacade facade) {
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
    }


    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {

    }
}
