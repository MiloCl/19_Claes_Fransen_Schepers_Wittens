package controller;

import model.Facade;
import model.domain.MetroCard;
import view.AdminView;
import model.Setup;

import java.util.Collection;
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

    public void savePreferences(String format, String discount) {
        Setup.setProperties(format, discount);
    }

    public Collection<MetroCard> getMetroCardDatabase() {
        return getFacade().getMetroCardDatabase().getMetrosorts().values();
    }

    public String getProductFormatReader() {
        return Setup.getMetroCardFormatReaderSettings();
    }

    public Facade getFacade() {
        return facade;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}