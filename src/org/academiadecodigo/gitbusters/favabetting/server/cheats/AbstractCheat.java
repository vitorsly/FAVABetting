package org.academiadecodigo.gitbusters.favabetting.server.cheats;

public abstract class AbstractCheat implements Cheats {

    protected double price;
    protected double fine;
    protected int policeChance;
    protected String name;
    protected String description;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getFine() {
        return fine;
    }

    @Override
    public int getPoliceChance() {
        return policeChance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
