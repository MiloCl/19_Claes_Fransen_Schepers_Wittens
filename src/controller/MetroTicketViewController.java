package controller;


import controller.Observer;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import view.AdminView;
import view.MetroTicketView;

import java.util.ArrayList;
import java.util.TreeMap;

public class MetroTicketViewController implements Observer {

    private MetroTicketView metroTicketView;
    private MetroFacade facade;

    public MetroTicketViewController(MetroFacade facade){
        this.facade = facade;
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
    }
    public void setView(MetroTicketView view) {
        this.metroTicketView = view;
        System.out.println("metroticketview: " + metroTicketView + " (setView methode)");
    }

    public MetroTicketView getView() {
        return metroTicketView;
    }

    public void newMetroCard() {
        facade.newMetroCard();
    }

    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {
        ArrayList<Integer> IDS = facade.getMetroCardIDList();
        System.out.println("IDS: " + IDS + "(update methode in MetroTicketViewController");
        System.out.println("MetroTicketView: " + metroTicketView);
        metroTicketView.updateMetroCardIDList(IDS);
    }


}
