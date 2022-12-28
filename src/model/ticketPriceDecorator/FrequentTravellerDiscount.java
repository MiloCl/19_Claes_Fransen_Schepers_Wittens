package model.ticketPriceDecorator;

public class FrequentTravellerDiscount extends TicketPriceDiscountDecorator {

    public FrequentTravellerDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    public double getPrice() {
        return ticketPrice.getPrice() * 0.2;
    }

    public String getPriceText() {
        return ticketPrice.getPriceText() + " + Frequent Traveller Discount";
    }
}
