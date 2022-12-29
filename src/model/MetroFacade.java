package model;

import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import controller.Observer;
import model.domain.MetroGate;
import model.domain.MetroStation;
import model.ticketPriceDecorator.TicketPrice;
import model.ticketPriceDecorator.TicketPriceFactory;


import java.io.IOException;
import java.util.*;

import static java.lang.Math.round;

public class MetroFacade implements Subject{

    private static MetroFacade facade;
    private final MetroCardDatabase metroCardDatabase;
    private final Map<MetroEventsEnum, ArrayList<Observer>> observers = new HashMap<>();
    private TreeMap<String, MetroCard> metroCards = new TreeMap<>();
    private TicketPriceFactory ticketPriceFactory = new TicketPriceFactory();
    private MetroStation metroStation;


    public MetroFacade() {
        this.metroCardDatabase = MetroCardDatabase.getInstance();
        this.metroStation = new MetroStation();

    }
    public static MetroFacade getInstance(){
        if (facade == null) {
            facade = new MetroFacade();
        }
        return facade;
    }


    @Override
    public void registerObserver(Observer o, MetroEventsEnum metroEventsEnum) {
        observers.computeIfAbsent(metroEventsEnum, k -> new ArrayList<>()).add(o);
    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers(MetroEventsEnum metroEventsEnum) {
        for (Observer observer : observers.computeIfAbsent(metroEventsEnum, k -> new ArrayList<>())) {
            observer.update(metroCards);
        }
    }

    public MetroCardDatabase getMetroCardDatabase() {
        return metroCardDatabase;
    }

    public void openMetroStation(){
        metroCardDatabase.load();
        metroCards = metroCardDatabase.getMetroCards();
        notifyObservers(MetroEventsEnum.OPEN_METROSTATION);
    }

    public ArrayList<Integer> getMetroCardIDList(){

        return metroCardDatabase.getMetrocardIDlist();
    }

    public void newMetroCard() {
        metroCardDatabase.newMetroCard();
        notifyObservers(MetroEventsEnum.BUY_NEW_METROCARD);
    }

    public void confirmAdding(Integer id, int rides) {
        metroCardDatabase.addRides(id, rides);
        notifyObservers(MetroEventsEnum.BUY_METROCARD_TICKETS);
    }

    public TicketPrice getTicketPrice(boolean is24Min, boolean is64Plus, boolean isStudent,MetroCard metroCard) throws IOException {
        System.out.println("ticketPriceFactory: " + ticketPriceFactory);

        TicketPrice ticketPrice = ticketPriceFactory.createTicketPrice(is24Min, is64Plus, isStudent, metroCard);
        System.out.println("ticketPrice: " + ticketPrice);

        return ticketPrice;
    }

    public double getPrice(boolean is24Min, boolean is64Plus, boolean isStudent, MetroCard metroCard) throws IOException {
        return round(ticketPriceFactory.createTicketPrice(is24Min, is64Plus, isStudent, metroCard).getPrice());
    }


    public String getPriceText(boolean is24Min, boolean is64Plus, boolean isStudent, MetroCard metroCard) throws IOException{
        return ticketPriceFactory.createTicketPrice(is24Min, is64Plus, isStudent, metroCard).getPriceText();
    }



    public void scanCard(int gateID, Integer cardID) {
        if(scanCardPossible(cardID)){
            metroStation.scanCard(gateID, cardID);
            cardScanned(cardID);
            notifyObservers(MetroEventsEnum.SCAN_METROGATE);
        }
    }



    private void cardScanned(int cardID){
        metroCardDatabase.getMetroCard(cardID).setBeschikbareRitten(metroCardDatabase.getMetroCard(cardID).getBeschikbareRitten()-1);
        notifyObservers(MetroEventsEnum.METROCARD_SCANNED);
    }

    private boolean scanCardPossible(Integer cardID) {
        MetroCard metroCard = metroCardDatabase.getMetroCard(cardID);
        if(metroCard.getBeschikbareRitten() >= 1){
            return true;
        }
        return false;
    }

    public ArrayList<MetroGate> getMetroGates() {
        return metroStation.getMetroGates();
    }

    /*public TicketPrice createTicketPrice() {
        TicketPrice ticketPrice = new TicketPrice();
        return ticketPrice;
    }*/
}