package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.Utils;
import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class LeadingHorse implements Messages {

    @Override
    public void run(Client client, String msg) {

        String[] msgSplit = msg.split(" ");

        if(msgSplit.length > 1) {

            String[]funPhrases = {
              "What a lovely day for a race.",
              "That horse is on fire today.",
              "Heard number 5 might surprise us today.",
              "This is going to be a tough race.",
              "Oh no, did you see that.",
              "What an incredible race."
            };

            String fun = funPhrases[Utils.getRandom(funPhrases.length)];

            new Print("The horse :" + msgSplit[1] + " is in the lead\n" + fun);

        } else{
            new Print("2222222222222222222222222222222222222222222222");
        }
    }
}
