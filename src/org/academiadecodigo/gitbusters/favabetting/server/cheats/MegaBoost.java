package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class MegaBoost extends AbstractCheat{

    public void init(){
        price = 100;
        policeChance = 10;
        name = "SuperSteroids";
        description = "These are some powerful drugs. Gonna make sure add some muscle mass to your target for years.";
    }

    @Override
    public void activate(Horse target) {
        target.permSpeedChange(10);
    }
}
