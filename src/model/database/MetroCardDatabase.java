package model.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.domain.MetroCard;

public abstract class MetroCardDatabase<K, V> {

    // list to store metro card data
    private List<model.domain.MetroCard> metroCards;

    // constructor
    public MetroCardDatabase() {
        metroCards = new ArrayList<>();
    }

    // method to load data from text file
    public void load() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("metrocards.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String maandJaar = data[1];
                int beschikbaar = Integer.parseInt(data[2]);
                int gebruikt = Integer.parseInt(data[3]);
                metroCards.add(new MetroCard(id, maandJaar, beschikbaar, gebruikt));
            }
        }
    }

    // method to save data to text file
    public void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("metrocards.txt"))) {
            for (MetroCard mc : metroCards) {
                bw.write(mc.getKaartID() + "," + mc.getMaandJaarAankoop() + "," + mc.getBeschikbareRitten() + "," + mc.getAantalVerbruikteRitten());
                bw.newLine();
            }
        }
    }

    // method to display metro card data in table view
    public void displayInTableView(TableView<ObservableList<String>> tableView) {
        // clear existing data
        tableView.getColumns().clear();
        tableView.getItems().clear();

        // sort metro cards by id
        Collections.sort(metroCards, (mc1, mc2) -> mc1.getKaartID() - mc2.getKaartID());

        // create observable list to hold metro card data
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        // create table columns
        String[] columnNames = {"MetroCard ID", "Month#Year of Purchase", "Available Tickets","Used Tickets"};}
    public List<MetroCard> getDatabase() {
        return metroCards;
    }
}
