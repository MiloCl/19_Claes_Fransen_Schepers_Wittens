package model.ticketPriceDecorator;

public abstract class TicketPriceDiscountDecorator extends TicketPrice{
    protected TicketPrice basicTicketPrice;

    public TicketPriceDiscountDecorator(TicketPrice basicTicketPrice) {
        super(basicTicketPrice.getIs24Min(), basicTicketPrice.getIs64Plus(), basicTicketPrice.getIsStudent(),basicTicketPrice.getFrequentTraveler());
        this.basicTicketPrice = basicTicketPrice;
    }

    public double getPrice(){
        return basicTicketPrice.getPrice();
    };
}
