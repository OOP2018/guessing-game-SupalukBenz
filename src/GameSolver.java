import java.util.Random;

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

        long seed = System.nanoTime();
        Random rand = new Random(seed);
        int autoNumber = rand.nextInt( game.getUpperBound() ) + 1;
        System.out.println( game.toString() );
        System.out.println();
        int min = 1;
        int max = game.getUpperBound();
        while(true){
            if(game.guess(autoNumber)){
                break;
            }else {

                if(game.getMessage().contains("small")){
                    min = autoNumber;
                }else {
                    max = autoNumber;
                }

                autoNumber = rand.nextInt( max-min ) + min;
            }

        }

        return autoNumber;
    }


}
