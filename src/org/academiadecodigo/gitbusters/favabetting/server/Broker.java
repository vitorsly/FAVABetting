package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    // Bets container which allows players to have multiple bets
    private Map<Client, Map<Horse, Integer>> clientsBets;

    // Bets container which allows players to have multiple bets
    private Map<Horse, Map<Client, Integer>> horsesBets;

    public Broker() {
        this.clientsBets = new HashMap<>();
    }

    // TODO: When client connects to server we register client with the broker
    // Registers client with broker
    public void registerClient(Client client) {
        this.clientsBets.put(client, new HashMap<>());
    }

    // Add new bet to client
    public void setBet(Client client, Horse horse, Integer amount) {
        this.clientsBets.get(client).put(horse, amount);
        this.horsesBets.get(horse).put(client, amount);
    }

    // Returns all clients bets
    public Map<Client, Map<Horse, Integer>> getAllClientsBets() {
        return this.clientsBets;
    }

    // Returns client bets
    public Map<Horse, Integer> getClientBets(Client client) {
        return this.clientsBets.get(client);
    }

    // Returns all horses bets
    public Map<Horse, Map<Client, Integer>> getAllHorsesBets() {
        return this.horsesBets;
    }

    // Returns horse bets
    public Map<Client, Integer> getHorseBets(Horse horse) {
        return this.horsesBets.get(horse);
    }
}
