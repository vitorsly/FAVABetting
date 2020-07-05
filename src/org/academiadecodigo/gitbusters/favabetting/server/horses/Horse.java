package org.academiadecodigo.gitbusters.favabetting.server.horses;

import org.academiadecodigo.gitbusters.Utils;
import org.academiadecodigo.gitbusters.favabetting.server.tracks.Track;
import org.academiadecodigo.gitbusters.favabetting.server.weather.Weather;

public class Horse {

    private int id;
    private String name;
    private String description;
    private double baseSpeed;
    private double speed;
    private int maxSpeed;
    private double distance;
    private double totalDistance;
    private double odds;
    private int wins;
    private int races;
    private boolean alive;

    private double grassModifier;
    private double dirtModifier;
    private double sandModifier;

    private double windModifier;
    private double rainModifier;
    private double warmModifier;
    private double sunnyModifier;
    private double coldModifier;
    private double mistyModifier;
    private double nightModifier;

    private String bigDescription;

    Horse(int id, String name, String description, double speed, int maxSpeed, double odds, int wins, int races){

        this.id = id;
        this.description = description;
        this.name = name;
        this.baseSpeed = speed;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.distance = 0;
        this.totalDistance = 0;
        this.odds = odds;
        this.wins = wins;
        this.races = races;
        this.alive = true;

        this.grassModifier = 1;
        this.dirtModifier = 1.2;
        this.sandModifier = 0.8;

        this.windModifier = 0.95;
        this.rainModifier = 0.90;
        this.warmModifier = 0.90;
        this.sunnyModifier = 0.95;
        this.coldModifier = 0.90;
        this.mistyModifier = 0.90;
        this.nightModifier = 0.90;

        this.bigDescription = "";
    }

    public void setTrackModifiers(double grass, double dirt, double sand){
        this.grassModifier = grass;
        this.dirtModifier = dirt;
        this.sandModifier = sand;
    }

    public double getTrackModifier(Track type){
        return switch (type) {
            case DIRT -> dirtModifier;
            case GRASS -> grassModifier;
            case SAND -> sandModifier;
        };
    }

    public void setWeatherModifiers(double wind, double rain, double warm, double sunny, double cold, double mist, double night){
        this.windModifier = wind;
        this.rainModifier = rain;
        this.warmModifier = warm;
        this.sunnyModifier = sunny;
        this.coldModifier = cold;
        this.mistyModifier = mist;
        this.nightModifier = night;
    }

    public double getWeatherModifier(Weather type){
        return  switch (type.getWeatherClass()){
            case NONE -> 1;
            case WIND -> Math.pow(windModifier, type.getPower());
            case RAIN -> Math.pow(rainModifier, type.getPower());
            case WARM -> Math.pow(warmModifier, type.getPower());
            case SUNNY -> Math.pow(sunnyModifier, type.getPower());
            case COLD -> Math.pow(coldModifier, type.getPower());
            case MISTY -> Math.pow(mistyModifier, type.getPower());
            case NIGHT -> Math.pow(nightModifier, type.getPower());
        };
    }

    public void setBigDescription(String bigDescription){
        this.bigDescription = bigDescription;
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

    public boolean isAlive() {
        return alive;
    }

    public void race() {

        double randomSpeed = Utils.getRandom(1, 3) * speed / 3;

        this.distance += randomSpeed;
        this.totalDistance += randomSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public double getTotalDistanceMultiplier() {
        return this.distance * 0.8 / this.totalDistance;
    }

    public void resetDistance() {
        this.distance = 0;
    }

    public void resetSpeed() {
        this.speed = baseSpeed;
    }

    public void addWin() {
        this.wins++;
    }

    public void addRace() {
        this.races++;
    }

    public void tempSpeedChange(double speedChange){
        this.speed += speedChange;
    }

    public void permSpeedChange(double speedChange){
        this.speed += speedChange;
        this.baseSpeed += speedChange;
    }

    public void setSpeed(double value) {
        if(value <= maxSpeed) {
            this.speed = value;
        }
    }

    public void shiftSpeed(double speedModifier){
        this.speed += speedModifier;
    }

    public String getDescription() {
        return description;
    }

    public String getBigDescription() {
        return bigDescription;
    }
}
