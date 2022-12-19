package model;

import model.database.MetroCardDatabase;


public class Facade {

    private final MetroCardDatabase metroCardDatabase;

    public Facade() {
        this.metroCardDatabase = MetroCardDatabase.getInstance();
    }

    public MetroCardDatabase getMetroCardDatabase() {
        return metroCardDatabase;
    }
}