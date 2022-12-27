
package model.database.LoadSaveStrategies;

public class LoadSaveStrategyFactory<K,V> {

    public static LoadSaveStrategy createLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum){
        String klasseNaam = loadSaveStrategyEnum.getLocatie();
        LoadSaveStrategy fileInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.getConstructor(LoadSaveStrategyEnum.class).newInstance(loadSaveStrategyEnum);
            fileInterface  = (LoadSaveStrategy) dbObject;
        }
        catch (Exception ignored){}
        return fileInterface;
    }

    public static LoadSaveStrategy createLoadSaveStrategy(String naam){
        LoadSaveStrategy fileInterface = null;
        try{
            Class dbClass = Class.forName(LoadSaveStrategyEnum.getEnumWithName(naam).getLocatie());
            Object dbObject = dbClass.getConstructor(LoadSaveStrategyEnum.class).newInstance(LoadSaveStrategyEnum.getEnumWithName(naam));
            fileInterface  = (LoadSaveStrategy) dbObject;
        }
        catch (Exception ignored){}
        return fileInterface;
    }

}