

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LightUpShape extends Application {
	private final static int X_CORD = 150;
	private final static int Y_CORD = 150;
	private final static int WIDTH = 200;
	private final static int HEIGHT= 200;
	private Rectangle rectangle;
	public void start(Stage primaryStage) {
		
		Group group = new Group();
		
		rectangle = new Rectangle(X_CORD, Y_CORD, WIDTH, HEIGHT);
		rectangle.setFill(Color.TRANSPARENT);
		rectangle.setStroke(Color.TRANSPARENT);
		group.getChildren().add(rectangle);
		group.setOnMouseClicked(this::handleMouseClick);
		Scene scene = new Scene(group, 500, 500, javafx.scene.paint.Color.BISQUE);
		scene.setOnMouseMoved(this :: processMouse);
		primaryStage.setTitle("Light up A Shape");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handleMouseClick(MouseEvent event) {
		rectangle.setVisible(false);
	}
	
	public void processMouse(MouseEvent event) {
		int x = (int)event.getX();
		int y = (int)event.getY();
		if (x>=X_CORD &&  x <= WIDTH + X_CORD && y <= HEIGHT + Y_CORD  && y>=Y_CORD)
		{
			rectangle.setVisible(true);
			rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		}
		else
		{
			rectangle.setVisible(true);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setStroke(Color.BLACK);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
