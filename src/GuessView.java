import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

/**
 * Control creating window and showing number of guessing
 * @author Supaluk Jaroensuk
 */
public class GuessView implements java.util.Observer{
    /** the stage (top-level window) for showing scene */
    private Stage stage;

    /** a counter to show value of guess*/
    private GuessNumber guessNumber;

    /** the label that shows the guess number. */
    private Label label;

    /**
     * Initialize showing number of guessing
     * @param guessNumber is the counter to show
     */
    public GuessView(GuessNumber guessNumber){
        this.guessNumber = guessNumber;
        initComponents();
    }

    /**
     * Initialize window
     */
    private void initComponents() {
        stage = new Stage();
        HBox root = new HBox();
        root.setAlignment(Pos.BOTTOM_RIGHT);

        label = new Label("");
        label.setPrefWidth(300);
        label.setFont(new Font("Arial" , 100.0));
        label.setAlignment(Pos.CENTER);

        root.getChildren().add(label);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Guess number");
        stage.sizeToScene();
    }

    /**
     * Show the window and update guess number
     */
    public void run(){
        stage.show();
        show();
    }

    /**
     * Set number that show at window
     */
    public void show(){
        label.setText(String.format("%2d" , guessNumber.getGuess()));
    }

    @Override
    public void update(Observable o, Object arg) {
        show();
    }
}
