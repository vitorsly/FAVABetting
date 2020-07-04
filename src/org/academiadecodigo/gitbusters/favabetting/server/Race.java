package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.horses.HorseFactory;
import org.academiadecodigo.gitbusters.favabetting.server.strategy.Strategy;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;
import org.academiadecodigo.gitbusters.favabetting.server.tracks.Track;

import java.util.ArrayList;
import java.util.List;

public class Race implements Runnable {

    private Server server;

    // All horses available
    private List<Horse> stable;

    // List of horses ready to race
    private List<Horse> enrolledHorses;

    // Track type that will have our race
    private Track track;

    // Horse strategy for race
    private Strategy strategy;

    // Broker to accept and handle bets
    private Broker broker;

    // Who wis the winner horse
    private Horse winnerHorse = null;

    private boolean won = false;
    private boolean raceStart = false;

    public Race(Server server) {

        this.server = server;

        // Initiate horses for race line
        this.enrolledHorses = new ArrayList<>();

        // Get track type randomly
        this.track = Track.getTrack();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();

        // Initiate broker
        this.broker = new Broker();

        // Load our stable
        this.stable = HorseFactory.createStable();

        // Add X number of horses to our race line
        enrolledHorses.addAll(HorseFactory.getHorses(6));
    }

    public void run() {

        try {

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

                        // Applying total distance effect to horse's speed ( tiredness )
                        horse.setSpeed(horse.getSpeed() * horse.getTotalDistanceMultiplier());

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

    public List<Horse> getEnrolledHorses() {
        return enrolledHorses;
    }

    public Broker getBroker() {
        return broker;
    }
}
