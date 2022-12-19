package model.domain;

import java.util.Objects;

public class MetroCard {
    private String kaartID;
    private String maandJaarAankoop;
    private int beschikbareRitten;
    private int aantalVerbruikteRitten;

    public MetroCard(String kaartID, String maandJaarAankoop, int beschikbareRitten, int aantalVerbruikteRitten) {
        setKaartID(kaartID);
        setMaandJaarAankoop(maandJaarAankoop);
        setBeschikbareRitten(beschikbareRitten);
        setAantalVerbruikteRitten(aantalVerbruikteRitten);
    }

    public void setKaartID(String kaartID) {
        this.kaartID = kaartID;
    }

    public void setMaandJaarAankoop(String maandJaarAankoop) {
        this.maandJaarAankoop = maandJaarAankoop;
    }


    public void setBeschikbareRitten(int beschikbareRitten) {
        this.beschikbareRitten = beschikbareRitten;
    }

    public void setAantalVerbruikteRitten(int aantalVerbruikteRitten) {
        this.aantalVerbruikteRitten = aantalVerbruikteRitten;
    }

    public String getKaartID() {
        return kaartID;
    }

    public String getMaandJaarAankoop() {
        return maandJaarAankoop;
    }


    public int getAantalVerbruikteRitten() {
        return aantalVerbruikteRitten;
    }

    public int getBeschikbareRitten() {
        return beschikbareRitten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetroCard)) return false;
        MetroCard metroCard = (MetroCard) o;
        return getMaandJaarAankoop() == metroCard.getMaandJaarAankoop() &&
                getBeschikbareRitten() == metroCard.getBeschikbareRitten() &&
                getAantalVerbruikteRitten() == metroCard.getAantalVerbruikteRitten() &&
                Objects.equals(getKaartID(), metroCard.getKaartID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKaartID(), getMaandJaarAankoop(), getBeschikbareRitten(), getAantalVerbruikteRitten());
    }

    @Override
    public String toString() {
        return "MetroCard{" +
                "kaartID=" + kaartID +
                '}';
    }
}

