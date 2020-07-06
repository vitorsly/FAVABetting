package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class Gun extends AbstractCheat {

    public void init() {
        price = 200;
        fine = 500;
        policeChance = 25;
        name = "Shotgun";
        description = "If you really really need a horse dead, don't leave it up to chance.";
    }

    @Override
    public void activate(Horse target) {
        target.kill();
    }
}
