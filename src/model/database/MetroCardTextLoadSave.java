package model.database;

import model.domain.MetroCard;

import java.util.TreeMap;

public abstract class MetroCardTextLoadSave extends TextLoadSaveTemplate<String, MetroCard>{


    @Override
    MetroCard maakObject(String[] tokens) {
        return null;
    }

    @Override
    public String getKey(String[] tokens) {
        return tokens[0];
    }

    @Override
    public TreeMap<String, MetroCard> load() {
        try { return super.load();
        }catch (Exception ignored){ }
        return null;
    }

    public void save() {

    }
}