package model.ticketPriceDecorator;

public class StudentDiscount extends TicketPriceDiscountDecorator {
    double discount;
    double price;

    public StudentDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
        price = ticketPrice.getPrice();
        discount = TicketPriceDiscountEnum.getDiscountByName("Student Discount").getDiscount();
    }

    @Override
    public double getPrice() { return price - discount; }

    @Override
    public String getPriceText() {
        return price + " -0.25: Student Discount";
    }
}

