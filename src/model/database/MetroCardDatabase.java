package model.database;

import java.io.*;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.domain.MetroCard;

public abstract class MetroCardDatabase {
    TreeMap<String, MetroCard> database = new TreeMap<>();

    private static MetroCardDatabase metroCardDatabase;
    private MetroCardDatabase() {
        load();
    }

    public static MetroCardDatabase getInstance(){
        if (metroCardDatabase == null) {
            metroCardDatabase = new MetroCardDatabase() {
            };
        }
        return metroCardDatabase;
    }

    public TreeMap<String, MetroCard> getDatabase() {
        return database;
    }

    public void load() {
        try { this.database = metroCardDatabase.database;}
        catch (Exception e){ System.out.println(e.getMessage()); }
    }


    public void save(){
        try {
            FileWriter myWriter = new FileWriter("src/bestanden/metrocards.txt");
            for (MetroCard metroCard: database.values()) {
                myWriter.write(metroCard.getKaartID() + "," + metroCard.getMaandJaarAankoop()+ "," + metroCard.getBeschikbareRitten() + "," + metroCard.getBeschikbareRitten());                }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void reset() {
        load();
    }
}
