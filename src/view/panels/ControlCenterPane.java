package view.panels;

import javafx.scene.control.Button;
import model.domain.MetroCard;

import java.util.Collection;

public class ControlCenterPane extends OverviewPane<MetroCard>{

    Button openMetroStation = new Button("Open Metro Station");

    public ControlCenterPane (Collection<MetroCard> values) {
        super("MetroCard", values, new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
    }

}
