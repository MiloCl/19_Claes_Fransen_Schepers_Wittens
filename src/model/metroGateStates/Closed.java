package model.metroGateStates;

import model.domain.MetroGate;

public class Closed extends MetroGateState {

    public Closed(MetroGate metroGate) {
        super(metroGate);
    }

    @Override
    public void scanMetroCard() {
        metroGate.setState(metroGate.getOpen());
    }

    @Override
    public void deactivateGate() {
        metroGate.setState(metroGate.getInactive());
    }
}

