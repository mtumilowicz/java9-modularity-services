# java9-modularity-services
The main goal of this project is to explore `services` based on `Java 9` 
`modularity`:  

* **uses**
* **provides** X **with** Y;

_Reference_: [Java 9 Modularity](https://www.amazon.com/Java-Modularity-Developing-Maintainable-Applications/dp/1491954167)  

## project structure
* **bot** - exploring `uses` and default service implementation
* **fenchman**, **spaniard** - exploring `provides X with Y`
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

## project content