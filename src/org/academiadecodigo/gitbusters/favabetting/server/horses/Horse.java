package org.academiadecodigo.gitbusters.favabetting.server.horses;

public class Horse {
    private int id;
    private String name;
    private String description;
    private int speed;
    private double odds;
    private int wins;
    private int races;
    private boolean alive;
    private RaceStrategy strategy;

    Horse(int id, String name, String description, int speed, double odds, int wins, int races){
        this.id = id;
        this.description = description;
        this.name = name;
        this.speed = speed;
        this.odds = odds;
        this.wins = wins;
        this.races = races;
        this.alive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getOdds() {
        return odds;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWins() {
        return wins;
    }

    public int getRaces() {
        return races;
    }

    public void kill(){
        alive = false;
    }

    public void setStrategy(RaceStrategy strategy) {
        this.strategy = strategy;
    }

    public void shiftSpeed(int speedModifier){
        this.speed += speedModifier;
    }

    private String name;
    public double speed;
    private int maxSpeed;
    private double distance;

    public Horse(String name, double speed, int maxSpeed) {
        this.name = name;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.distance = 0;
    }

    public void race() {
        this.distance += speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setSpeed(double value) {
        if(value <= maxSpeed) {
            this.speed = value;
        }
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getName() {
        return this.name;
    }
}
