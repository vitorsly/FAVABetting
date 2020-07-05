package org.academiadecodigo.gitbusters.favabetting.server.strategy;

import org.academiadecodigo.gitbusters.Utils;

public enum Strategy {

    // Strategy influences how the horse will ace during the race

    EARLYSPRINT(1.2),
    SLOWSTART(1),
    STEADYRUN(0.8);

    private double multiplier;

    Strategy( double multiplier) {
        this.multiplier = multiplier;
    }

    // Returns a strategy randomly
    public static Strategy getStrategy() {
        int random = Utils.getRandom(Strategy.values().length);
        return Strategy.values()[random];
    }

    public static Strategy getStrategy(int value) {
        return Strategy.values()[value];
    }

    public double getMultiplier() {
        return multiplier;
    }
}
