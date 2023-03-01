package view;

import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import model.Game;

public class StatisticsView extends TilePane implements Observer {

    private Game game;

    private Label label;
    public StatisticsView(Game game){
        this.game = game;
        this.label = new Label();

    }


    @Override
    public void react() {
        this.label.setText("Games played : " + "..." + "\n" + "Games won : " + "...");
    }
}
