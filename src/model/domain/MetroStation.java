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

    public MetroGate getMetroGate(int id) {
        return metroGates.get(id);
    }



    public void scanCard(int gateID, Integer cardID) {
        MetroGate metroGate = metroGates.get(gateID - 1);
        metroGate.scanCard();
    }

    public ArrayList<MetroGate> getMetroGates() {
        return metroGates;
    }

    public void closeGate(int gateID) {
        MetroGate metroGate = metroGates.get(gateID - 1);
        metroGate.walkThroughGate();
    }

    public void activateGate(int gateID) {
        MetroGate metroGate = metroGates.get(gateID - 1);
        metroGate.activateGate();
    }

    public void deactivateGate(int gateID) {
        MetroGate metroGate = metroGates.get(gateID - 1);
        metroGate.deactivateGate();
    }
}
