package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.horses.HorseFactory;
import org.academiadecodigo.gitbusters.favabetting.server.strategy.Strategy;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;
import org.academiadecodigo.gitbusters.favabetting.server.tracks.Track;

import java.util.ArrayList;
import java.util.List;

public class Race implements Runnable {

    // List of horses ready to race
    private static List<Horse> enrolledHorses;

    private Track track;
    private Strategy strategy;

    private Broker broker;

    private Horse winnerHorse = null;

    private boolean won = false;
    private boolean raceStart = false;

    public Race() {

        enrolledHorses = new ArrayList<>();

        // Get track type randomly
        this.track = Track.getTrack();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();
    }

    public static void main(String[] args) {

        Race race = new Race();

        // Initiate broker
        Broker broker = new Broker();

        List<Horse> stable = HorseFactory.createStable();

        enrolledHorses.addAll(HorseFactory.getHorses(6));

        // Start the race
        race.run();
    }

    public void run() {

        try {

            // TODO: Countdown for race start
            // TODO Accept user bets

            // Message for race start
            System.out.println("Starting the race!");

            // While we don't have a winner race continues
            while(!won) {

                for(Horse horse : enrolledHorses) {

                    // Apply speed change at race start only
                    if(!raceStart) {
                        // Applying track effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * track.getType().getMultiplier());

                        // Applying strategy effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * strategy.getType().getMultiplier());
                        raceStart = true;
                    }

                    // Increments distance run by horse
                    horse.race();

                    // DEBUG ONLY
                    System.out.println(horse.getName() + " is running.");

                    // Get track distance and compare with horse run distance
                    if(horse.getDistance() == track.getType().getDistance()) {

                        // MESSAGE HORSE WON
                        System.out.println("We have a winner!");

                        // Sets winner with horse object
                        winnerHorse = horse;
                        won = true;

                        // Reset horse race distance
                        for(Horse horseFinish : enrolledHorses) {
                            horseFinish.resetDistance();
                        }

                        break;
                    }
                }
            }

            // TODO: Check bets and apply wins to players base on winner horse object
            System.out.println("Winning horse: " + winnerHorse.getName());

            // Message to players about money
            System.out.println("Here have your money cheater!");
            System.out.println("You're a fucking looser!");

        } catch ( Exception error) {
            error.printStackTrace();
        }
    }
}
