package view.panels;

import controller.AdminOverviewViewController;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import view.panels.OverviewPane;

/*
package view.panels;

import controller.AdminOverviewViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.database.MetroCardDatabase;
import model.domain.MetroCard;
import java.util.Collection;

public class MetroCardOverviewPane extends OverviewPane<MetroCard>{
	public MetroCardOverviewPane (Collection<MetroCard> values) {
		super("MetroCard", values, new String[]{"kaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"});
	}

}*/

public class MetroCardOverviewPane extends GridPane {
	public static TableView metroCardTable;

	public MetroCardOverviewPane(AdminOverviewViewController adminOverviewViewController) {
		metroCardTable = new TableView();
		OverviewPane.refresh(adminOverviewViewController.getMetroCardDatabase(),metroCardTable);
		OverviewPane.setEqualColumns(new String[]{"KaartID", "maandJaarAankoop", "aantalVerbruikteRitten", "beschikbareRitten"}, metroCardTable);
		metroCardTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		//css
		this.setPadding(new Insets(5, 5, 10, 30));
		this.setVgap(5);
		this.setHgap(5);
		metroCardTable.setEffect(new DropShadow(10, Color.BLACK));
		metroCardTable.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
		// add to main
		this.add(metroCardTable, 0, 1, 1, 1);
	}


/*	public void update(MetroCardDatabase metroCardDatabase, MetroCard metroCard, int orderCount, boolean orderIsInspected, HashMap<OrderLine, Integer> peek, int followNr) {
		System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
		adminView.update();
	}*/
}
