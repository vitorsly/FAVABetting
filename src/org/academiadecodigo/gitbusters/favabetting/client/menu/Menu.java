package org.academiadecodigo.gitbusters.favabetting.client.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.gitbusters.favabetting.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Prompt prompt;
    private Client client;
    private List<String> transactions = new ArrayList<String>();
    private List<String> playerList = new ArrayList<String>();

    public Menu(Client client) {

        this.client = client;
        this.prompt = new Prompt(System.in,System.out);
        presentStartImage();

    }

    public void insertNameMenu(){

        String name = getStringInput("Insert your name: ", "Invalid name...");

        client.sendMessage("name " + name);

    }

    public void presentStartImage(){

        System.out.println("                                -.\n" +
                "                               |  \\\n" +
                "                               |   \\\n" +
                "                               F    L\n" +
                "                 |\"-._         F    L\n" +
                "                 |  `.`--.     L    |\n" +
                "                 J    `.  `.   |    |   __\n" +
                "                  \\     `.  `. J    |.-'_.-\n" +
                "                   \\      `.  \\ \\.-     `-. \n" +
                "      J\".           `.      \\  >'          `.\n" +
                "      |  \\            `-.    L/       `---.._\\\n" +
                "      J   L              `\"-/               |\n" +
                "       \\  |                J        / .-.   4\n" +
                "        J F                |       | / d8   |\n" +
                "         L\\                F         | 8P   J\n" +
                "         J L               |         `-'     `-.\n" +
                "         | |                L  .          .-    )\n" +
                "         | J                |   \\        . dP  / \n" +
                "         J  \\               |    `.       `-.-\"\n" +
                "          \\  >-\"\"\"\"-.      .F      >\"--.---._) \n" +
                "           >\"        \"\"--\"\"        |\n" +
                "          J                        F\n" +
                "          |                        L\n" +
                "          J                        |\n" +
                "           \\        L         `.   J\n" +
                "            )       | % |      | eJ\" u+L\n" +
                "           d\"      d\"  '|     :Fd\"     4\n" +
                "          P      u$\"b.  $r    $*L u@\".  F\n" +
                "          $  ?F\"\" 4L ^F\"\"$   F      zP $\n" +
                "          4F  N    *. %. ^  4     $#  zF\n" +
                "           #r \".    $  $ $  $   $$F :\"\n" +
                "           -F  $    ^k Jr@F $   $$$\"\n" +
                "            #. F     9$$$9  4\n" +
                "            '$$$          $  *\n" +
                "              ^\"          3ed$.\n" +
                "                           $$$#\n");

    }

    public void makeBetMenu(String[] horseList){

        String[] horses = new String[6];

        for ( int i = 0; i < horseList.length; i++){

            String[] splittedHorse = horseList[i].split("#");
            horses[i] = "Name: " + splittedHorse[0] + " | Description: " + splittedHorse[1] + " | Odd: " + splittedHorse[2]
                    + " | Wins: " + splittedHorse[3] + " | Races: " + splittedHorse[4];

        }

        int horse = buildMenu(horses,"Choose your horse:","Invalid option");

        int amount = getIntInput("Place your bet: ","Invalid amount");

        client.sendMessage("bet " + horse + " " + amount);

    }

    public void mainMenu(){





        String[] options = {"View balance", "Make a bet","Influence Race","Transactions","Change name","Check online players","Quit"};

        switch (buildMenu(options,"Main Menu","Invalid option")){

            case 1:
                client.sendMessage("balance");
                break;
            case 2:
                client.sendMessage("getHorses");
                break;
            case 3:
                influenceRace();
                break;
            case 4:
                printTransactions();
                break;
            case 5:
                changeName();
                break;
            case 6:
                printPlayers();
                break;
            case 7:
                client.sendMessage("quit");
                break;
            default:
                System.out.println("Something went terribly wrong...");
        }

    }

    private void printPlayers() {

        for (String player : playerList){
            System.out.println(player);
        }

    }

    private void changeName() {

        StringInputScanner insertName = new StringInputScanner();
        insertName.setMessage("Insert new name: ");

        String newName = prompt.getUserInput(insertName);

        client.sendMessage("name " + newName);

    }

    public void saveTransaction(String transaction) {

        transactions.add(transaction);

    }

    public void printTransactions(){

        for (String transaction : transactions){
            System.out.println(transaction);
        }

    }


    private int buildMenu(String[] options, String message, String error) {

        MenuInputScanner mainMenu = new MenuInputScanner(options);
        mainMenu.setError(error);
        mainMenu.setMessage(message);

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
