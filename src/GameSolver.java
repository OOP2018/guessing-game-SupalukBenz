/**
 * Automatically play guessing game until find correct secret number
 * @author Supaluk Jaroensuk
 */
public class GameSolver {
    /**
     * Play automatically game and print message
     * @param game is NumberGame class
     * @return correct number
     */
    public int play(NumberGame game){

        System.out.println( game.toString() );
        System.out.println();
        int min = 1;
        int max = game.getUpperBound();
        int guess = min + (max - min)/2;
        while(true){
            if(game.guess(guess)){
                break;
            }else {

                if(game.getMessage().contains("small")){
                    min = guess;
                }else {
                    max = guess;
                }

                guess = min + (max - min)/2;

            }

        }

        return guess;
    }


}
