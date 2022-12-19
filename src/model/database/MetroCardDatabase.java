package model.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.domain.MetroCard;

public abstract class MetroCardDatabase<K, V> {
    TreeMap<String, V> database = new TreeMap<>();

    protected MetroCardDatabase() {
        load();
    }

    public abstract void load();
    public abstract void save(TreeMap<K,V> map);

    public void setDatabase(TreeMap<String, V> database) {
        this.database = database;
    }
    public TreeMap<String, V> getDatabase() {
        return database;
    }
    public V getMetroCard(String name) {
        return database.get(name);
    }

    public HashMap<String, Integer> getBeschikbareRitten() {
        HashMap<String, Integer> ritten = new HashMap<>();
        for (V metroCard: getDatabase().values()) {
            ritten.put(((MetroCard) metroCard).getKaartID(), ((MetroCard) metroCard).getBeschikbareRitten());
        }
        return ritten;
    }

    public HashMap<String, Integer> getGebruikteRitten() {
        HashMap<String, Integer> ritten = new HashMap<>();
        for (V metrocard: getDatabase().values()) {
            ritten.put(((MetroCard) metrocard).getKaartID(), ((MetroCard) metrocard).getAantalVerbruikteRitten());
        }
        return ritten;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void reset() {
        load();
    }
}
