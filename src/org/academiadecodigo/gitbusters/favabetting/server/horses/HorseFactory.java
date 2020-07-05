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
        stable.get(0).setTrackModifiers(1, 1.2, 0.8);
        stable.get(0).setWeatherModifiers(1.0, 0.8, 0.9, 0.95, 0.8, 0.9, 0.9);
        stable.get(0).setBigDescription("Bolt is a fast and capable horse, trained to race even during the harshest wind storms, but works fater better dry.");
        stable.add(createHorse("Lightning", "the brash pale stallion",          32, 50, 5,7,29));
        stable.get(1).setTrackModifiers(1, 1.2, 0.8);
        stable.get(1).setWeatherModifiers(1.05, 0.75, 0.9, 0.95, 0.8, 0.9, 0.9);
        stable.get(1).setBigDescription("Bolt's rival, Lightning is extremely capable of running in the wind, but suffers harshly from rain.");
        stable.add(createHorse("Thunder", "the agile old horse",                20, 40, 6.75,10,50));
        stable.get(2).setTrackModifiers(1, 1.2, 0.8);
        stable.get(2).setWeatherModifiers(1.1, 0.95, 0.75, 0.90, 0.8, 0.9, 0.85);
        stable.get(2).setBigDescription("An old horse and father of Bolt and Lighting, still the best windrunner around. Can't handle the heat though.");
        stable.add(createHorse("Sparky", "the little foal that could",          16, 60, 12.7,1, 14));
        stable.get(3).setTrackModifiers(1.1, 1.1, 1.1);
        stable.get(3).setWeatherModifiers(0.95, 0.85, 1.05, 1.0, 0.8, 0.85, 0.95);
        stable.get(3).setBigDescription("Sparky is young and perky. Enjoys running in the sand even in the heat or sun.");
        stable.add(createHorse("Firebrand", "the cocky redmane",                18, 60, 7.2,3, 21));
        stable.get(4).setTrackModifiers(1.1, 0.9, 1.3);
        stable.get(4).setWeatherModifiers(0.95, 0.7, 1.1, 1.05, 0.7, 0.85, 0.8);
        stable.get(4).setBigDescription("A prime Desert horse, Firebrand is used to the harsh desert sands, heat and sun. Never could handle the cold though.");
        stable.add(createHorse("Nightmare", "the terrifying dread stallion",    36, 70, 4.4,7,31));
        stable.get(5).setTrackModifiers(0.8, 1.1, 0.9);
        stable.get(5).setWeatherModifiers(0.9, 0.8, 0.8, 0.7, 0.9, 0.9, 1.2);
        stable.get(5).setBigDescription("A malignant spirit of the night, Nightmare runs best under the pale devil. However the sun seems to burn at his skin.");
        stable.add(createHorse("Fluffy", "the sweetest unicorn",                8, 40, 30,0,6));
        stable.get(6).setTrackModifiers(1.4, 1, 0.7);
        stable.get(6).setWeatherModifiers(0.90, 0.9, 0.9, 1.2, 0.9, 0.9, 0.8);
        stable.get(6).setBigDescription("A unicorn brought to life by a little girl's wish, Fluffy loves sunshine and rainbows and is a friend to all living things, even if she's clumsy.");
        stable.add(createHorse("Carnage", "the wave of destruction",            30, 50, 5,2,10));
        stable.get(7).setTrackModifiers(0.9, 1.1, 0.9);
        stable.get(7).setWeatherModifiers(1.0, 0.9, 0.75, 0.75, 1.0, 1.0, 1.0);
        stable.get(7).setBigDescription("Fueled exclusively by pain and destruction, Carnage doesn't care for anything but to kill. Although heat and light are a good way to take him down quick.");
        stable.add(createHorse("Tora", "fast as the wind",                      22, 50, 6.8,6,41));
        stable.get(8).setTrackModifiers(1.1, 1.3, 0.7);
        stable.get(8).setWeatherModifiers(1.1, 0.9, 0.9, 0.9, 0.9, 0.9, 0.9);
        stable.get(8).setBigDescription("Tora, his name was Tora, runs fast as the wind, especially over dirt paths.");
        stable.add(createHorse("Skyborne", "the winged hussar",                 20, 60, 7.5,5,38));
        stable.get(9).setTrackModifiers(1, 1, 1);
        stable.get(9).setWeatherModifiers(0.7, 0.8, 0.9, 0.9, 0.9, 0.9, 0.9);
        stable.get(9).setBigDescription("Skyborne, the Pegasus, cares not what terrain he moves in, although wind and rain does hamper it's flight capabilities.");
        stable.add(createHorse("Luna", "the mysterious lunar mare",             12, 100, 15,0,3));
        stable.get(10).setTrackModifiers(1.1, 1.2, 0.8);
        stable.get(10).setWeatherModifiers(0.95, 0.9, 0.9, 0.75, 0.9, 0.95, 1.2);
        stable.get(10).setBigDescription("A mysterious mare who claims to have come from the moon, she fares far better under moonlight and hates the solar glare.");
        stable.add(createHorse("Flash", "the undefeated",                       32, 100, 3,1,1));
        stable.get(11).setTrackModifiers(0.9, 1.3, 0.7);
        stable.get(11).setWeatherModifiers(1, 0.8, 1, 1.05, 0.9, 0.9, 0.9);
        stable.get(11).setBigDescription("Flash is a cocky stud, but he certainly is fast. Only time he fails to live to expectations is when he's wet.");
        stable.add(createHorse("Boink", "the clumsy boy who tried",             4, 20, 50,0,48));
        stable.get(12).setTrackModifiers(1.1, 1.2, 0.7);
        stable.get(12).setWeatherModifiers(1, 0.9, 1, 0.95, 1, 0.95, 0.8);
        stable.get(12).setBigDescription("Boink is a careful horse that is not too influenced by the world around. Only during the night does it's vision fail it. Maybe one day he'll win!");
        stable.add(createHorse("Tracy", "the clumsy girl who could",            5, 20, 30,1,24));
        stable.get(13).setTrackModifiers(1.1, 1.1, 0.9);
        stable.get(13).setWeatherModifiers(0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95);
        stable.get(13).setBigDescription("Tracy is a modest mare who is not too affected by most weather types. While clumsy, she tries her best!");
        stable.add(createHorse("Norris", "the undisputed champion",             80, 120, 2,10,20));
        stable.get(14).setTrackModifiers(1, 1, 1);
        stable.get(14).setWeatherModifiers(1, 1, 1, 1, 1, 1, 1);
        stable.get(14).setBigDescription("Norris is a stallion god on earth. Extremely quick, irreverant towards the elements and loved by all the population.");
        stable.add(createHorse("The-Spork", "the three pronged beetle",         13, 33, 13,0,3));
        stable.get(15).setTrackModifiers(1.2, 1.2, 0.8);
        stable.get(15).setWeatherModifiers(0.95, 1, 0.9, 0.95, 0.9, 0.95, 0.9);
        stable.get(15).setBigDescription("Spork is a giant water beetle. Not sure why he's racing here, but he fairs great in the rain. Obsessed with the number 3.");
        stable.add(createHorse("Shadow", "the best kept secret",                23, 45, 6.5,0,0));
        stable.get(16).setTrackModifiers(1, 1.1, 0.8);
        stable.get(16).setWeatherModifiers(0.95, 0.9, 0.9, 0.75, 0.9, 1.05, 1.1);
        stable.get(16).setBigDescription("A mysterious horse, Shadow prefers times of lower visibility, especially away from the sun.");
        stable.add(createHorse("Storm", "the force of nature",                  25, 50, 6.2,5,32));
        stable.get(17).setTrackModifiers(1, 1.2, 0.8);
        stable.get(17).setWeatherModifiers(1, 1, 0.9, 0.9, 0.9, 0.9, 0.9);
        stable.get(17).setBigDescription("Storm is a relatively normal horse although he never had any trouble racing trough his namesake.");
        stable.add(createHorse("Frost", "the coolest beast",                    24, 45, 6.4,5,33));
        stable.get(18).setTrackModifiers(1, 1.1, 0.7);
        stable.get(18).setWeatherModifiers(0.95, 0.95, 0.75, 0.8, 1.2, 1, 0.9);
        stable.get(18).setBigDescription("Used to the frosty lands of Siberia, Frost doesn't deal well with the heat or the sun, but is well at home in the cold.");
        stable.add(createHorse("X-10", "the equine terminator",                 50, 90, 4,0,0));
        stable.get(19).setTrackModifiers(1, 1, 0.9);
        stable.get(19).setWeatherModifiers(1, 0.6, 1, 1, 1, 1, 1);
        stable.get(19).setBigDescription("A perfect machine, X-10's only weakness is in it's lack of waterproofing. ");

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
