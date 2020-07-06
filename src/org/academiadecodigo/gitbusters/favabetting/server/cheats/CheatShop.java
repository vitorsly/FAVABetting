package org.academiadecodigo.gitbusters.favabetting.server.cheats;

import org.academiadecodigo.gitbusters.Utils;
import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class CheatShop {

    public static Cheats[] cheats;

    public CheatShop() {
        init();
    }

    public static void init() {

        cheats = new Cheats[5];

        cheats[0] = new SteroidBoost();
        cheats[1] = new MegaBoost();
        cheats[2] = new HorseshoeTamper();
        cheats[3] = new BaseballBat();
        cheats[4] = new Gun();

        cheats[0].init();
        cheats[1].init();
        cheats[2].init();
        cheats[3].init();
        cheats[4].init();
    }

    public static boolean buyCheat(int cheatID, Client buyer, Horse target) {

        if (cheats[cheatID].getPrice() > buyer.getWallet().getBalance()) {
            return false;
        }

        if (Utils.getRandom(1, 100) <= cheats[cheatID].getPoliceChance()) {

            System.out.println("Client " + buyer.getName() + " has been caught using cheats!");

            if (buyer.getWallet().getBalance() < cheats[cheatID].getFine()) {
                buyer.getWallet().Withdraw(buyer.getWallet().getBalance());
            } else {
                buyer.getWallet().Withdraw(cheats[cheatID].getFine());
            }

            return false;

        } else {
            buyer.getWallet().Withdraw(cheats[cheatID].getPrice());
            cheats[cheatID].activate(target);
            return true;
        }
    }

    public static void activate(int id, Horse target) {
        cheats[id].activate(target);
    }

    public static String getName(int id) {
        return cheats[id].getName();
    }

    public static String getDescription(int id) {
        return cheats[id].getDescription();
    }

    public static double getPrice(int id) {
        return cheats[id].getPrice();
    }

    public static double getFine(int id) {
        return cheats[id].getFine();
    }

    public static int getPoliceChange(int id) {
        return cheats[id].getPoliceChance();
    }

    public static Cheats[] getCheats() {
        return cheats;
    }
}
