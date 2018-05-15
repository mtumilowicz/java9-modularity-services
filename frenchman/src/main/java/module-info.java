/**
 * Created by mtumilowicz on 2018-05-12.
 */
module services.frenchman {
    requires services.bot;
    
    provides bot.Bot with frenchman.Frenchman;
}