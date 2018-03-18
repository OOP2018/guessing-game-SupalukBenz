import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller for counter guessing
 * @author Supaluk Jaroensuk
 */
public class GameController {

    /**
     * Guess button
     */
    @FXML
    Button guessButton;

    /**
     * Guess number that user input
     */
    @FXML
    TextField guessNum;

    /**
     * ComboBox for choosing upper bound number
     */
    @FXML
    ComboBox<Integer> upperBoundNum;

    /**
     * Message is showed at window
     */
    @FXML
    TextField message;

    /**
     * Upper bound number
     */
    private int upperNumber;

    /**
     * Guess number
     */
    private int guessNumber;

    /**
     * Counter class
     */
    private Counter counter;

    /**
     * GuessNumber class
     */
    private GuessNumber guess;

    /**
     * NumberGame class
     */
    private NumberGame game;

    /**
     * Initialize ComboBox and set upper bound number
     */
    @FXML
    public void initialize(){

        System.out.println("Running Initialize");
        List<Integer> upper = new ArrayList<>();
        upper.add(99);
        upper.add(199);
        upper.add(499);
        upper.add(999);
        upper.add(1999);
        upperBoundNum.getItems().addAll(upper);
        upperBoundNum.getSelectionModel().select(0);
        this.upperNumber = upperBoundNum.getValue();
        this.game = new SupalukGame(upperNumber);

    }

    /**
     * Set upper bound number
     */
    public void setUpperBound(){
        counter.setCount(0);
        guess.guessUpdate(0);
        this.upperNumber = upperBoundNum.getValue();
        this.game = new SupalukGame(upperNumber);
    }

    /**
     * Action on guess button for playing at window
     */
    public void handleGuess(){
        if(guessNum.getLength() != 0){
            String guessStr = guessNum.getText().trim();
            this.guessNumber = Integer.parseInt(guessStr);

            if(game.guess(guessNumber)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("YOU WIN");
                alert.setHeaderText("Message");
                alert.setContentText("Do you want to play again?");

                ButtonType buttonTypePlay = new ButtonType("Play again");
                ButtonType buttonTypeExit = new ButtonType("Exit");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypePlay){

                } else if (result.get() == buttonTypeExit){
                    System.exit(1);
                }

            }else {
                message.setText(game.getMessage());
            }


        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("Please, Input number.");

            alert.showAndWait();
        }
        counter.countGuessAdd(1);
        guess.guessUpdate(guessNumber);
    }

    /**
     * Set Counter class
     * @param c is Counter class for setting
     */
    public void setCount(Counter c){
        this.counter = c;
    }

    /**
     * Set GuessNumber class
     * @param g is GuessNumber class for setting
     */
    public void setGuess(GuessNumber g){
        this.guess = g;
    }


}
