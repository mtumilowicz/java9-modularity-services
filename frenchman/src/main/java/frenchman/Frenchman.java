package frenchman;

import bot.Bot;

/**
 * Created by mtumilowicz on 2018-05-13.
 */
public class Frenchman implements Bot {
    private Frenchman() {
    }

    @Override
    public void greeting() {
        System.out.println("Bonjour.");
    }

    @Override
    public String language() {
        return "french";
    }
    
    public static Frenchman provider() {
        return new Frenchman();
    }
}
