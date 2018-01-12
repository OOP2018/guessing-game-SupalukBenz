import java.util.*;

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
        List<Integer> number = new ArrayList<Integer>();
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        int autoNumber = rand.nextInt( game.getUpperBound() ) + 1;
        System.out.println( game.toString() );
        System.out.println();
        Integer min = 1;
        Integer max = game.getUpperBound();
        while(true){
            System.out.println("Guess it. Your number is >> " + autoNumber);

            if(game.guess(autoNumber)){
                System.out.println(game.getMessage());
                break;
            }else {
                number.add(autoNumber);
                if(game.getMessage().startsWith("It's too small") || game.getMessage().startsWith("Too small")){
                    min = autoNumber;
                }else {
                    max = autoNumber;
                }

                autoNumber = rand.nextInt( max-min ) + min;
                System.out.println(game.getMessage());

            }

            System.out.println();
        }

        return autoNumber;
    }

}
