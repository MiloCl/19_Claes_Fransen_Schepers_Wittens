package controller;

import model.MetroFacade;
import model.domain.MetroCard;
import view.AdminView;
import model.Setup;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class AdminViewController implements Observer {

    private AdminView adminView;
    private final MetroFacade facade = MetroFacade.getInstance();

    public AdminViewController(MetroFacade facade) {
        facade.registerObserver(this);
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }

    public void savePreferences(String format, String discount) {
        Setup.setProperties(format, discount);
    }

    public void saveFileFormat(String format) {
        Setup.setFileFormat(format);
    }

    public Collection<MetroCard> getMetroCardDatabase() {
        return getFacade().getMetroCardDatabase().getMetroCards().values();
    }

    public String getFileFormat() {
        return Setup.getFileFormat();
    }

    public MetroFacade getFacade() {
        return facade;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}