package org.academiadecodigo.gitbusters.favabetting.server.horses;

import org.academiadecodigo.gitbusters.Utils;

import java.util.ArrayList;
import java.util.List;

public class HorseFactory {

    static int currentID = 0;
    private static ArrayList<Horse> stable;

    public static Horse createHorse(String name, String Description, double speed, int maxspeed, double odds, int wins, int race){

        Horse horse = new Horse(currentID, name, Description, speed, maxspeed, odds, wins, race);

        currentID++;

        return horse;
    }

    public static List<Horse> createStable(){

        stable = new ArrayList<>();

        stable.add(createHorse("Bolt", "the quick white horse",                 30, 50, 5.5, 5, 25));
        stable.add(createHorse("Lightning", "the brash pale stallion",          32, 50, 5,7,29));
        stable.add(createHorse("Thunder", "the agile old horse",                20, 40, 6.75,10,50));
        stable.add(createHorse("Sparky", "the little foal that could",          16, 60, 12.7,1, 14));
        stable.add(createHorse("Firebrand", "the cocky redmane",                18, 60, 7.2,3, 21));
        stable.add(createHorse("Nightmare", "the terrifying dread stallion",    36, 70, 4.4,7,31));
        stable.add(createHorse("Fluffy", "the sweetest unicorn",                8, 40, 30,0,6));
        stable.add(createHorse("Carnage", "the wave of destruction",            30, 50, 5,2,10));
        stable.add(createHorse("Tora", "fast as the wind",                      22, 50, 6.8,6,41));
        stable.add(createHorse("Skyborne", "the winged hussar",                 20, 60, 7.5,5,38));
        stable.add(createHorse("Luna", "the mysterious lunar mare",             12, 100, 15,0,3));
        stable.add(createHorse("Flash", "the undefeated",                       32, 100, 3,1,1));
        stable.add(createHorse("Boink", "the clumsy boy who tried",             4, 20, 50,0,48));
        stable.add(createHorse("Tracy", "the clumsy girl who could",            5, 20, 30,1,24));
        stable.add(createHorse("Norris", "the undisputed champion",             80, 120, 2,10,20));
        stable.add(createHorse("The Spork", "the three pronged beatle",         13, 33, 13,0,3));
        stable.add(createHorse("Shadow", "the best kept secret",                23, 45, 6.5,0,0));
        stable.add(createHorse("Storm", "the force of nature",                  25, 50, 6.2,5,32));
        stable.add(createHorse("Frost", "the coolest beast",                    24, 45, 6.4,5,33));
        stable.add(createHorse("X-10", "the equine terminator",                 50, 90, 4,0,0));

        return stable;
    }

    public static ArrayList<Horse> getHorses(int number) {

        ArrayList<Horse> onRace = new ArrayList<>();

        while ( number > 0){

            int random = Utils.getRandom(stable.size());
            Horse horse = stable.get(random);

            if(!onRace.contains(horse)) {
                onRace.add(horse);
                number--;
            }
        }

        return onRace;
    }
}
