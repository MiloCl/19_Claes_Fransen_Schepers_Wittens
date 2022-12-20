package model.database.LoadSaveStrategies;

import model.database.LoadSaveStrategies.ExcellLoadSaveTemplate;
import model.domain.MetroCard;

import java.util.ArrayList;
import java.util.TreeMap;

public class MetrocardsExcellLoadSaveStrategy extends ExcellLoadSaveTemplate<String, MetroCard> implements LoadSaveStrategy {

    public MetrocardsExcellLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    @Override
    public MetroCard makeObject(ArrayList<String> tokens) {
        return new MetroCard(Integer.parseInt(tokens.get(0)),tokens.get(1),Integer.parseInt(tokens.get(2)),Integer.parseInt(tokens.get(3)));
    }

    @Override
    public String getKey(ArrayList<String> tokens) {
        return tokens.get(0);
    }

    @Override
    public TreeMap<String, MetroCard> load() {
        try {
            return super.load();
        }catch (Exception ignored){ }
        return null;
    }

    @Override
    public void save() {

    }
}