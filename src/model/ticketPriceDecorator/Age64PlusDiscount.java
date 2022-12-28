package model.ticketPriceDecorator;

public class Age64PlusDiscount extends TicketPriceDiscountDecorator {


    public Age64PlusDiscount(TicketPrice ticketPrice) {

        super(ticketPrice);

    }

    public double getPrice() {

        return ticketPrice.getPrice() - 0.5;

    }

    public String getPriceText() {

        return ticketPrice.getPriceText() + " + 64+ Discount";

    }
}

