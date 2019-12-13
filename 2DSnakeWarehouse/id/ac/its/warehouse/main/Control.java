package id.ac.its.warehouse.main;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Control extends Application {

	private LoginBox loginBox;
	private MenuBox menuBox;
	private MainBox mainBox;
	
	private Scene loginBoxScene;
	private Scene menuBoxScene;
	private Scene mainBoxScene;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Game Warehouse");
			primaryStage.setResizable(false);
			Image appIcon = new Image(new FileInputStream("C:\\eclipse_workspace\\GameWarehouse\\visualgameboy.png"));
			primaryStage.getIcons().add(appIcon);
			
			CloseBox closeBox = new CloseBox(primaryStage);

			loginBox = new LoginBox();
			loginBox.getLoginButton().setOnAction(e -> primaryStage.setScene(menuBoxScene));
			
			menuBox = new MenuBox(loginBox.getNameInput().getText());
			menuBox.getNewGButton().setOnAction(e -> primaryStage.setScene(mainBoxScene));
			
			mainBox = new MainBox();
	//		mainBox.getBackButton().setOnAction(e -> primaryStage.setScene(menuBoxScene));
			
			loginBoxScene = new Scene(loginBox.getGridPane(), 265, 88);
			menuBoxScene = new Scene(menuBox.getVBox(), 200, 200);
			mainBoxScene = new Scene(mainBox.getBorderPane(), 500, 526);
			
			
			
			
			primaryStage.setScene(loginBoxScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
