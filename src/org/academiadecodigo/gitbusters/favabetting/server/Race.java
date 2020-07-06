package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.cheats.CheatShop;
import org.academiadecodigo.gitbusters.favabetting.server.horses.HorseFactory;
import org.academiadecodigo.gitbusters.favabetting.server.strategy.Strategy;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;
import org.academiadecodigo.gitbusters.favabetting.server.tracks.Track;
import org.academiadecodigo.gitbusters.favabetting.server.weather.Weather;

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

    // Wehater conditions for the race
    private Weather weather;

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
        this.track = Track.random();

        this.weather = Weather.random();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();

        // Initiate broker
        this.broker = new Broker();

        // Start cheap shop
        CheatShop.init();
    }

    public void run() {

        try {

            server.broadcastMsg("betTime");
            System.out.print("");
            Interval interval = server.interval(60);

            boolean sopLoop = true;

            while (sopLoop){
               	sopLoop = interval.getInInterval();
                System.out.print("");
            }

            inRace = true;

            System.out.print("");

            // Send to all clients end of betting time message
            server.broadcastMsg("betStop");

            int timmer = 5;

            // Countdown
            while (timmer > 0){
                Thread.sleep(1000);
                timmer--;
                server.broadcastMsg("time :" + timmer);
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
                        horse.setSpeed(horse.getSpeed() * horse.getTrackModifier(track));

                        // Applying weather effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * horse.getWeatherModifier(weather));

                        // Applying strategy effect to horse's speed
                        horse.setSpeed(horse.getSpeed() * strategy.getMultiplier());

                        // Applying total distance effect to horse's speed ( tiredness )
                        horse.setSpeed(horse.getSpeed() * horse.getTotalDistanceMultiplier());

                        raceStart = true;
                    }

                    // Increments distance run by horse
                    horse.race();

                    // To check which horse is leading
                    if(horse.getDistance() > leadingHorse.getDistance()){
                        leadingHorse = horse;
                    }

                    // Get track distance and compare with horse run distance
                    if (horse.getDistance() >= track.getDistance()) {

                        // MESSAGE HORSE WON
                        System.out.println("We have a winner!");

                        // Sets winner with horse object
                        won = true;
                        winnerHorse = horse;
                        winnerHorse.addWin();

                        // Reset horse race data and add race for hods
                        for (Horse horseFinish : enrolledHorses) {
                            horseFinish.resetDistance();
                            horseFinish.resetSpeed();
                            horseFinish.addRace();
                        }

                        break;
                    }
                }

                //System.out.println("leading horse is " + leadingHorse.getName());

                Thread.sleep(1000);

                // Sends to all clients the leading horse during race
                server.broadcastMsg("Leading " + leadingHorse.getName());
            }

            // Sends to all clients the winner hoser
            server.broadcastMsg("raceOver " + winnerHorse.getName());

            // Pay to winners
            PaybackWinnings(winnerHorse);

            inRace = false;

            System.out.println("Winning horse: " + winnerHorse.getName());

            // Message to players about money
            System.out.println("Here have your money cheater!");
            System.out.println("You're a fucking looser!");

            // Restart and prepare for new race
            restartRace();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    // Pay clients what they won.
    private void PaybackWinnings(Horse winner) {

        Map<Client, Integer> winnerHorseBets = broker.getHorseBets(winnerHorse);

        if(winnerHorseBets == null) {
            System.out.println("winnerHorse is null");
            return;
        }

        // Makes payment to user by depositing in his wallet
        for (Map.Entry<Client, Integer> entry : winnerHorseBets.entrySet()){
            entry.getKey().getWallet().deposit(entry.getValue() * winner.getOdds());
            System.out.println(entry.getKey().getWallet().getBalance()+" "+entry.getKey().getName());
        }
    }

    // Restart client by cleaning and loading new variables
    public void restartRace() {

        won = false;

        // Clears all bets registered with broker
        broker.clearAllBets();

        // Initiate horses for race line
        this.enrolledHorses = new ArrayList<>();

        // Add X number of horses to our race line
        enrolledHorses.addAll(HorseFactory.getHorses(6));

        // Get track type randomly
        this.track = Track.random();

        // Get weather conditions randomly
        this.weather = Weather.random();

        // Get strategy type randomly
        this.strategy = Strategy.getStrategy();

        run();
    }

    // Register client bet with broker
    public void placeBet(Client client, int horse, int amount) {
        broker.registerBet(client, enrolledHorses.get(horse), amount);
    }

    // Returns horses set for race
    public List<Horse> getEnrolledHorses() {
        return enrolledHorses;
    }

    // Returns broker
    public Broker getBroker() {
        return broker;
    }

    // Checks if is in race
    public Boolean getInRace() {
        return inRace;
    }

    // Returns race track
    public Track getTrack() {
        return track;
    }

    // Returns race weather conditions
    public Weather getWeather() {
        return weather;
    }
}
