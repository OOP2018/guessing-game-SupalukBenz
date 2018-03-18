import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Observable;

/**
 * Control creating window and showing number of counting
 * @author Supaluk Jaroensuk
 */
public class CounterView implements java.util.Observer{

    /** the stage (top-level window) for showing scene */
    private Stage stage;

    /** a counter to show value of count */
    private Counter counter;

    /** the label that shows the counter value. */
    private Label label;

    /**
     * Initialize showing number of counting
     * @param counter is the counter to show
     */
    public CounterView(Counter counter){
        this.counter = counter;
        initComponents();
    }

    /**
     * Initialize window
     */
    private void initComponents() {
        stage = new Stage();
        HBox root = new HBox();
        root.setAlignment(Pos.BOTTOM_LEFT);

        label = new Label("");
        label.setPrefWidth(300);
        label.setFont(new Font("Arial" , 100.0));
        label.setAlignment(Pos.CENTER);

        root.getChildren().add(label);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Count Guessing");
        stage.sizeToScene();
    }

    /**
     * Show the window and update count number
     */
    public void run(){
        stage.show();
        show();
    }

    /**
     * Set number that show at window
     */
    public void show(){
        label.setText(String.format("%2d" , counter.getCount()));
    }

    @Override
    public void update(Observable o, Object arg) {
        show();
    }
}
