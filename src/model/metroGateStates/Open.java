package model.metroGateStates;

import model.domain.MetroGate;

public class Open extends MetroGateState {


    public Open(MetroGate metroGate) {
        super(metroGate);
    }
    
    @Override
    public void walkThroughGate() {
        metroGate.setState(metroGate.getClosed());
    }
}

