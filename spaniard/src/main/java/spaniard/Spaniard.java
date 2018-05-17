package spaniard;

import bot.Bot;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class Spaniard implements Bot {
    private Spaniard() {
    }

    @Override
    public void greeting() {
        System.out.println("Buenos días.");
    }

    @Override
    public String language() {
        return "spanish";
    }

    public static class Factory {
        public static Spaniard provider() {
            return new Spaniard();
        }
    }
}
