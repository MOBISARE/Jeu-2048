package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Game;

import java.util.ArrayList;
import java.util.List;

public class PlateauView extends GridPane implements Observer {

    private Game game;

    private int lines;

    private int columns;
    //private Button[][] grid;

    private ArrayList<ArrayList<Button>> matrice;

    public PlateauView(Game game) {
        this.game = game;
        //this.lines = this.game.getSize();
        //this.columns = this.game.getSize();
        this.setAlignment(Pos.CENTER);
        //this.grid = new Button[this.game.getSize()][this.game.getSize()];
        this.game.addObserver(this);
        this.init();

    }

    private void init() {
        //this.grid = new Button[this.game.getSize()][this.game.getSize()];
        Platform.runLater(() -> {
            this.getChildren().clear();
            this.matrice = new ArrayList<>();
            for (int i = 0 ; i < this.game.getSize() ; i++) {
                this.matrice.add(i, new ArrayList<>());
                for (int j = 0; j < this.game.getSize(); j++) {
                    Button button = new Button();
                    button.setText(this.game.getCase(i, j));
                    button.setPrefSize(50, 50);
                    //this.grid[i][j] = button;
                    this.matrice.get(i).add(j, button);
                    this.add(button, i, j);
                }
            }
        });

    }

    @Override
    public void react() {

        this.init();
        System.out.println(this.matrice.size());

    }
}
