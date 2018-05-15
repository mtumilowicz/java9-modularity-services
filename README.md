# java9-modularity-services
The main goal of this project is to explore `services` based on `Java 9` 
`modularity`:  

* **uses**
* **provides** X **with** Y;

_Reference_: [Java 9 Modularity](https://www.amazon.com/Java-Modularity-Developing-Maintainable-Applications/dp/1491954167)  

## project description
Services allow a module to provide implementations to other modules 
without exporting the concrete implementation class. The module system 
has special privileges to reach into the provider module to instantiate 
the nonexported implementation class on behalf of the consumer. This 
means consumers of the service can use instances of this implementation 
class, without having access to it directly. Also, a service consumer 
doesn’t know which module provided an implementation, nor does it need 
to. Because the only shared type between provider and consumer is the 
service type (most often an interface).


## project content