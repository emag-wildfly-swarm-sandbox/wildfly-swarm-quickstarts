# WildFly-Swarm basic JAX-RS sample

* JDK 8
* Maven 3.1.0 or Later

## Usage

### Build & Run

``` sh
$ mvn clean package && java -jar target/jaxrs-*-swarm.jar
```

### Access API

``` sh
$ curl localhost:8080/what-time
Howdy at 2015-05-08T15:49:56.630
```
