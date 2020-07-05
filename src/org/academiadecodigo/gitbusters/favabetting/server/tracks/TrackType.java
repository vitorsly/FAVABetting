package org.academiadecodigo.gitbusters.favabetting.server.tracks;

import org.academiadecodigo.gitbusters.Utils;

public enum TrackType {

    DIRT("Dirt","Description for DIRT track.",300,1.2),
    GRASS("Grass","Description for GRASS track.",200,1),
    SAND("Sand","Description for SAND track.",200,0.8);

    private String name;
    private String description;
    private int distance;
    private double multiplier;

    TrackType(String name, String description, int distance, double multiplier) {
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.multiplier = multiplier;
    }

    public static TrackType getTrackType(int value) {
        return TrackType.values()[value];
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

    public static TrackType random() {
        int random = Utils.getRandom(TrackType.values().length);
        TrackType trackType = TrackType.values()[random];
        return trackType;
    }
}
