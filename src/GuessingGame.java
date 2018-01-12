import java.util.Random;
/**
 * GuessingGame class is class for set secret number
 * and set a message to show the user
 * @author Supaluk Jaroensuk
 */
public class GuessingGame extends NumberGame{

    private int secret;
    private int upperBound;

    /**
     * Initialize a game by set secret number
     * @param upperBound is maximum number in guessing game.
     */
    GuessingGame(int upperBound){
        this.upperBound = upperBound;
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        this.secret = rand.nextInt(upperBound) + 1;
        super.setMessage("Guessing game! Number between 1 and " + upperBound + " ,Let's Play!!");
    }

    /**
     * Guess class for
     * @param number is input number from user
     * @return true for correct secret number and false for incorrect secret number
     */
    @Override
    public boolean guess(int number) {
        if (number == secret) {
            setMessage("You win! Answer is " + secret);
            return true;
        }else if(number > upperBound || number <= 0){
            setMessage("Incorrect number. Your guess number should between 1 and " + upperBound);
        }else if(number < secret - 20){
            setMessage("It's too small!! Try again.");
        }else if(number > secret + 20){
            setMessage("It's too large!! Try again.");
        }else if(number < secret){
            setMessage("Too small but nearly!!");
        }else if(number > secret) {
            setMessage("Too large but nearly!!");
        }
        return false;
    }
    @Override
    public int getUpperBound(){
        return upperBound;
    }

    public String toString(){
        return "This is Guessing game. Let's guess secret number between 1 and " + getUpperBound();
    }

}
