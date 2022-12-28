package model.ticketPriceDecorator;

import model.domain.MetroCard;
import org.omg.CORBA.portable.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;

public class TicketPriceFactory {
    public ArrayList<String> activeDiscounts;
    TicketPrice ticketPrice;
    String ticketPriceDescription;

    public TicketPriceFactory() {

    }


    public ArrayList<String> getActiveDiscounts() throws IOException {
        try {
            FileInputStream input = new FileInputStream("src/bestanden/settings.properties");
            Properties prop = new Properties();
            prop.load(input);
            activeDiscounts = new ArrayList<String>();
            if (prop.getProperty("frequentTravellerDiscountSelected").equals("true")) {
                activeDiscounts.add("frequentTravellerDiscount");
            }
            if (prop.getProperty("studentDiscountSelected").equals("true")) {
                activeDiscounts.add("studentDiscount");
            }
            if (prop.getProperty("age64PlusDiscountSelected").equals("true")) {
                activeDiscounts.add("age64plusDiscount");
            }
            if (prop.getProperty("christmasLeaveDiscountSelected").equals("true")) {
                activeDiscounts.add("christmasLeaveDiscount");
            }
            return activeDiscounts;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  TicketPrice createTicketPrice(boolean is24Min, boolean is64Plus ,boolean isStudent, MetroCard metroCard) throws IOException {
        ticketPrice = new BasicTicketPrice(is24Min, is64Plus, isStudent, metroCard);
        ticketPriceDescription = ticketPrice.getPriceText();

        activeDiscounts = getActiveDiscounts();

        for(String discount : activeDiscounts) {
            if(discount.equals("frequentTravellerDiscount") && metroCard.getAantalVerbruikteRitten() >= 50) {
                ticketPrice = new FrequentTravellerDiscount(ticketPrice);
                ticketPriceDescription += " " + ticketPrice.getPriceText();
            }
            if(discount.equals("studentDiscount") && isStudent) {
                ticketPrice = new StudentDiscount(ticketPrice);
                ticketPriceDescription += " " + ticketPrice.getPriceText();
            }
            if(discount.equals("age64plusDiscount") && is64Plus) {
                ticketPrice = new Age64PlusDiscount(ticketPrice);
                ticketPriceDescription += " " + ticketPrice.getPriceText();
            }
            if(discount.equals("christmasLeaveDiscount")) {
                ticketPrice = new ChristmasLeaveDiscount(ticketPrice);
                ticketPriceDescription += " " + ticketPrice.getPriceText();
            }
        }
        return ticketPrice;
    }

}
