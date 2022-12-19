package model.database;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.MetroCard;

import java.io.*;
import java.util.*;

public class MetroCardDatabase {


    TreeMap<String, MetroCard> metrosorts = new TreeMap<>();

    private static MetroCardDatabase metroCardDatabase;
    private MetroCardDatabase(){
        load();
    }
    /** Singleton design pattern */
    public static MetroCardDatabase getInstance(){
        if (metroCardDatabase == null) {
            metroCardDatabase = new MetroCardDatabase();
        }
        return metroCardDatabase;
    }

    public TreeMap<String, MetroCard> getMetrosorts() {
        return metrosorts;
    }

    public void load() {
        try { this.metrosorts = LoadSaveStrategyFactory.createLoadSaveStrategy(LoadSaveStrategyEnum.EXCEL_METROCARDS).load();}
        catch (Exception e){ System.out.println(e.getMessage()); }
    }

    public void save(){
        try {
            FileWriter myWriter = new FileWriter("src/bestanden/metrocards.txt");
            for (MetroCard metroCard: metrosorts.values()) {
                myWriter.write(metroCard.getKaartID() + "," + metroCard.getMaandJaarAankoop()+ "," + metroCard.getBeschikbareRitten() + "," + metroCard.getAantalVerbruikteRitten());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}