package controller;

import model.Facade;
import view.AdminView;

import java.util.Observable;
import java.util.Observer;

public class AdminViewController implements Observer {

    private AdminView adminView;
    private final Facade facade = Facade.getInstance();

    public AdminViewController(Facade facade) {
        facade.registerObserver(this);
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }


    public Facade getFacade() {
        return facade;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}