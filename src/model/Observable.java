package model;

import view.Observer;

public abstract class Observable {

    public abstract void addObserver(Observer observer);

    public abstract void notifyObserver();

}
