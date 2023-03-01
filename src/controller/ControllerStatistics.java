package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Game;

public class ControllerStatistics implements EventHandler {

    private Game game;

    public ControllerStatistics(Game game) {
        this.game = game;

    }

    @Override
    public void handle(Event event) {
        this.game.notifyObserver();

    }
}
