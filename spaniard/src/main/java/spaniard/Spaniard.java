package spaniard;

import bot.Bot;
import bot.BotType;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class Spaniard implements Bot {
    private Spaniard() {
    }

    @Override
    public void greeting() {
        System.out.println("Buenos días!");
    }

    @Override
    public BotType type() {
        return BotType.SPANISH;
    }

    public static class Factory {
        public static Spaniard provider() {
            return new Spaniard();
        }
    }
}
