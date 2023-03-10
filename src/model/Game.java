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
    //private int[][] grid;

    private List<List<Integer>> matrice;

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
        this.matrice = new ArrayList<>();
        this.init();

    }

    /**
     * Procedure to initialise the plateau
     */
    private void init() {
        Random random = new Random();
        //this.grid = new int[this.size][this.size];

        // Fill the grid
        for (int i = 0 ; i < this.size ; i++) {
            this.matrice.add(i, new ArrayList<>(this.size));
            for (int j = 0 ; j < this.size ; j++) {
                this.matrice.get(i).add(j, 0);
                //this.grid[i][j] = 0;
            }
        }

        // Initialise random values
        int line = random.nextInt(this.size);
        int column = random.nextInt(this.size);
        boolean bool = random.nextBoolean();

        // Insert 2 cases with value 2 or 4 randomly
        for(int i = 0 ; i < 2 ; i++) {

            while (this.matrice.get(line).get(column) == 2 || this.matrice.get(line).get(column) == 4) {
                line = random.nextInt(this.size);
                column = random.nextInt(this.size);
                bool = random.nextBoolean();
            }

            if (bool) {
                this.matrice.get(line).set(column, 2);
            } else {
                this.matrice.get(line).set(column, 4);
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
        this.matrice = new ArrayList<>(this.size);
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
        return String.valueOf(this.matrice.get(line).get(column));
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
        this.matrice = new ArrayList<>();
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
