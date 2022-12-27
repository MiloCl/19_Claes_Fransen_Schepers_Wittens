package view.panels;

import controller.AdminOverviewViewController;
import model.domain.MetroCard;
import java.util.Collection;

public class MetroCardOverviewPane extends OverviewPane<MetroCard>{
	public MetroCardOverviewPane (Collection<MetroCard> values) {
		super("MetroCard", values, new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
	}

	public MetroCardOverviewPane (AdminOverviewViewController adminOverviewViewController) {
		super("MetroCard", adminOverviewViewController.getMetroCardDatabase(), new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
	}

	public void refresh(Collection<MetroCard> values) {
		super.refresh(values);
	}
}