package controller;

import model.MetroFacade;
import view.MetroStationView;

public class MetroStationViewController {
    MetroFacade facade = MetroFacade.getInstance();
    MetroStationView metroStationView = new MetroStationView();
}
