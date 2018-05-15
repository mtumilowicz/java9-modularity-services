package factory;

import bot.Bot;
import bot.BotType;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class BotFactory {
    public static final Bot get(String name) {
        try {
            return Bot.getBots().stream()
                    .filter(x -> Objects.equals(x.type(), BotType.valueOf(StringUtils.upperCase(name))))
                    .findAny()
                    .get();
        } catch (IllegalArgumentException ex) {
            throw new LanguageNotSupportedException(name + " is not supported yet.");
        }
    }
    
    public static final BotType[] getSupportedLanguages() {
        return BotType.values();
    }
}
