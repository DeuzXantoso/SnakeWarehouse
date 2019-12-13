package id.ac.its.warehouse.main;


import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainBox {
	private BorderPane borderPane;
	private VBox rightPane;
	private VBox leftPane;
	private HBox topPane;
	private StackPane centerPane;

	private GameLoop loop;
    private Grid grid;
    private GraphicsContext context;
	
	private Button backButton;
	
	public MainBox(){
		loadMainBox();
	}
	
	private void loadMainBox(){
		//TopPane
		topPane = new HBox();
		topPane.setStyle("-fx-background-color: black;");
		topPane.setAlignment(Pos.CENTER);
		
		Label gameLabel = new Label("OMAE WA MOU SINDEIRU");
		gameLabel.setFont(Font.font("Stencil", 20));
		gameLabel.setTextFill(Color.GOLD);
		
		topPane.getChildren().add(gameLabel);
		
		//LeftPane
		leftPane = new VBox();
		leftPane.setStyle("-fx-background-color: black;");
		
		//RightPane
		rightPane = new VBox();
		rightPane.setStyle("-fx-background-color: gray;");
		
		Button backButton = new Button("Back");
		backButton.setFont(Font.font("Rockwell", 12));
		backButton.setStyle("-fx-border-color: transparent;"
				+ "-fx-background-color:gold;");
		
		rightPane.getChildren().add(backButton);
		
		//CenterPane
		centerPane = new StackPane();
        Canvas canvas = new Canvas(500, 500);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            Snake snake = grid.getSnake();
            if (loop.isKeyPressed()) {
                return;
            }
            switch (e.getCode()) {
                case UP:
                    snake.setUp();
                    break;
                case DOWN:
                    snake.setDown();
                    break;
                case LEFT:
                    snake.setLeft();
                    break;
                case RIGHT:
                    snake.setRight();
                    break;
                case ENTER:
                    if (loop.isPaused()) {
                        reset();
                        (new Thread(loop)).start();
                    }
            }
        });

        reset();

        centerPane.getChildren().add(canvas);
        (new Thread(loop)).start();
	    		
		
		//BorderPane
		borderPane = new BorderPane();
		
		borderPane.setTop(topPane);
		//borderPane.setRight(rightPane);
		//borderPane.setLeft(leftPane);
		borderPane.setCenter(centerPane);
		
	}
	
	 private void reset() {
	        grid = new Grid(500, 500);
	        loop = new GameLoop(grid, context);
	        Painter.paint(grid, context);
	    }
	
	public BorderPane getBorderPane() {
		return borderPane;
	}
	
	public Button getBackButton() {
		return backButton;
	}
}
