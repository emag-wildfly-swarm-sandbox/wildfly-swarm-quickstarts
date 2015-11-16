# undertowjs

## Build & Run

``` sh
$ mvn clean package && java -jar ./target/undertowjs-swarm.jar
```

## Access the app

``` sh
$ curl localhost:8080/hello -v
...
< HTTP/1.1 200 OK
< Connection: keep-alive
< content-type: text/plain
< Content-Length: 11
< Date: Mon, 16 Nov 2015 14:06:17 GMT
< 
* Connection #0 to host localhost left intact
Hello World%                 
```