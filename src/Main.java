import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * A main class for the SupalukGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 *
 * @author Supaluk Jaroensuk
 */
public class Main extends Application{

	/**
	 * Launch a standalone application
	 * @param args is the command line arguments passed to the application
	 */
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
//		int upperBound = 1000000;
//		NumberGame game = new SupalukGame(upperBound);
//		GameConsole ui = new GameConsole( );
//		GameSolver ui = new GameSolver();
//		int solution = ui.play( game );
//		System.out.println("play() returned "+solution+ ". It's a secret number.");
//        System.out.println("Your guess is " + game.getCount());

		launch(args);

    }

	/**
	 /**
	 * The application initialization method
	 * @param stage is the primary stage for this application
	 */
	@Override
	public void start(Stage stage) {
		Counter counter = new Counter();
		GuessNumber guessNumber = new GuessNumber();
		try {
			URL url = getClass().getResource("GuessUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);

			Parent root = loader.load();
			GameController gameController = loader.getController();
			gameController.setGuess(guessNumber);
			gameController.setCount(counter);

			Scene scene = new Scene(root);
			stage.setTitle("Guessing Game");
			stage.setScene(scene);
			stage.sizeToScene();
			stage.show();


		}catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}

		GuessView guessView = new GuessView(guessNumber);
		guessNumber.addObserver(guessView);

		GuessView guessView1 = new GuessView(guessNumber);
		guessNumber.addObserver(guessView1);
		guessView1.run();


		CounterView view = new CounterView(counter);
		counter.addObserver(view);

		CounterView view1 = new CounterView(counter);
		counter.addObserver(view1);

		view1.run();


	}
}
