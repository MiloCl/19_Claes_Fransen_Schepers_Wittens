package model.database.LoadSaveStrategies;

import java.io.File;

public enum LoadSaveStrategyEnum {

    EXCEL_METROCARDS ("Excel", "model.database.LoadSaveStrategies.MetrocardsExcellLoadSaveStrategy", new File("src/bestanden/metrocards.xls")),
    TEXT_METROCARDS ("Text", "model.database.LoadSaveStrategies.MetrocardsTekstLoadSaveStrategy", new File("src/bestanden/metrocards.txt"));


    private final String naam;
    private final String locatie;
    private final File file;

    LoadSaveStrategyEnum(String naam, String locatie,File file) {
        this.naam = naam;
        this.locatie = locatie;
        this.file = file;
    }

    public static LoadSaveStrategyEnum getEnumWithName(String naam) {
        for (LoadSaveStrategyEnum l : LoadSaveStrategyEnum.values()) {
            if (l.getNaam().equalsIgnoreCase(naam)) {
                System.out.println("StrategyEnum: " + l.getNaam());
                return l;
            }
        }
        return null;
    }

    public String getNaam() { return naam; }
    public String getLocatie() { return locatie; }
    public File getFile() { return file; }
}