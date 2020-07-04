package org.academiadecodigo.gitbusters.favabetting.server;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    // Bets container which allows players to have multiple bets
    // String - client name ( can be replaced by integer (client ID) or client object )
    // Integer - Horse ID ( can be replaced by string (horse name) or horse object )
    // Integer - clients bet amount
    private Map<String, Map<Integer, Integer>> bets;

    public Broker() {
        this.bets = new HashMap<>();
    }

    // TODO: When client connects to server we register client with the broker
    // Registers client with broker
    public void registerClient(String client) {
        this.bets.put(client, new HashMap<>());
    }

    // Returns all bets
    public Map<String, Map<Integer, Integer>> getAllBets() {
        return bets;
    }

    // Returns client bets
    public Map<Integer, Integer> getClientBets(String client) {
        return bets.get(client);
    }

    // Add new bet to client
    public void setClientBet(String client, Integer horse, Integer amount) {
        bets.get(client).put(horse, amount);
    }
}
