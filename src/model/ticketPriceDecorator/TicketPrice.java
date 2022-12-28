package model.ticketPriceDecorator;

import model.domain.MetroCard;

public abstract class TicketPrice{
    boolean is24Min;
    boolean is64Plus;
    boolean isStudent;
    boolean frequentTraveler;

    public TicketPrice(boolean is24Min, boolean is64Plus, boolean isStudent, boolean frequentTraveler) {
        this.is24Min = is24Min;
        this.is64Plus = is64Plus;
        this.isStudent = isStudent;
        this.frequentTraveler = frequentTraveler;
    }

    public boolean getIs24Min(){
        return is24Min;
    }

    public boolean getIs64Plus(){
        return is64Plus;
    }

    public boolean getIsStudent(){
        return isStudent;
    }

    public boolean getFrequentTraveler(){return frequentTraveler;}

    public void setIs24Min (boolean is24Min){
        this.is24Min = is24Min;
    }

    public void setIs64Plus (boolean is64Plus){
        this.is64Plus = is64Plus;
    }

    public void setIsStudent (boolean isStudent){
        this.isStudent = isStudent;
    }

    public double getPrice(){
        return 2.1;
    }
    public String getPriceText(){
        return getPrice() + "€";
    }
}
