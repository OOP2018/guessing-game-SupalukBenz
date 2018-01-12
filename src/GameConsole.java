import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/**
	 *  The play method is method for input guess number from user
	 *	and run loop game with print message until user will win.
	 * @param  game is NumberGame class
	 * @return correct answer
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		// describe the game
		System.out.println( game.toString() );
		System.out.println();
		// This is just an example.

		int guess = 0;
		while(true){

			System.out.print("Guess it. Your number is >> ");
			guess = console.nextInt();

			if(game.guess(guess)) {
				System.out.println(game.getMessage());
				break;
			}else {
				System.out.println(game.getMessage());
			}
			System.out.println();
		}
		return guess;
	}
	
}
