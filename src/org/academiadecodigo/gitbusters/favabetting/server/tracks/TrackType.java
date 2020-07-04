package org.academiadecodigo.gitbusters.favabetting.server.tracks;

public enum TrackType {

    DIRT(300, 1.2),
    GRASS(200, 1),
    SAND( 200, 0.8);

    private int distance;
    private double multiplier;

    TrackType(int distance, double multiplier) {
        this.distance = distance;
        this.multiplier = multiplier;
    }

    public static TrackType getTrackType(int value) {
        return TrackType.values()[value];
    }

    public int getDistance() {
        return distance;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
