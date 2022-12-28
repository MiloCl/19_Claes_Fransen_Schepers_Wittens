package model;

import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import controller.Observer;


import java.util.*;

public class MetroFacade implements Subject{

    private static MetroFacade facade;
    private final MetroCardDatabase metroCardDatabase;
    private final Map<MetroEventsEnum, ArrayList<Observer>> observers = new HashMap<>();
    private TreeMap<String, MetroCard> metroCards = new TreeMap<>();

    public MetroFacade() {
        this.metroCardDatabase = MetroCardDatabase.getInstance();
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
        notifyObservers(MetroEventsEnum.BUY_METROCARD);
    }

    public void addRides(Integer id, int rides) {
        metroCardDatabase.addRides(id, rides);
        notifyObservers(MetroEventsEnum.ADD_RIDES);
    }
}