package org.academiadecodigo.gitbusters.favabetting.server.tracks;

import org.academiadecodigo.gitbusters.Utils;

public enum Track {

    // Track sets which type of surface race will hav influencing horse's speed

    DIRT("Dirt","Description for DIRT track.",400,1.2),
    GRASS("Grass","Description for GRASS track.",500,1),
    SAND("Sand","Description for SAND track.",450,0.8);


    private String name;
    private String description;
    
    private int distance;
    private double multiplier;

    Track(String name, String description, int distance, double multiplier) {
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.multiplier = multiplier;
    }

    // Returns a track type randomly
    public static Track random() {
        int random = Utils.getRandom(Track.values().length);
        return Track.values()[random];
    }

    public static Track getTrackType(int value) {
        return Track.values()[value];
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDistance() {
        return distance;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
