package view;

import controller.ControllerMenu;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import model.Game;

public class MenuView extends MenuBar implements Observer {

    private Game game;
    private Menu menu;

    private MenuItem newGame;

    private MenuItem exit;

    private ControllerMenu controllerMenu;

    public MenuView(Game game) {
        this.game = game;
        this.menu = new Menu("Menu");
        this.newGame = new MenuItem("New Game");
        this.exit = new MenuItem("Exit");

        this.controllerMenu = new ControllerMenu(game);
        this.newGame.setOnAction(this.controllerMenu);
        this.exit.setOnAction(event -> Platform.exit());
        this.menu.getItems().addAll(this.newGame, this.exit);
        this.getMenus().add(this.menu);
        this.game.addObserver(this);

    }

    @Override
    public void react() {

    }
}
