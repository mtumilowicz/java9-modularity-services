package bot;

/**
 * Created by mtumilowicz on 2018-05-12.
 */
public class Englishman implements Bot {
    public Englishman() {
    }

    @Override
    public void greeting() {
        System.out.println("Good morning.");
    }

    @Override
    public String language() {
        return "english";
    }
}
