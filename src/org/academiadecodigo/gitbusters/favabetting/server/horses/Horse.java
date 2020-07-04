package org.academiadecodigo.gitbusters.favabetting.server.horses;

public class Horse {

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
