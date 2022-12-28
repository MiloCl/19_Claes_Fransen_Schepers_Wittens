package controller;


import model.MetroEventsEnum;
import model.MetroFacade;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import model.ticketPriceDecorator.BasicTicketPrice;
import model.ticketPriceDecorator.TicketPrice;
import model.ticketPriceDecorator.TicketPriceDiscountDecorator;
import model.ticketPriceDecorator.TicketPriceFactory;
import view.MetroTicketPane;
import view.MetroTicketView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MetroTicketViewController implements Observer {

    private MetroTicketView metroTicketView;
    private MetroTicketPane metroTicketPane;
    private MetroFacade facade;
    private TicketPrice ticketPrice;
    private TicketPriceFactory ticketPriceFactory = new TicketPriceFactory();
    private TicketPriceDiscountDecorator ticketPriceDiscountDecorator;

    public MetroTicketViewController(MetroFacade facade){
        this.facade = facade;
        //this.ticketPrice = ticketPriceFactory.createTicketPrice;

        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);
        facade.registerObserver(this, MetroEventsEnum.BUY_NEW_METROCARD);
        facade.registerObserver(this, MetroEventsEnum.BUY_METROCARD_TICKETS);
    }
    public void setView(MetroTicketView view) {
        this.metroTicketView = view;
        System.out.println("metroticketview: " + metroTicketView + " (setView methode)");
    }
    public void setPane(MetroTicketPane pane){
        System.out.println("metroticketpane set: " + metroTicketPane + " (setPane methode)");
        this.metroTicketPane = pane;
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
        metroTicketView.updateMetroCardIDList(IDS);
    }



    public String addRides() throws IOException {
        System.out.println("ticketprice: " + ticketPrice + " (addRides methode)");
        return "" + facade.getPrice(ticketPrice.getIs24Min(), ticketPrice.getIs64Plus(), ticketPrice.getIsStudent(), MetroCardDatabase.getInstance().getMetroCard(metroTicketPane.getMetroCardId()));
    }

    public String addDescription() throws IOException{
        System.out.println("facades: " + facade);
        System.out.println("ticketPrice: " + ticketPrice);
        System.out.println("metroTicketView: " + metroTicketView);
        if (MetroCardDatabase.getInstance().getMetroCard(metroTicketPane.getMetroCardId()) == null){
            return "No metrocard selected";
        }
        else {
            return facade.getPriceText(ticketPrice.getIs24Min(), ticketPrice.getIs64Plus(), ticketPrice.getIsStudent(), MetroCardDatabase.getInstance().getMetroCard(metroTicketPane.getMetroCardId()));
        }
    }

    public void confirm(Integer id, int rides) {
        facade.confirmAdding(id, rides);
    }

}
