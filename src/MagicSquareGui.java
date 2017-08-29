import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MagicSquareGui extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		
		// all the text fieldss
		TextField tf00 = new TextField();
		TextField tf01 = new TextField();
		TextField tf02 = new TextField();
		TextField tf10 = new TextField();
		TextField tf11 = new TextField();
		TextField tf12 = new TextField();
		TextField tf20 = new TextField();
		TextField tf21 = new TextField();
		TextField tf22 = new TextField();
		
		
		// Add everything to the grid
		grid.add(tf00, 0, 0);
		grid.add(tf01, 1, 0);
		grid.add(tf02, 2, 0);
		grid.add(tf10, 0, 1);
		grid.add(tf11, 1, 1);
		grid.add(tf12, 2, 1);
		grid.add(tf20, 0, 2);
		grid.add(tf21, 1, 2);
		grid.add(tf22, 2, 2);
		
		
		Scene scene = new Scene(grid, 400, 400);
		primaryStage.setTitle("Magic Square");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}
