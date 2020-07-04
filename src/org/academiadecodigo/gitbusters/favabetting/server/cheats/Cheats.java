package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public interface Cheats {

    void init();

    void activate(Horse target);

    int getPrice();

    int getPoliceChance();

    String getName();

    String getDescription();


}
