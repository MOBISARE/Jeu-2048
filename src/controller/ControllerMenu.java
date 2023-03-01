package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Game;

public class ControllerMenu implements EventHandler {

    private Game game;

    public ControllerMenu(Game game) {
        this.game = game;
    }


    @Override
    public void handle(Event event) {
        this.game.newGame();
        this.game.notifyObserver();
    }
}
