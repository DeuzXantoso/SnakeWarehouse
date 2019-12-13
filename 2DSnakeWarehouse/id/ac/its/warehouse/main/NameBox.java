package id.ac.its.warehouse.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginBox {
	
	private GridPane gridPane;
	private TextField nameInput;
	private Button loginButton;
	
	public LoginBox() {
		loadLoginBox();
	}
	
	private void loadLoginBox() {
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(15, 10, 10, 13));
		gridPane.setVgap(8);
		gridPane.setHgap(7);
		gridPane.setStyle("-fx-background-color: black;");
		
		Label nameLabel = new Label("Username	:");
		nameLabel.setFont(Font.font("Rockwell", 12));
		nameLabel.setTextFill(Color.GOLD);
		GridPane.setConstraints(nameLabel, 0, 0);
		
		nameInput = new TextField();
		nameInput.setPromptText("String");
		nameInput.setFont(Font.font("Rockwell", 12));
		nameInput.setStyle("-fx-border-color: white;"
				+ "-fx-background-color:white;");
		GridPane.setConstraints(nameInput, 1, 0);
		
		loginButton = new Button("Log In");
		loginButton.setFont(Font.font("Rockwell", 12));
		loginButton.setStyle("-fx-border-color: transparent;"
				+ "-fx-background-color:gold;");
		GridPane.setConstraints(loginButton, 1, 1);
		
		
		gridPane.getChildren().addAll(nameLabel, nameInput, loginButton);
	}
	
	
	public TextField getNameInput() {
		return nameInput;
	}
	
	public Button getLoginButton() {
		return loginButton;
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
	
}
