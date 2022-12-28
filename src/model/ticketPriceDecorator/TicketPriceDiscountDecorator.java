package model.ticketPriceDecorator;

public abstract class TicketPriceDiscountDecorator extends TicketPrice{
    TicketPrice ticketPrice;

    public TicketPriceDiscountDecorator(TicketPrice ticketPrice) {
        super(ticketPrice.getIs24Min(), ticketPrice.getIs64Plus(), ticketPrice.getIsStudent(),ticketPrice.getFrequentTraveler());
        this.ticketPrice = ticketPrice;

    }
}
