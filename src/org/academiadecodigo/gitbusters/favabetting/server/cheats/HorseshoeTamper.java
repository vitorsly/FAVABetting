package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class HorseshoeTamper extends AbstractCheat {

    public void init() {
        price = 40;
        fine = 100;
        policeChance = 5;
        name = "Horseshoe Tampering";
        description = "Messing with a horses horseshoes makes sure they'll have quite some trouble racing.";
    }

    @Override
    public void activate(Horse target) {
        target.tempSpeedChange(-10);
    }
}
