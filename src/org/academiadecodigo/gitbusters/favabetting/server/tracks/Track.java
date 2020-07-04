package org.academiadecodigo.gitbusters.favabetting.server.tracks;

import org.academiadecodigo.gitbusters.Utils;

public class Track {

    // TODO: Add different types of tracks in terms of surface that modifies horse velocity
    // TODO: This type is set by a number that then is multiplied by horse speed influencing is capacity to win

    private TrackType type;

    public Track( TrackType type ) {
        this.type = type;
    }

    public TrackType getType() {
        return type;
    }

    public static Track getTrack() {
        int random = Utils.getRandom(TrackType.values().length);
        TrackType trackType = TrackType.values()[random];
        return new Track(trackType);
    }
}
