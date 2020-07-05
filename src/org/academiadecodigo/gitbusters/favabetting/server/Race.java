package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.cheats.CheatShop;
import org.academiadecodigo.gitbusters.favabetting.server.horses.HorseFactory;
import org.academiadecodigo.gitbusters.favabetting.server.strategy.Strategy;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;
import org.academiadecodigo.gitbusters.favabetting.server.tracks.Track;
import org.academiadecodigo.gitbusters.favabetting.server.weather.WeatherType;

import java.util.*;

public class Race implements Runnable {

    private Server server;
    private Boolean inRace = false;

    // All horses available
    private List<Horse> stable;

    // List of horses ready to race
    private List<Horse> enrolledHorses;

    // Track type that will have our race
    private Track track;

    private WeatherType weather;

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

        // Load our stable
        this.stable = HorseFactory.createStable();

        // Initiate horses for race line
        this.enrolledHorses = new ArrayList<>();

        // Add X number of horses to our race line
        enrolledHorses.addAll(HorseFactory.getHorses(6));

        // Get track type randomly
        this.track = Track.getTrack();

        this.weather = WeatherType.random();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();

        // Initiate broker
        this.broker = new Broker();

        CheatShop.init();
    }

    public void run() {

        try {

            server.broadcastMsg("betTime");
            System.out.print("");
            Interval interval = server.interval(30);

            boolean sopLoop = true;


            while (sopLoop){
               	sopLoop = interval.getInInterval();
                System.out.print("");
            }

            inRace = true;

            System.out.print("");

            server.broadcastMsg("betStop");

            int timmer = 5;

            while (timmer > 0){
                Thread.sleep(1000);
                timmer--;
                server.broadcastMsg("time:" + timmer);
            }

            // Message for race start
            System.out.println("Starting the race!");

            // While we don't have a winner race continues
            while(!won) {

                Horse leadingHorse = enrolledHorses.get(0);

                for(Horse horse : enrolledHorses) {

                    // Apply speed change at race start only
                    if (!raceStart) {

                        // Applying track effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * track.getType().getMultiplier());

                        horse.setSpeed(horse.getSpeed() * horse.getTrackModifier(track.getType()));

                        horse.setSpeed(horse.getSpeed() * horse.getWeatherModifier(weather));

                        // Applying strategy effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * strategy.getType().getMultiplier());

                        // Applying total distance effect to horse's speed ( tiredness )
                        horse.setSpeed(horse.getSpeed() * horse.getTotalDistanceMultiplier());

                        raceStart = true;
                    }

                    // Increments distance run by horse
                    horse.race();

                    if(horse.getDistance() > leadingHorse.getDistance()){
                        leadingHorse = horse;
                    }

                    // Get track distance and compare with horse run distance
                    if (horse.getDistance() >= track.getType().getDistance()) {

                        // MESSAGE HORSE WON
                        System.out.println("We have a winner!");

                        // Sets winner with horse object
                        winnerHorse = horse;
                        won = true;

                        // Reset horse race distance
                        for (Horse horseFinish : enrolledHorses) {
                            horseFinish.resetDistance();
                        }

                        // TODO: give Rewards to players
                        // This variable contains all bets by client and value
                        Map<Client, Integer> winnerHorseBets = broker.getHorseBets(winnerHorse);

                        break;
                    }
                }

                System.out.println("leading horse is " + leadingHorse.getName());

                Thread.sleep(5000);

                server.broadcastMsg("Leading " + leadingHorse.getName());
            }

            server.broadcastMsg("raceOver " + winnerHorse.getName());

            PaybackWinnings(winnerHorse);

            inRace = false;

            System.out.println("Winning horse: " + winnerHorse.getName());

            // Message to players about money
            System.out.println("Here have your money cheater!");
            System.out.println("You're a fucking looser!");

            restartRace();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    private void PaybackWinnings(Horse winner) {

    }

    public void restartRace(){

        won = false;

        // Initiate horses for race line
        this.enrolledHorses = new ArrayList<>();

        // Add X number of horses to our race line
        enrolledHorses.addAll(HorseFactory.getHorses(6));

        // Get track type randomly
        this.track = Track.getTrack();

        this.weather = WeatherType.random();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();

        run();
    }

    public void placeBet(Client client, int horse, int amount) {
        broker.registerBet(client, enrolledHorses.get(horse), amount);
    }

    public List<Horse> getEnrolledHorses() {
        return enrolledHorses;
    }

    public Broker getBroker() {
        return broker;
    }

    public Boolean getInRace() {
        return inRace;
    }
}
