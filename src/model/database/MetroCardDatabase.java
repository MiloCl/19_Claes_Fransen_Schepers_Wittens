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
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addMetroCard(int kaartID, String maandJaarAankoop, int beschikbareRitten, int verbruikteRitten){
        metroCards.put(String.valueOf(kaartID), new MetroCard(kaartID, maandJaarAankoop, beschikbareRitten, verbruikteRitten));
    }

    /*public void save(){
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
    }*/

    public void save() {
        try {
           LoadSaveStrategyFactory.createLoadSaveStrategy(Setup.getFileFormat()).save();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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
        return metrocardIDList;
    }

    public void newMetroCard() {
        int kaartID = metroCards.size() + 1;
        String maandJaarAankoop = "01-2021";
        int beschikbareRitten = 10;
        int verbruikteRitten = 0;
        addMetroCard(kaartID, maandJaarAankoop, beschikbareRitten, verbruikteRitten);
    }

    public MetroCard getMetroCard(int kaartID){
        return metroCards.get(String.valueOf(kaartID));
    }

    public void addRides(Integer id, int rides) {
        MetroCard metroCard = metroCards.get(String.valueOf(id));
        metroCard.setBeschikbareRitten(metroCard.getBeschikbareRitten() + rides);
    }
}