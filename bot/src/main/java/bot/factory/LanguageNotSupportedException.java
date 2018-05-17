package bot.factory;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class LanguageNotSupportedException extends RuntimeException {

    LanguageNotSupportedException(String message) {
        super(message);
    }
}
