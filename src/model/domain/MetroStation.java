package model.domain;

import java.util.ArrayList;
import java.util.List;

public class MetroStation {
    private List<MetroCard> data;
    public MetroStation() {
        data = new ArrayList<MetroCard>();
        data.add(new MetroCard("It's a Wonderful Life", "1946", 14, 15));
        data.add(new MetroCard("Young Frankenstein", "1974", 16,95));
        data.add(new MetroCard("Star Wars Episode 4", "1976", 17,95));

    }
    public List<MetroCard> getMovies()     {
        return data;
    }
}
