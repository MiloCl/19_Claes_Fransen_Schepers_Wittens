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

    public void saveDiscounts(boolean age64PlusDiscountSelected, boolean christmasLeaveDiscountSelected, boolean studentDiscountSelected, boolean frequentTravellerDiscountSelected) {
        Setup.saveDiscounts(age64PlusDiscountSelected, christmasLeaveDiscountSelected, studentDiscountSelected, frequentTravellerDiscountSelected);
    }

    public void saveSettings(String fileFormat, boolean age64PlusDiscountSelected, boolean christmasLeaveDiscountSelected, boolean studentDiscountSelected, boolean frequentTravellerDiscountSelected) {
        Setup.saveSettings(fileFormat, age64PlusDiscountSelected, christmasLeaveDiscountSelected, studentDiscountSelected, frequentTravellerDiscountSelected);
    }

    public boolean getAge64PlusDiscount() {
        return Setup.getAge64PlusDiscount();
    }

    public boolean getChristmasLeaveDiscount() {
        return Setup.getChristmasLeaveDiscount();
    }

    public boolean getStudentDiscount() {
        return Setup.getStudentDiscount();
    }

    public boolean getFrequentTravellerDiscount() {
        return Setup.getFrequentTravellerDiscount();
    }
}
