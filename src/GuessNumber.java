/**
 * Control creating window and showing number of guessing
 * @author Supaluk Jaroensuk
 */
public class GuessNumber extends java.util.Observable {

    /**
     * Guess number
     */
    private int guess;

    /**
     * Initialize guess number equals to zero
     */
    public GuessNumber(){
        this.guess = 0;
    }

    /**
     * Update guess number
     * @param guess is number that user input
     */
    public void guessUpdate(int guess){
        this.guess = guess;
        setChanged();
        notifyObservers();
    }

    /**
     * Get guess number
     * @return guess number
     */
    public int getGuess(){
        return guess;
    }


}
