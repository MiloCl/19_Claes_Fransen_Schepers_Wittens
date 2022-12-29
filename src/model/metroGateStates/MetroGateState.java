package model.metroGateStates;

import model.domain.MetroGate;

public abstract class MetroGateState {
    
    MetroGate metroGate;
    
    public MetroGateState(MetroGate metroGate) {
        this.metroGate = metroGate;
    }
    
    public void activateGate() {
        throw new IllegalStateException("Deze actie is niet geldig in de staat waarin de gate zich bevindt.");
    }
    
    public void deactivateGate() {
        throw new IllegalStateException("Deze actie is niet geldig in de staat waarin de gate zich bevindt.");
    }
    
    public void walkThroughGate() {
        throw new IllegalStateException("Deze actie is niet geldig in de staat waarin de gate zich bevindt.");
    }
    
    public void scanMetroCard() {
        throw new IllegalStateException("Deze actie is niet geldig in de staat waarin de gate zich bevindt.");
    }
    
}
