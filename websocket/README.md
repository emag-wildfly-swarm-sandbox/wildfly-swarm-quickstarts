# WildFly-Swarm WebSocket sample

from [Undertow jsrwebsockets example](https://github.com/undertow-io/undertow/tree/master/examples/src/main/java/io/undertow/examples/jsrwebsockets)

## Requirements

* JDK 8
* Maven 3.1.0 or Later

## Usage

### Build & Run

``` sh
$ mvn clean package && java -jar target/websocket-swarm.jar
```

or

``` sh
$ mvn wildfly-swarm:run
```

### Access Chat

Open http://localhost:8080/ in your browser.
