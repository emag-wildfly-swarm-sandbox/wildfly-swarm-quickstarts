# WildFly-Swarm JAX-RS + CDI + JPA sample

* JDK 8
* Maven 3.1.0 or Later

## Usage

### Build & Run

``` sh
$ mvn clean package && java -jar target/jaxrs-cdi-jpa-*-swarm.jar
```

### Access API

#### Get all employees

``` sh
$ curl localhost:8080/employees
[{"id":1,"name":"emp01"},{"id":2,"name":"emp02"}]
```

#### Create new employee

``` sh
$ curl -X POST -H "Content-Type: application/json" -d '{"name" : "some-emp"}' localhost:8080/employees -v
...
< Location: http://localhost:8080/employees/3
```

```sh
$ curl localhost:8080/employees/3
{"id":3,"name":"some-emp"}
```

#### Update an employee info

``` sh
$ curl -X PUT -H "Content-Type: application/json" -d '{"name" : "updated-emp"}' localhost:8080/employees/3
```

``` sh
$ curl localhost:8080/employees/3
{"id":3,"name":"updated-emp"}
```

#### Delete an employee

``` sh
curl -X DELETE localhost:8080/employees/3 -v
...
< HTTP/1.1 204 No Content
```

``` sh
$ curl localhost:8080/employees/3 -v
< HTTP/1.1 404 Not Found
```

#### Delete all employess


``` sh
curl -X DELETE localhost:8080/employees -v
...
< HTTP/1.1 204 No Content
```

``` sh
$ curl localhost:8080/employees
[]
```
