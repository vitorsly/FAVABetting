package org.academiadecodigo.gitbusters.favabetting.server.horses;

public class Horse {
    private int id;
    private String name;
    private String description;
    private double speed;
    private int maxSpeed;
    private double distance;
    private double totalDistance;
    private double odds;
    private int wins;
    private int races;
    private boolean alive;


    Horse(int id, String name, String description, double speed, int maxSpeed, double odds, int wins, int races){
        this.id = id;
        this.description = description;
        this.name = name;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.distance = 0;
        this.totalDistance = 0;
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

    public double getSpeed() {
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

    public void race() {
        this.distance += speed;
        this.totalDistance += speed;
    }

    public double getDistance() {
        return distance;
    }

    public void resetDistance() {
        this.distance = 0;
    }

    public void setSpeed(double value) {
        if(value <= maxSpeed) {
            this.speed = value;
        }
    }

    public void shiftSpeed(double speedModifier){
        this.speed += speedModifier;
    }
}
