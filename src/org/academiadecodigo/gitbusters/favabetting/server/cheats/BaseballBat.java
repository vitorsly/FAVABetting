package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class BaseballBat extends AbstractCheat{

    public void init(){
        price = 80;
        fine = 200;
        policeChance = 10;
        name = "Baseball Bat";
        description = "This here bat has done some serious damage to some horse legs. Permanent serious damage to a horse's winning chances.";
    }

    @Override
    public void activate(Horse target) {
        target.permSpeedChange(-10);
    }
}
