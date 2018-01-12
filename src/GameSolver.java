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
        while(true){
            System.out.println("Guess it. Your number is >> " + autoNumber);

            if(game.guess(autoNumber)){
                System.out.println(game.getMessage());
                break;
            }else {
                System.out.println(game.getMessage());
                autoNumber = rand.nextInt( game.getUpperBound() ) + 1;
            }

            System.out.println();
        }

        return autoNumber;
    }

}
