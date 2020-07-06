package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class SteroidBoost extends AbstractCheat {

    public void init() {
        price = 50;
        fine = 100;
        policeChance = 5;
        name = "Steroids";
        description = "Some special pills that are gonna give your horse an edge on the next race.";
    }

    @Override
    public void activate(Horse target) {
        target.tempSpeedChange(10);
    }
}
