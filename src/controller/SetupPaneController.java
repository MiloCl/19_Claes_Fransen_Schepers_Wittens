package controller;

import model.Setup;
import model.domain.MetroCard;

import java.util.TreeMap;


public class SetupPaneController implements Observer {


    public void saveFileFormat(String format) {
        Setup.setFileFormat(format);
    }


    public String getFileFormat() {
        return Setup.getFileFormat();
    }



    @Override
    public void update(TreeMap<String, MetroCard> metroCards) {

    }
}
