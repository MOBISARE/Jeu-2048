package view;

import javafx.scene.layout.GridPane;
import model.Game;

public class PlateauView extends GridPane implements Observer {

    private Game game;

    public PlateauView(Game game) {
        this.game = game;

    }

    @Override
    public void react() {

    }
}
