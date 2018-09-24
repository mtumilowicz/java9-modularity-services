# java9-modularity-services
The main goal of this project is to explore `services` based on `Java 9` 
`modularity`:  

* **uses**
* **provides** X **with** Y;

_Reference_: [Java 9 Modularity](https://www.amazon.com/Java-Modularity-Developing-Maintainable-Applications/dp/1491954167)  

## project structure
* **bot** - exploring `uses` and default service implementation
* **frenchman**, **spaniard** - exploring `provides X with Y`
* **client** - mock of `GUI`
## project description
* Services allow modules to provide implementations without explicitly 
exporting them (the module system has special privileges to reach into 
the provider module to instantiate the nonexported implementation class 
on behalf of the consumer).  
* Consumers of the service can use instances of this implementation 
class without having access to it directly.  
* The only shared type between provider and consumer is the service type 
(most often an interface).
* **provides** X **with** Y - `Y` is implementation of `X`, and is 
exposed externally as a service type.
* uses - consuming a service in the `Java 9` module system is quite 
straightforward: we add a `uses` clause to `module-info.java` and we get 
all available service instances by `ServiceLoader.load(X.class)`, where 
`X` is a service interface.
* Service implementation could be provided by a module that we don’t 
have on the module path at compile-time (providers and consumers are 
bound only at run-time).

## project content
### bot
```
module services.bot {
    requires com.google.common;

    exports bot;
    exports bot.factory;

    uses bot.Bot;
    
    provides bot.Bot with bot.Englishman;
}
```
All below examples are from `BotFactory`.  
* Example of obtaining all available services instances of `Bot` 
interface:
    ```
    return ImmutableList.copyOf(ServiceLoader.load(Bot.class));
    ```
* Instances are created for all the provider types that have been 
discovered for the requested `Bot` interface.  
    `ServiceLoader` declaration:
    ```
    public static <S> ServiceLoader<S> load(Class<S> service)
    ```
    so simple calling:
    ```
    ServiceLoader.load(Bot.class)
    ```
    is not creating instances. You should do:
    ```
    ServiceLoader.load(Bot.class).stream().map(ServiceLoader.Provider::get)
    ```
* From java-doc:
    ```
    Returns an instance of the provider.

    @throws ServiceConfigurationError
    If the service provider cannot be instantiated, or in the case of a 
    provider factory, the public static provider() method returns null or 
    throws an error or exception.
    ```
* Example of filtering all services to find `Bot` with `language`:
    ```
    public static final Bot get(String language) {
        return getAllBots()
            .stream()
            .filter(x -> Objects.equals(x.language(), language))
            .findAny()
            .orElseThrow(() -> new LanguageNotSupportedException(language + " is not supported yet."));
    }
    ```
* Example of providing default implementation if no service is available:
    ```
    public static final Bot getOrDefault(String name) {
        return getAllBots()
            .stream()
            .filter(x -> Objects.equals(x.language(), name))
            .findAny()
            .orElse(new Englishman());
    }
    ```
* The following example loads the first available service provider.  
    If no service providers are located then it uses a default 
    implementation:
    ```
    return ServiceLoader.load(Bot.class).findFirst().orElse(new Englishman());
    ```

### client
Mocks GUI: displays all languages to choose and then load the `Bot` that 
welcome you in chosen language.
```
module services.client {
    requires services.bot;
}
```
As you see - we only need `requires` on a base module with interface 
`Bot`.

___
Service instances can be created in **three** ways.  
Implementation class must have either:  
    • a public no-arg constructor  
    • static provider method  
    • factory with static provider method
### frenchman
`Frenchman` class has private constructor and public static `provide()` 
method.
```
module services.frenchman {
    requires services.bot;
    
    provides bot.Bot with frenchman.Frenchman;
}
```
### spaniard
`Spaniard` class has private constructor and we have public factory 
class with `public static provide()` method.
```
module services.spaniard {
    requires services.bot;

    provides bot.Bot with spaniard.Spaniard.Factory;
}
```