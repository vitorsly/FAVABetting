package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;
import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.graphics.Graphics;

public class HorsesMessage implements Message {

    @Override

    public void run(Client client, String msg) {

        String str = msg.substring(10);
        String[] horseWeatherAndTrack = str.split("\\$");
        String weather = horseWeatherAndTrack[1];
        String track = horseWeatherAndTrack[2];
        String[] horsesByLine = horseWeatherAndTrack[0].split("%");

        client.getGraphics().getArena().setText(track);
        client.getGraphics().getWeather().setText(weather);

        int iterator = 0;

        for (Graphics.HorseMenu horseMenu : client.getGraphics().getHorseList()) {
            String[] horseStr = horsesByLine[iterator].split("#");
            horseMenu.insertHorse(horseStr[0], horseStr[1], horseStr[2], horseStr[3], horseStr[4], iterator);
            iterator++;
        }
    }
}
