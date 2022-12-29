package model.domain;

import model.metroGateStates.Closed;
import model.metroGateStates.Inactive;
import model.metroGateStates.MetroGateState;
import model.metroGateStates.Open;

public class MetroGate {

    int id;
    MetroGateState state;

    private MetroGateState open;
    private MetroGateState closed;
    private MetroGateState inactive;

    public MetroGateState getOpen() {
        return open;
    }

    public MetroGateState getClosed() {
        return closed;
    }

    public MetroGateState getInactive() {
        return inactive;
    }



    public MetroGate(int id) {
        this.id = id;
        open = new Open(this);
        closed = new Closed(this);
        inactive = new Inactive(this);
        setState(closed);
    }

    public void setState(MetroGateState state) {
        this.state = state;
    }





    public String getStateAsString() {
        System.out.println(this.state.toString());
        return this.state.toString();
    }

    public void scanCard() {
        state.scanMetroCard();
    }

    public int getGateID() {
        return this.id;
    }

    /*public String getState() {
        //return this.state;
    }

    public void deactivateGate() {
        this.state = "Inactive";
    }*/
}
