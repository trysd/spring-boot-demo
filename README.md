# run
```
mvn spring-boot:run
OR
./mvnw spring-boot:run
```

# SQL for PostgreSQL
```
CREATE TABLE animal (
id serial,
grp text,
kind text,
age integer,
name text DEFAULT NULL
);

INSERT INTO animal
(grp, kind, age)
VALUES
('aaa', 'cat', 1)
,('aaa', 'dog', 2)
,('aaa', 'fox', 3)
,('bbb', 'cat', 4)
,('bbb', 'dog', 5)
,('bbb', 'fox', 6)
,('mmm', 'monkey', 10)
```

# debug command
```
mvn clean package && java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -jar ./target/demo.example-0.0.1.jar
```

# devtool
Template updates are mild as compilation does not run.

#
..