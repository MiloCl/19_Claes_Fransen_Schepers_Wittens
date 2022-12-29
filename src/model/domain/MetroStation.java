package model.domain;

import java.util.ArrayList;

public class MetroStation {

    public ArrayList<MetroGate> metroGates;

    public MetroStation() {
        metroGates = new ArrayList<MetroGate>();
        metroGates.add(new MetroGate(1));
        metroGates.add(new MetroGate(2));
        metroGates.add(new MetroGate(3));
    }

    public void scanMetroGate(int id) {
    }

    public void addMetroGate(int id) {
        metroGates.add(new MetroGate(id));
    }
}
