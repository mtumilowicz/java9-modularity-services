package bot.factory;

import bot.Bot;
import bot.Englishman;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class BotFactory {
    public static final Bot get(String language) {
        return getAllBots()
                .stream()
                .filter(x -> Objects.equals(x.language(), language))
                .findAny()
                .orElseThrow(() -> new LanguageNotSupportedException(language + " is not supported yet."));
    }
    
    public static final Bot getOrDefault(String language) {
        return getAllBots()
                .stream()
                .filter(x -> Objects.equals(x.language(), language))
                .findAny()
                .orElse(new Englishman());
    }

    public static final List<String> supportedLanguages() {
        return getAllBots().stream()
                .map(Bot::language)
                .collect(Collectors.toList());
    }

    private static List<Bot> getAllBots() {
        return ImmutableList.copyOf(ServiceLoader.load(Bot.class));
    }
    
    public static Bot getAny() {
        return ServiceLoader.load(Bot.class).findFirst().orElse(new Englishman());
    }
}
