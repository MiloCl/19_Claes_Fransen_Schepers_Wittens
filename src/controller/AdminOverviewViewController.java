package controller;

import model.MetroEventsEnum;
import model.MetroFacade;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import view.AdminView;
import model.Setup;
import view.panels.MetroCardOverviewPane;

import java.util.Collection;
import java.util.TreeMap;


public class AdminOverviewViewController implements Observer{

    private MetroCardOverviewPane metroCardOverviewPane;
    private final MetroFacade facade = MetroFacade.getInstance();
    private AdminView adminView;


    public AdminOverviewViewController(MetroFacade facade) {
        facade.registerObserver(this, MetroEventsEnum.OPEN_METROSTATION);

    }

    public void setView(AdminView view) {
        this.adminView = view;
    }





    public Collection<MetroCard> getMetroCardDatabase() {
        return getFacade().getMetroCardDatabase().getMetroCards().values();
    }


    public MetroFacade getFacade() {
        return facade;
    }




    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {
        adminView.update();
        System.out.println("Dees doet iets");
    }
}