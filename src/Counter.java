/**
 * A class for count guessing
 * @author Supaluk Jaroensuk
 */
public class Counter extends java.util.Observable{

    /**
     * Number of count
     */
    private int count;


    /**
     * Initialize count equals to zero
     */
    public Counter(){
        count = 0;
    }

    /**
     * Update count number
     * @param c is number that increase from guessing
     */
    public void countGuessAdd(int c){
        count += c;
        setChanged();
        notifyObservers();
    }

    /**
     * Set count number
     * @param count is number for setting
     */
    public void setCount(int count){
        this.count = count;
    }



    /**
     * Get count number
     * @return number of count
     */
    public int getCount() {
        return count;
    }

}
