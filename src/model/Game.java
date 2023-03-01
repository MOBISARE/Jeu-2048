package model;


import javafx.application.Platform;
import view.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends Observable {

    /**
     * List of observers
     */
    private List<Observer> observers;

    /**
     * Plateau
     */
    private int[][] grid;

    /**
     * Plateau's size
     */
    private int size;

    /**
     * Number of games played
     */
    private int gamesPlayed;

    /**
     * Number of games won
     */
    private int gamesWon;

    /**
     * Objective value to reach
     */
    private int objective;

    /**
     * Constructor class Game
     * @param size
     */
    public Game(int size) {
        this.size = size;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.objective = 2048;
        this.observers = new ArrayList<>();
        this.init();

    }

    /**
     * Procedure to initialise the plateau
     */
    private void init() {
        Random random = new Random();
        this.grid = new int[this.size][this.size];
        // Fill the grid
        for (int i = 0 ; i < this.size ; i++) {
            for (int j = 0 ; j < this.size ; j++) {
                this.grid[i][j] = 0;
            }
        }

        // Initialise random values
        int line = random.nextInt(this.grid.length);
        int column = random.nextInt(this.grid.length);
        boolean bool = random.nextBoolean();

        // Insert 2 cases with value 2 or 4 randomly
        for(int i = 0 ; i < 2 ; i++) {

            while (this.grid[line][column] == 2 || this.grid[line][column] == 4) {
                line = random.nextInt(this.grid.length);
                column = random.nextInt(this.grid.length);
                bool = random.nextBoolean();
            }

            if (bool) {
                this.grid[line][column] = 2;
            } else {
                this.grid[line][column] = 4;
            }
        }
    }

    public void newGame() {
        System.out.println("NewGame");
        this.init();
        this.setGamesPlayed();

    }

    public void editSize() {
        System.out.println("Edit size");
        this.init();
    }

    public void exit() {
        Platform.exit();
    }

    /**
     * Procedure to add an Observer to the model
     * @param observer
     */
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Procedure to notify each Observer of the model
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : this.observers) {
            observer.react();
        }
    }

    // Getter & Setter

    public int getObjective() {
        return this.objective;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }

    public String getCase(int line, int column) {
        return String.valueOf(this.grid[line][column]);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
        this.grid = new int[size][size];
        this.init();
    }

    public String getGamesPlayed() {
        return String.valueOf(this.gamesPlayed);
    }

    public void setGamesPlayed() {
        this.gamesPlayed += 1;
    }

    public String getGamesWon() {
        return String.valueOf(this.gamesWon);
    }

    public void setGamesWon() {
        this.gamesWon += 1;
    }


}
