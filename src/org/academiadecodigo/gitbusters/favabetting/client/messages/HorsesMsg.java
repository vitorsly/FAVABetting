package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class HorsesMsg implements Messages {

    @Override
    public void run(Client client, String msg) {

        String str=msg.substring(10);
        String[] horseWeatherAndTrack = str.split("\\$");
        String weather = horseWeatherAndTrack[1];
        String track = horseWeatherAndTrack[2];
        String[] horsesByLine = horseWeatherAndTrack[0].split("%");

        client.getMenu().makeBetMenu(horsesByLine,weather,track);
    }
}
