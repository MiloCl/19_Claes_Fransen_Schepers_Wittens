package model.ticketPriceDecorator;

public class Age64PlusDiscount extends TicketPriceDiscountDecorator {
    double discount;
    double price;

    public Age64PlusDiscount(TicketPrice ticketPrice) {

        super(ticketPrice);
        price = ticketPrice.getPrice();
        discount = TicketPriceDiscountEnum.getDiscountByName("Age 64+ Discount").getDiscount();
    }

    @Override
    public double getPrice() { return price - discount; }

    @Override
    public String getPriceText() { return price + " - 0.15: 64+ Discount"; }
}

