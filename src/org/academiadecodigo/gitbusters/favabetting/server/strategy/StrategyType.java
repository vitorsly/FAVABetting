package org.academiadecodigo.gitbusters.favabetting.server.strategy;

public enum StrategyType {

    EARLYSPRINT(1.2),
    SLOWSTART(1),
    STEADYRUN(0.8);

    private double multiplier;

    StrategyType( double multiplier) {
        this.multiplier = multiplier;
    }

    public static StrategyType getStrategyType(int value) {
        return StrategyType.values()[value];
    }

    public double getMultiplier() {
        return multiplier;
    }
}
