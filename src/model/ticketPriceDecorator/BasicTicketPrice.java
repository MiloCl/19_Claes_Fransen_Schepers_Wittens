package model.ticketPriceDecorator;

import model.domain.MetroCard;

public class BasicTicketPrice extends TicketPrice {
    TicketPriceDiscountEnum ticketPriceDiscountEnum;

    public BasicTicketPrice(boolean is24, boolean is64Plus, boolean isStudent, MetroCard metroCard) {
        super(isStudent, is24, is64Plus, metroCard.getAantalVerbruikteRitten() > 50);

    }

    public BasicTicketPrice(){

    }

    @Override
    public double getPrice() { return 2.1; }

    @Override
    public String getPriceText() {
        return "Basic price is €2,10";
    }
}
