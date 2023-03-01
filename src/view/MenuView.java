package view;

import controller.ControllerMenu;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.*;
import model.Game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuView extends MenuBar implements Observer {

    private Game game;
    private Menu file;

    private Menu edit;

    private Menu exit;

    private MenuItem newGame;

    private MenuItem editSize;

    private MenuItem editObjective;
    private MenuItem quit;


    public MenuView(Game game) {
        this.game = game;

        this.file = new Menu("File");
        this.edit = new Menu("Edit");
        this.exit = new Menu("Exit");

        this.newGame = new MenuItem("New Game");
        this.editSize = new MenuItem("Edit size");
        this.editObjective = new MenuItem("Edit objective");
        this.quit = new MenuItem("Quit");

        this.newGame.setOnAction(this::newGame);
        this.editSize.setOnAction(this::editSize);
        this.editObjective.setOnAction(this::editObjective);
        this.quit.setOnAction(this::exit);

        this.file.getItems().addAll(this.newGame);
        this.edit.getItems().addAll(this.editSize, this.editObjective);
        this.exit.getItems().addAll(this.quit);

        this.getMenus().addAll(this.file, this.edit,this.exit);

        this.game.addObserver(this);
    }

    private void newGame(Event event) {
        this.game.newGame();
        this.game.notifyObserver();
    }

    private void exit(Event event) {
        this.game.exit();
    }

    private void editSize(Event event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Edit size");
        dialog.showAndWait();
        Pattern p = Pattern.compile("\\d");
        String input = dialog.getResult();
        Matcher m = p.matcher(input);
        boolean b = m.find();
        if (!b || Integer.parseInt(input) < 5 || Integer.parseInt(input) > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText("Edit size error");
            alert.setContentText("Please enter an integer value between 5 and 10");
            alert.showAndWait();
        }
        while(!b || Integer.parseInt(input) < 5 || Integer.parseInt(input) > 10) {
            dialog = new TextInputDialog();
            dialog.setTitle("Edit size");
            dialog.setHeaderText("Please enter an integer value between 5 and 10");
            dialog.showAndWait();
            p = Pattern.compile("\\d");
            input = dialog.getResult();
            m = p.matcher(input);
            b = m.find();
            System.out.println(b);
        }
        int result = Integer.parseInt(input);
        //System.out.println(dialog.getResult());
        this.game.setSize(result);
        System.out.println(this.game.getSize());
        //this.game.editSize();
        this.game.notifyObserver();
    }

    private void editObjective(Event event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Edit objective");
        dialog.showAndWait();
    }

    @Override
    public void react() {

    }
}
