package view.panels;

import model.domain.MetroCard;
import java.util.Collection;

public class PaneTest extends MetroCardOverviewPane<MetroCard>{
    public PaneTest (Collection<MetroCard> values) {
        super("Sandwich", values, new String[]{"name", "price", "stock"});
    }
}