package model;

import model.database.MetroCardDatabase;


import java.util.ArrayList;
import java.util.Observer;

public class Facade implements Subject{

    private static Facade facade;
    private final MetroCardDatabase metroCardDatabase;
    private final ArrayList<Observer> observers = new ArrayList<>();

    public Facade() {
        this.metroCardDatabase = MetroCardDatabase.getInstance();
    }
    public static Facade getInstance(){
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public MetroCardDatabase getMetroCardDatabase() {
        return metroCardDatabase;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers) {
            observer.notify();
        }
    }
}