package model.ticketPriceDecorator;

public class ChristmasLeaveDiscount extends TicketPriceDiscountDecorator {

    double discount;
    double price;
    public ChristmasLeaveDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
        price = ticketPrice.getPrice();
        discount = TicketPriceDiscountEnum.getDiscountByName("Christmas Leave Discount").getDiscount();
    }

    @Override
    public double getPrice() {return price - discount; }

    @Override
    public String getPriceText() {
        return price + " - 0.10: Christmas Leave Discount";
    }
}

