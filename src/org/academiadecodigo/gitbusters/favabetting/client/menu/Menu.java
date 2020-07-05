package org.academiadecodigo.gitbusters.favabetting.client.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu {

    private Prompt prompt;
    private Client client;
    private List<String> transactions = new ArrayList<String>();
    private List<String> playerList = new ArrayList<String>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public Menu(Client client) {

        this.client = client;
        this.prompt = new Prompt(System.in, System.out);
        presentStartImage();

    }

    public void insertNameMenu() {

        String name = getStringInput("Insert your name: ", "Invalid name...");

        client.sendMessage("name " + name);

    }

    public void presentStartImage() {

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
        mainMenu();
    }

    public void makeBetMenu(String[] horseList,String weather,String track) {
        executor.submit(new BetMenu(horseList,weather,track));
    }

    public void mainMenu() {
        executor.submit(new MainMenu());
    }

    private void printPlayers() {

        for (String player : playerList) {
            System.out.println(player);
        }

    }

    private void changeName() {

        String newName = getStringInput("Insert new name: ", "Invalid name..");

        client.sendMessage("name " + newName);

    }

    public void saveTransaction(String msg) {

        String transaction = msg.substring(5);

        transactions.add(transaction);

    }

    public void printTransactions() {

        for (String transaction : transactions) {
            new Print(transaction);
        }

        mainMenu();

    }

    private int buildMenu(String[] options, String message, String error) {

        MenuInputScanner mainMenu = new MenuInputScanner(options);
        mainMenu.setError(error);
        mainMenu.setMessage(message);

        return prompt.getUserInput(mainMenu);

    }

    public void makeInfluenceRaceMenu(String[] cheatList) {

        executor.submit(new InfluenceRaceMenu(cheatList));
    }

    private int getIntInput(String message, String errorMessage) {

        IntegerInputScanner insertInt = new IntegerInputScanner();
        insertInt.setMessage(message);
        insertInt.setError(errorMessage);

        return prompt.getUserInput(insertInt);

    }

    private String getStringInput(String message, String errorMessage) {

        StringInputScanner insertString = new StringInputScanner();
        insertString.setMessage(message);
        insertString.setError(errorMessage);

        return prompt.getUserInput(insertString);

    }

    public void influenceRace() {
        client.sendMessage("CheatShop");
    }

    public class MainMenu implements Runnable {

        @Override
        public void run() {
            String[] options = {"View balance", "Make a bet", "Influence Race", "Transactions", "Change name", "Chat Lounge", "Quit"};

            switch (buildMenu(options, "Main Menu", "Invalid option")) {

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
                    chatMessage();
                    break;
                case 7:
                    client.sendMessage("quit");
                    break;
                default:
                    System.out.println("Something went terribly wrong...");
            }
        }
    }

    private void chatMessage() {

        String message = getStringInput("Write your message: ","Invalid message");

        client.sendMessage("chat #" + message);

    }

    public class BetMenu implements Runnable {

        private String[] horseList;
        private String weather;
        private String track;

        BetMenu(String[] horseList, String weather, String track) {
            this.horseList = horseList;
            this.weather = weather;
            this.track = track;
        }

        @Override
        public void run() {
            String[] horses = new String[7];

            for (int i = 0; i < horseList.length; i++) {
                String[] splittedHorse = horseList[i].split("#");
                horses[i] = "Name: " + splittedHorse[0] + " | Description: " + splittedHorse[1] + " | Odd: " + splittedHorse[2]
                        + " | Wins: " + splittedHorse[3] + " | Races: " + splittedHorse[4];
            }

            horses[6] = "Back";

            int horse = buildMenu(horses, "Track: " + track + " | Weather: " + weather +
                    "\n" + "Choose your horse:", "Invalid option");

            if (horse == 7) {
                mainMenu();
                return;
            }

            int amount = getIntInput("How much do you wanna bet? ", "Invalid amount");

            client.sendMessage("bet " + horse + " " + amount);
        }
    }

    public class InfluenceRaceMenu implements Runnable {

        private String[] cheatsAndHorses;

        public InfluenceRaceMenu(String[] cheatsAndHorses) {

            this.cheatsAndHorses = cheatsAndHorses;
        }

        @Override
        public void run() {


            String[] cheats = cheatsAndHorses[0].split("%");
            String[] horses = cheatsAndHorses[1].split("%");

            String[] cheatList = new String[6];
            String[] horseList = new String[7];


            for (int i = 0; i < cheats.length; i++) {
                String[] splittedCheat = cheats[i].split("#");
                cheatList[i] = "Name: " + splittedCheat[0] + " | Description: " + splittedCheat[1] + " | Price: " + splittedCheat[2] + "$";
            }

            cheatList[5] = "Back";

            int cheat = buildMenu(cheatList, "Choose your cheat: ", "Invalid option");

            if (cheat == 6) {
                mainMenu();
                return;
            }

            for (int i = 0; i < horses.length; i++) {
                String[] splittedHorse = horses[i].split("#");
                horseList[i] = "Name: " + splittedHorse[0] + " | Description: " + splittedHorse[1] + " | Odd: " + splittedHorse[2]
                        + " | Wins: " + splittedHorse[3] + " | Races: " + splittedHorse[4];
            }

            horseList[6] = "Back";


            int horse = buildMenu(horseList, "On which horse do you want to apply your cheat? ", "Invalid option");

            if (horse == 7) {
                makeInfluenceRaceMenu(cheatsAndHorses);
            }

            client.sendMessage("cheat " + cheat + " " + horse);


        }
    }
}
