package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Game;

public class PlateauView extends GridPane implements Observer {

    private Game game;

    private Button[][] grid;

    public PlateauView(Game game) {
        this.game = game;
        this.setAlignment(Pos.CENTER);
        this.grid = new Button[this.game.getSize()][this.game.getSize()];
        this.game.addObserver(this);
        this.init();

    }

    private void init() {

        for (int i = 0 ; i < this.grid.length ; i++) {
            for (int j = 0 ; j < this.grid.length ; j++) {
                Button button = new Button();
                button.setText(this.game.getCase(i, j));
                this.grid[i][j] = button;
                this.add(button, i, j);
            }
        }
    }

    @Override
    public void react() {

    }
}
