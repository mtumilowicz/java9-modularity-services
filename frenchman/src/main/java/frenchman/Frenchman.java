package frenchman;

import bot.Bot;
import bot.BotType;

/**
 * Created by mtumilowicz on 2018-05-13.
 */
public class Frenchman implements Bot {
    @Override
    public void greeting() {
        System.out.println("Bonjour.");
    }

    @Override
    public BotType type() {
        return BotType.FRENCH;
    }
}
