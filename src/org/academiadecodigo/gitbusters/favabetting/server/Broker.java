package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker {

    // Bets container which allows players to have multiple bets
    private Map<Client, Map<Horse, Integer>> clientsBets;
    private Map<Horse, Integer> horseAmount;
    private List<BrokerBet> betlist=new ArrayList<>();

    // Bets container which allows players to have multiple bets
    private Map<Horse, Map<Client, Integer>> horsesBets;
    private Map<Client, Integer> clientAmount;

    public Broker() {

        // Clients bets controller
        this.clientsBets = new HashMap<>();
        this.horseAmount = new HashMap<>();

        // Horses bets controller
        this.horsesBets = new HashMap<>();
        this.clientAmount = new HashMap<>();
    }

    // Registers client with broker
    public void registerClient(Client client) {
        this.clientsBets.put(client, new HashMap<>());
    }

    // Remove client from broker list
    public void unregisterClient(Client client) {
        clientsBets.remove(client);
    }

    // Add new bet to client
    public void registerBet(Client client, Horse horse, Integer amount) {

        System.out.println("DEBUG> BET CLIENT: " + client.getName());
        System.out.println("DEBUG> BET horse: " + horse.getName());
        System.out.println("DEBUG> BET amount: " + amount);

        betlist.add(new BrokerBet(client,horse,amount));

//        this.horseAmount.put(horse, amount);
//        this.clientsBets.put(client, horseAmount);
//
//        this.clientAmount.put(client, amount);
//        this.horsesBets.put(horse, clientAmount);
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
    // When we need all bets mad on a horse just get by horse object
    // broker.getHorseBets(horse);
    public Map<Client, Integer> getHorseBets(Horse horse) {
        return this.horsesBets.get(horse);
    }

    // Reset all containers
    public void clearAllBets() {
        this.horsesBets.clear();
        this.clientsBets.clear();
        this.horseAmount.clear();
        this.clientAmount.clear();
        betlist.clear();
    }

    // Pay clients what they won.
    public void PaybackWinnings(Horse winner) {

        for (BrokerBet bet:betlist){
            if(bet.isClientWinner(winner)){
                bet.getClient().getWallet().deposit(bet.getAmount()*bet.getHorse().getOdds());
            }
        }

        //System.out.println("DEBUG: Winner hourse: " + winner.getName());

//        Map<Client, Integer> winnerHorseBets = horsesBets.get(winner);
//
//        //System.out.println("DEBUG: All Horse Bets: " + winnerHorseBets);
//
//        if(winnerHorseBets == null) {
//            System.out.println("winnerHorse is null");
//            return;
//        }
//
//        // Makes payment to user by depositing in his wallet
//        for (Map.Entry<Client, Integer> entry : winnerHorseBets.entrySet()){
//            System.out.println(entry.getKey().getName()+" "+entry.getValue());
//            entry.getKey().getWallet().deposit(entry.getValue() * winner.getOdds());
//        }
    }

    public class BrokerBet{
        private Client client;
        private Horse horse;
        private int amount;
        public BrokerBet(Client client,Horse horse,int amount){
            this.client=client;
            this.horse=horse;
            this.amount=amount;
        }

        public Boolean isClientWinner(Horse h){
            if(h==this.horse){
                return true;
            }else{
                return false;
            }
        }

        public int getAmount() {
            return amount;
        }

        public Client getClient() {
            return client;
        }

        public Horse getHorse() {
            return horse;
        }
    }
}
