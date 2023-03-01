package model;


import view.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends Observable {

    private List<Observer> observers;

    private int[][] grid;

    public Game(int size) {
        this.observers = new ArrayList<>();
        this.grid = new int[size][size];
        this.init();

    }

    private void init() {
        Random random = new Random();

        // Fill the grid
        for (int i = 0 ; i < this.grid.length ; i++) {
            for (int j = 0 ; j < this.grid.length ; j++) {
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
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : this.observers) {
            observer.react();
        }
    }
}
