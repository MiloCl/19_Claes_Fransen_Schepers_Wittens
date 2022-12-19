package view.panels;

import model.domain.MetroCard;
import java.util.Collection;

public class MetroCardOverviewPane extends OverviewPane<MetroCard>{
	public MetroCardOverviewPane (Collection<MetroCard> values) {
		super("MetroCard", values, new String[]{"KaartID", "Gekocht", "Ritten over", "Verbruikte ritten"});
	}
}