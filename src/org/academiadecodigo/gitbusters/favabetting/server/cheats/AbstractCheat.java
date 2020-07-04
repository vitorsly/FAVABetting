package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public abstract class AbstractCheat implements Cheats{
    protected int price;
    protected int policeChance;
    protected String name;
    protected String description;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPoliceChance() {
        return policeChance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
