package org.academiadecodigo.gitbusters.favabetting.server.tracks;

import org.academiadecodigo.gitbusters.Utils;

public enum Track {

    // Track sets which type of surface race will hav influencing horse's speed

    DIRT("Dirt", "Description for DIRT track.", 400),
    GRASS("Grass", "Description for GRASS track.", 500),
    SAND("Sand", "Description for SAND track.", 450);
    SNOW("Snow", "Description for SNOW rrack", 425)

    private String name;
    private String description;
    
    private int distance;

    Track(String name, String description, int distance) {
        this.name = name;
        this.description = description;
        this.distance = distance;
    }

    // Returns a track type randomly
    public static Track random() {
        int random = Utils.getRandom(Track.values().length);
        return Track.values()[random];
    }

    // Returns track type
    public static Track getType(int value) {
        return Track.values()[value];
    }

    // Returns track name
    public String getName() {
        return name;
    }

    // Returns track description
    public String getDescription() {
        return description;
    }

    // Returns track distance
    public int getDistance() {
        return distance;
    }

    // Sets track new distance
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
