/**
 * Created by mtumilowicz on 2018-05-14.
 */
module services.spaniard {
    requires services.bot;

    provides bot.Bot with spaniard.Spaniard.Factory;
}