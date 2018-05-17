package factory;

import bot.Bot;
import bot.Englishman;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * Created by mtumilowicz on 2018-05-14.
 */
public class BotFactory {
    public static final Bot get(String name) {
        return getAll()
                .stream()
                .filter(x -> Objects.equals(x.language(), name))
                .findAny()
                .orElseThrow(() -> new LanguageNotSupportedException(name + " is not supported yet."));
    }
    
    public static final Bot getOrDefault(String name) {
        return getAll()
                .stream()
                .filter(x -> Objects.equals(x.language(), name))
                .findAny()
                .orElse(new Englishman());
    }

    public static final List<String> supportedLanguages() {
        return getAll().stream()
                .map(Bot::language)
                .collect(Collectors.toList());
    }

    private static List<Bot> getAll() {
        return getBots().stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    private static ServiceLoader<Bot> getBots() {
        return ServiceLoader.load(Bot.class);
    }

    /**
     * The following example loads the first available service provider. 
     * If no service providers are located then it uses a default implementation.
     */
    static Bot getAny() {
        return ServiceLoader.load(Bot.class).findFirst().orElse(new Englishman());
    }
}
