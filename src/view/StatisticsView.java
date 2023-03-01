package view;

import controller.ControllerStatistics;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import model.Game;

public class StatisticsView extends TilePane implements Observer {

    private Game game;
    private ControllerStatistics controllerStatistics;
    private Label label;
    public StatisticsView(Game game){
        this.game = game;
        this.controllerStatistics = new ControllerStatistics(game);
        this.label = new Label("Games played : "
                + this.game.getGamesPlayed()
                + "\n"
                + "Games won : "
                + this.game.getGamesWon());
        this.getChildren().add(this.label);
        this.game.addObserver(this);
    }


    @Override
    public void react() {
        this.label.setVisible(true);
        this.label.setText("Games played : "
                + this.game.getGamesPlayed()
                + "\n"
                + "Games won : "
                + this.game.getGamesWon());
    }
}
