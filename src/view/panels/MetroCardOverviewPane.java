package view.panels;

import controller.AdminViewController;
import model.domain.MetroCard;
import java.util.Collection;

public class MetroCardOverviewPane extends OverviewPane<MetroCard>{
	public MetroCardOverviewPane (Collection<MetroCard> values) {
		super("MetroCard", values, new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
	}

	public MetroCardOverviewPane (AdminViewController adminViewController) {
		super("MetroCard", adminViewController.getMetroCardDatabase(), new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
	}
}