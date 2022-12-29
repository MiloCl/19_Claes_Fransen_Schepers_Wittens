package model.metroGateStates;

import model.domain.MetroGate;

public abstract class MetroGateState {
    
    MetroGate metroGate;
    
    public MetroGateState(MetroGate metroGate) {
        this.metroGate = metroGate;
    }
    
    public void activateGate() {
        throw new IllegalStateException("Invalid action for current state");
    }
    
    public void deactivateGate() {
        throw new IllegalStateException("Invalid action for current state");
    }
    
    public void walkThroughGate() {
        throw new IllegalStateException("Invalid action for current state");
    }
    
    public void scanMetroCard() {
        throw new IllegalStateException("Invalid action for current state");
    }
    
}
