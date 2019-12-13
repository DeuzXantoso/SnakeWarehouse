package id.ac.its.warehouse.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuBox {
	private VBox vBox;
	private String name;
	private Button newGButton;
	
	public MenuBox( String name) {
		this.name = name;
		loadMenuBox();
	}
	
	private void loadMenuBox() {
		vBox = new VBox();
		vBox.setStyle("-fx-background-color: black;");
		vBox.setAlignment(Pos.BOTTOM_CENTER);
		vBox.setPadding(new Insets(10, 10, 40, 10));
		vBox.setSpacing(9);
		
		Label welcomeLabel = new Label("WELCOME");
		welcomeLabel.setFont(Font.font("Stencil", 20));
		welcomeLabel.setTextFill(Color.GOLD);
		
		Label nameLabel = new Label(name);
		nameLabel.setFont(Font.font("Rockwell", 15));
		nameLabel.setTextFill(Color.GOLD);
		
		newGButton = new Button("New Game");
		newGButton.setFont(Font.font("Rockwell", 12));
		newGButton.setStyle("-fx-border-color: transparent;"
				+ "-fx-background-color:transparent;"
				+ "-fx-text-fill: white;");
		
		Button optionButton = new Button("Option");
		optionButton.setFont(Font.font("Rockwell", 12));
		optionButton.setStyle("-fx-border-color: transparent;"
				+ "-fx-background-color:transparent;"
				+ "-fx-text-fill: white;");
		
		vBox.getChildren().addAll(welcomeLabel, nameLabel, newGButton, optionButton);
	}
	
	public VBox getVBox() {
		return vBox;
	}
	
	public Button getNewGButton() {
		return newGButton;
	}
}
