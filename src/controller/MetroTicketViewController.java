package controller;


import controller.Observer;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.domain.MetroCard;
import view.MetroTicketView;

import java.util.TreeMap;

public class MetroTicketViewController implements Observer {

    private MetroTicketView metroTicketView;
    private MetroFacade facade = MetroFacade.getInstance();

    public MetroTicketViewController(MetroFacade facade) {
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
    }



    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {

    }
}
