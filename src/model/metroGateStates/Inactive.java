package model.metroGateStates;

import model.domain.MetroGate;

public class Inactive extends MetroGateState {

    public Inactive(MetroGate metroGate) {
        super(metroGate);
    }

    @Override
    public void activateGate() {
        metroGate.setState(metroGate.getClosed());
    }

    @Override
    public String toString() {
        return "Inactive";
    }
}

