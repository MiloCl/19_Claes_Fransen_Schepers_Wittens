package model.database.LoadSaveStrategies;

import java.io.File;

public enum LoadSaveStrategyEnum {

    EXCEL_METROCARDS ("Excel MetroCards", "model.database.LoadSaveStrategies.MetrocardsExcelLoadSaveSaveStrategy", new File("src/bestanden/metrocards.xls")),
    TEXT_METROCARDS ("Text MetroCards", "model.database.LoadSaveStrategies.MetrocardsTextLoadSaveStrategy", new File("src/bestanden/metrocards.txt"));


    private final String naam;
    private final String locatie;
    private final File file;

    LoadSaveStrategyEnum(String naam, String locatie,File file) {
        this.naam = naam;
        this.locatie = locatie;
        this.file = file;
    }

    public String getNaam() { return naam; }
    public String getLocatie() { return locatie; }
    public File getFile() { return file; }
}