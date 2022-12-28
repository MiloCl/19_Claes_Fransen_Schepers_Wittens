package model.ticketPriceDecorator;

public class StudentDiscount extends TicketPriceDiscountDecorator {

    public StudentDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    public double getPrice() {
        return ticketPrice.getPrice() - 0.25;
    }

    public String getPriceText() {
        return ticketPrice.getPriceText() + " + Student Discount";
    }
}

