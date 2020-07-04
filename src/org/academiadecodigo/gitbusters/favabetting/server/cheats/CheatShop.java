package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.Utils;
import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class CheatShop {

    Cheats[] cheats;

    public void init(){
        cheats = new Cheats[5];
        cheats[0] = new SteroidBoost();
        cheats[1] = new MegaBoost();
        cheats[2] = new HorseshoeTamper();
        cheats[3] = new BaseballBat();
        cheats[4] = new Gun();
    }

    public boolean buyCheat(int cheatID, Client buyer, Horse target){
        /*
        if(cheats[cheatID].getPrice() > buyer.getBalance()){
            buyer.setBalance -= cheats[cheatID].getPrice();
            return false;
        }
        */

        if(Utils.getRandom(1,100) <= cheats[cheatID].getPoliceChance()){
            System.out.println("Client " + buyer.getName() + " has been caught using cheats!");
            //buyer.setBalance -= cheats[cheatID].getFine();
            return false;
        } else {
            cheats[cheatID].activate(target);
            return true;
        }
    }
}
