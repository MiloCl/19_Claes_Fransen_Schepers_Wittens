package model.ticketPriceDecorator;

public class ChristmasLeaveDiscount extends TicketPriceDiscountDecorator {

    public ChristmasLeaveDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    public double getPrice() {
        return ticketPrice.getPrice() - 0.1;
    }

    public String getPriceText() {
        return ticketPrice.getPriceText() + " + Christmas Leave Discount";
    }
}

