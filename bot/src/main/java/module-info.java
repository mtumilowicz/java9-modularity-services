/**
 * Created by mtumilowicz on 2018-05-12.
 */
module services.bot {
    requires com.google.common;

    exports bot;
    exports bot.factory;

    uses bot.Bot;
    
    provides bot.Bot with bot.Englishman;
}