package org.academiadecodigo.gitbusters.favabetting.server.strategy;

import org.academiadecodigo.gitbusters.Utils;

public class Strategy {

    // TODO: Strategy that influences each horse differently at the beginning of each race

    private StrategyType type;

    public Strategy( StrategyType type ) {
        this.type = type;
    }

    public StrategyType getType() {
        return type;
    }

    public static Strategy getStrategy() {
        int random = Utils.getRandom(StrategyType.values().length);
        StrategyType strategyType = StrategyType.values()[random];
        return new Strategy(strategyType);
    }
}
