package bot;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by mtumilowicz on 2018-05-12.
 */
public interface Bot {
    
    void greeting();
    
    BotType type();
    
    static List<Bot> getBots() {
        return Lists.newArrayList(ServiceLoader.load(Bot.class));
    }

    /**
     * The following example loads the first available service provider. 
     * If no service providers are located then it uses a default implementation.
     */
    static Bot getAny() {
        return ServiceLoader.load(Bot.class).findFirst().orElse(Englishman.provider());
    }
}
