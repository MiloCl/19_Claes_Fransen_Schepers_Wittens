package model.ticketPriceDecorator;

public enum TicketPriceDiscountEnum {
    //All possible discounts
    AGE_64_PLUS_DISCOUNT("Age 64+ Discount", 0.15),
    CHRISTMAS_LEAVE_DISCOUNT("Christmas Leave Discount", 0.10),
    STUDENT_DISCOUNT("Student Discount", 0.25),
    FREQUENT_TRAVELER_DISCOUNT("Frequent Traveler Discount", 0.20);

    private String name;
    private double discount;

    TicketPriceDiscountEnum(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

}
