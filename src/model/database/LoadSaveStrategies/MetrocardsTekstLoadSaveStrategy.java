package model.database.LoadSaveStrategies;

import model.domain.MetroCard;

import java.util.TreeMap;

public class MetrocardsTekstLoadSaveStrategy extends TekstLoadSaveTemplate<String, MetroCard> implements LoadSaveStrategy {

    public MetrocardsTekstLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    @Override
    public MetroCard maakObject(String[] tokens) {
        return new MetroCard(Integer.parseInt(tokens[0]), (tokens[1]), Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));
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

    @Override
    public void save() {

    }
}