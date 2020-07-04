package org.academiadecodigo.gitbusters.favabetting.client.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class Menu {

    private Prompt prompt;
    private Client client;

    public Menu(Client client) {

        this.client = client;
        this.prompt = new Prompt(System.in,System.out);

    }


    public void insertNameMenu(){

        String name = getStringInput("Insert your name: ", "Invalid name...");

        client.sendMessage("name " + name);

    }


    public void makeBetMenu(){

        int horse = getIntInput("Choose your horse: ","Invalid horse number");
        int amount = getIntInput("How much do you wanna bet: ","Invalid amount");

        client.sendMessage("bet " + horse + " " + amount);

    }


    public void mainMenu(){


        String[] options = {"View balance", "Make a bet","Influence Race","Transactions","Change name","Check online players"};

        switch (buildMenu(options)){

            case 1:
                client.sendMessage("balance");
                break;
            case 2:
                makeBetMenu();
                break;
            case 3:
                influenceRace();
                break;
            case 4:
                transactionsMenu();
                break;
            case 5:
                changeName();
                break;
            case 6:
                getPlayers();
                break;
        }

    }

    private void getPlayers() {


    }

    private void changeName() {

        StringInputScanner insertName = new StringInputScanner();
        insertName.setMessage("Insert new name: ");

        String newName = prompt.getUserInput(insertName);

        client.sendMessage("name " + newName);

    }

    private void transactionsMenu() {


    }


    private int buildMenu(String[] options) {

        MenuInputScanner mainMenu = new MenuInputScanner(options);
        mainMenu.setError("Invalid option");
        mainMenu.setMessage("Select an option:");

        return prompt.getUserInput(mainMenu);

    }

    private int getIntInput(String message, String errorMessage){

        IntegerInputScanner insertInt = new IntegerInputScanner();
        insertInt.setMessage(message);
        insertInt.setError(errorMessage);

        return prompt.getUserInput(insertInt);

    }

    private String getStringInput(String message, String errorMessage){

        StringInputScanner insertString = new StringInputScanner();
        insertString.setMessage(message);
        insertString.setError(errorMessage);

        return prompt.getUserInput(insertString);

    }

    public void influenceRace(){


    }

}
