package model.ticketPriceDecorator;

public class FrequentTravellerDiscount extends TicketPriceDiscountDecorator {

    double discount;
    double price;

    public FrequentTravellerDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
        price = ticketPrice.getPrice();
        discount = TicketPriceDiscountEnum.getDiscountByName("Frequent Traveller Discount").getDiscount();
    }

    @Override
    public double getPrice() { return price - discount; }

    @Override
    public String getPriceText() {
        return price + " - 0.20:  Frequent Traveller Discount";
    }
}
