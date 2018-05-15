package bot;

/**
 * Created by mtumilowicz on 2018-05-12.
 */
public class Englishman implements Bot {
    private Englishman() {
    }

    @Override
    public void greeting() {
        System.out.println("Good morning.");
    }

    @Override
    public BotType type() {
        return BotType.ENGLISH;
    }
    
    public static Englishman provider() {
        return new Englishman();
    }
}
