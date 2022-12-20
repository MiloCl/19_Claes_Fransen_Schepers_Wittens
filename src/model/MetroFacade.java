package model;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import sun.reflect.generics.tree.Tree;


import java.util.ArrayList;
import java.util.Observer;
import java.util.TreeMap;

public class MetroFacade implements Subject{

    private static MetroFacade facade;
    private final MetroCardDatabase metroCardDatabase;
    private final ArrayList<Observer> observers = new ArrayList<>();
    private TreeMap<String, MetroCard> metrosorts = new TreeMap<>();

    public MetroFacade() {
        this.metroCardDatabase = MetroCardDatabase.getInstance();
    }
    public static MetroFacade getInstance(){
        if (facade == null) {
            facade = new MetroFacade();
        }
        return facade;
    }

    public MetroCardDatabase getMetroCardDatabase() {
        return metroCardDatabase;
    }

    public void openMetroStation(){
        metroCardDatabase.load();
        metrosorts = metroCardDatabase.getMetrosorts();

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