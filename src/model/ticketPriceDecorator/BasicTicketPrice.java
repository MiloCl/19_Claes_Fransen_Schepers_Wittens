package model.ticketPriceDecorator;

import model.domain.MetroCard;

public class BasicTicketPrice extends TicketPrice {

    public BasicTicketPrice(boolean is24, boolean is64Plus, boolean isStudent, MetroCard metroCard) {
        super(isStudent, is24, is64Plus, metroCard);
    }

    public double getPrice() {
        return 0;
    }

    public String getPriceText() {
        return "";
    }
}
