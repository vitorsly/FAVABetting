package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public interface Cheats {

    void init();

    void activate(Horse target);

    double getPrice();

    double getFine();

    int getPoliceChance();

    String getName();

    String getDescription();
}
