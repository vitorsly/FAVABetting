package org.academiadecodigo.gitbusters.favabetting.server.weather;

import org.academiadecodigo.gitbusters.Utils;

public enum Weather {

    // Weather conditions that influences the race and horse's speed

    BASIC("Basic","Weather is perfect. It's a perfect day for racing! ",WeatherClass.NONE, 1),
    BREEZY("Breezy","Wind is blowing a little. Nothing too serious.",WeatherClass.WIND, 1),
    WINDY("Windy","Wind is really pushing the smaller horses around!",WeatherClass.WIND, 2),
    WINDSTORM("Windstorm","It looks like a hurricane in here!",WeatherClass.WIND, 3),
    DRIZZLING("Drizzling","A little rain pouring, but nothing can stop horse racing!",WeatherClass.RAIN, 1),
    RAINY("Rainy","That's some serious pour. Might make the terrain a little slippery.",WeatherClass.RAIN, 2),
    RAINSTORM("Rainstorm","I hope you brought your reinforced umbrellas, folks.",WeatherClass.RAIN, 3),
    WARM("Warm","Nice summer weather. Hope the horses don't get too hot racing.",WeatherClass.WARM, 1),
    HOT("Hot","I wouldn't be wanting to do exercise in this weather to be honest.",WeatherClass.WARM, 2),
    SCORCHING("Scorching","Jesus christ it's hot in here!",WeatherClass.WARM, 3),
    BRIGHT("Bright","Sun is shining bright in the sky! Hope it doesn't hit the poor horses in the eyes.",WeatherClass.SUNNY, 1),
    DAZZLING("Dazzling","I can hardly see the horses with all the sun hitting my eyes!",WeatherClass.SUNNY, 2),
    BLINDING("Blinding","This is a time where horse-sunglasses really should be a thing.",WeatherClass.SUNNY, 3),
    CHILLY("Chilly","This is certainly sweater weather folks.",WeatherClass.COLD, 1),
    COLD("Cold","Hope your brought a jacket. Hope the horses don't get too cold.",WeatherClass.COLD, 2),
    FROSTY("Frosty","Damn, I think I'm getting frostbite in here!",WeatherClass.COLD, 3),
    OVERCAST("Overcast","Clouds making things a little dark, but nothing we can't handle.",WeatherClass.MISTY, 1),
    MISTY("Misty","Kinda hard to see the track over here. Hope the horses know where they're going.",WeatherClass.MISTY, 2),
    FOGGY("Foggy","Try this folks, stretch your arm in front of you and check if you can see your fingers!",WeatherClass.MISTY, 3),
    TWILIGHT("Twilight","Sun's setting. Might be a little dark for our horses.",WeatherClass.NIGHT, 1),
    NIGHT("Night","Due to budget constraints are track is only lit by the moon and the stars.",WeatherClass.NIGHT, 2),
    DARKNESS("Dark","I can't see anything. Time to bring out the night vision goggles!",WeatherClass.NIGHT, 3);

    private String name;
    private String description;
    private WeatherClass weatherClass;
    private int power;

    Weather(String name, String description, WeatherClass weatherClass, int power) {
        this.name = name;
        this.description = description;
        this.weatherClass = weatherClass;
        this.power = power;
    }

    // Returns weather conditions randomly
    public static Weather random(){
        int random = Utils.getRandom(Weather.values().length);
        return Weather.values()[random];
    }

    public static Weather getWeatherType(int value) {
        return Weather.values()[value];
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public WeatherClass getWeatherClass() {
        return weatherClass;
    }

    public int getPower() {
        return power;
    }
}
