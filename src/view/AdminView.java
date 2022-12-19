package view;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.domain.MetroCard;

public class AdminView extends GridPane {
	private Stage stage = new Stage();
	private TableView<MetroCard> table;
	private ObservableList<MetroCard> metrocards;
		
	public AdminView(){
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(660);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 690, 680);
		BorderPane borderPane = new AdminMainPane();
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());



		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
