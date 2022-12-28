package model.database;

import model.Setup;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.MetroCard;

import java.io.*;
import java.util.*;

public class MetroCardDatabase {


    public TreeMap<String, MetroCard> metroCards = new TreeMap<>();
    private static MetroCardDatabase metroCardDatabase;
    public ArrayList<Integer> metrocardIDList = new ArrayList<>();

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

    public TreeMap<String, MetroCard> getMetroCards() {
        return metroCards;
    }

    public void load() {
        try {
            this.metroCards = LoadSaveStrategyFactory.createLoadSaveStrategy(Setup.getFileFormat()).load();
            System.out.println("database loaded");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addMetroCard(int kaartID, String maandJaarAankoop, int beschikbareRitten, int verbruikteRitten){
        metroCards.put(String.valueOf(kaartID), new MetroCard(kaartID, maandJaarAankoop, beschikbareRitten, verbruikteRitten));
    }

    public void save(){
        try {
            FileWriter myWriter = new FileWriter("src/bestanden/metrocards.txt");
            for (MetroCard metroCard: metroCards.values()) {
                myWriter.write(metroCard.getKaartID() + "," + metroCard.getMaandJaarAankoop()+ "," + metroCard.getBeschikbareRitten() + "," + metroCard.getAantalVerbruikteRitten());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setMetrocardIDList(){

        Set<String> set = metroCards.keySet();
        metrocardIDList.clear();
        for(String key: set){
            MetroCard metroCard = metroCards.get(key);
            metrocardIDList.add(metroCard.getKaartID());
        }

        System.out.println("MetroCardIdList is set");
    }

    public ArrayList<Integer> getMetrocardIDlist(){
        setMetrocardIDList();
        System.out.println("IDS: " + metrocardIDList);
        return metrocardIDList;
    }
}