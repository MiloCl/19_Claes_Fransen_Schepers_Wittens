package model;

import controller.Observer;


public interface Subject {

    public void registerObserver(Observer o, MetroEventsEnum metroEventsEnum);
    public void removeObserver(Observer o);
    public void notifyObservers(MetroEventsEnum metroEventsEnum);
}