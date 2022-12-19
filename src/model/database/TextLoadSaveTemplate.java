package model.database;
import model.domain.MetroCard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class TextLoadSaveTemplate <K,V>{

    protected TreeMap<K,V> load() throws IOException {
        TreeMap<K,V> returnMap = new TreeMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/bestanden/metrocards.txt")))) {
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(",");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    abstract V maakObject(String[] tokens);

    abstract K getKey(String[] tokens);

    public abstract TreeMap<String, MetroCard> load(File file);
}