package id.ac.its.warehouse.main;

import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CloseBox {
	
	private Stage primaryStage;
	private Stage closeBoxStage;
	private GridPane confirmPane;
	private Scene closeBoxScene;
	
	public CloseBox (Stage primaryStage) {
		this.primaryStage = primaryStage;
		loadCloseBox();
	}
	
	private void loadCloseBox() {
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
	}
	
	private void closeProgram() {
		try {
			closeBoxStage = new Stage();
			closeBoxStage.setTitle("Close Program");
			closeBoxStage.setResizable(false);
			Image appIcon = new Image(new FileInputStream("C:\\eclipse_workspace\\GameWarehouse\\warning.png"));
			closeBoxStage.getIcons().add(appIcon);
			confirmPane = new GridPane();
			confirmPane.setPadding(new Insets(0, 0, 0, 0));
			confirmPane.setVgap(0);
			confirmPane.setHgap(8);
			confirmPane.setStyle("-fx-background-color: gold;");
			
			Image alert = new Image(new FileInputStream("C:\\eclipse_workspace\\GameWarehouse\\warning.png"));
			ImageView warning = new ImageView(alert);
			warning.setScaleX(0.5);
			warning.setScaleY(0.5);
			GridPane.setConstraints(warning, 0, 0);
			
			Label questionLabel = new Label("Are you sure to quit?");
			questionLabel.setStyle("-fx-text-fill: black;"
					+ "-fx-font-size: 12px;"
					+ "-fx-font-family: Rockwell;");
			GridPane.setConstraints(questionLabel, 1, 0, 2, 1);
			
			Button OKButton = new Button("OK");
			OKButton.setStyle("-fx-background-color: black;"
					+ "-fx-border-color: transparent;"
					+ "-fx-text-fill: gold;"
					+ "-fx-font-size: 12px;"
					+ "-fx-font-family: Rockwell;");
			OKButton.setOnAction(e -> {
				closeBoxStage.close();
				primaryStage.close();
			});
			GridPane.setConstraints(OKButton, 1, 1);
			
			Button cancelButton = new Button("Cancel");
			cancelButton.setStyle("-fx-background-color: black;"
					+ "-fx-border-color: transparent;"
					+ "-fx-text-fill: gold;"
					+ "-fx-font-size: 12px;"
					+ "-fx-font-family: Rockwell;");
			cancelButton.setOnAction(e -> closeBoxStage.close());
			GridPane.setConstraints(cancelButton, 2, 1);
			
			confirmPane.getChildren().addAll(warning, questionLabel, OKButton, cancelButton);
			
			closeBoxScene = new Scene(confirmPane, 240, 135);
			closeBoxStage.setScene(closeBoxScene);
			closeBoxStage.showAndWait();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
