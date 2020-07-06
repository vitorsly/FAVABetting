package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.Utils;
import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

public class LeadingHorseMessage implements Message {
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
                    "What an incredible race.",
                    "It may come to a photo finish.",
                    "It is a neck and neck race here today.",
                    "There he goes running tight on the inside turn.",
                    "What a horse.",
                    "#2 is finally hitting his stride.",
                    "What a beautiful animal.",
                    "Its going to come down to the wire.",
                    "Race sponsored by GitBusters Team Alpha.",
                    "#3 hasn't been running to well lately.",
                    "First out the gate, let's see if he can go all the way.",
                    "Alpha Team hopes everyone is enjoying their day at the races."
            };

            String fun = funPhrases[Utils.getRandom(funPhrases.length)];
            client.getGraphics().paintLeadingHorse(msgSplit[1]);
            client.getGraphics().writeStatus("The horse: " + msgSplit[1] + " is in the lead\n" + fun);

        }
    }
}
