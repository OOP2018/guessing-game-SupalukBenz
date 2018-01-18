/**
 * A main class for the SupalukGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {

	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 1000000;
		NumberGame game = new SupalukGame(upperBound);
//		GameConsole ui = new GameConsole( );
		GameSolver ui = new GameSolver();
		int solution = ui.play( game );
		System.out.println("play() returned "+solution+ ". It's a secret number.");
        System.out.println("Your guess is " + game.getCount());
    }

}
