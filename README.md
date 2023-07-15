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
name text DEFAULT NULL,
version integer DEFAULT 0
);

INSERT INTO animal
(grp, kind, name, age)
VALUES
('aaa', 'cat', 'tama', 1)
,('aaa', 'dog', 'taro', 2)
,('aaa', 'fox', 'kon', 3)
,('mmm', 'monkey', 'uki', 10)
```

# jar exec
```
java -Xmx50m -Xms50m -jar ./target/demo.example-0.0.1.jar
```

# debug command
```
mvn clean package && java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -jar ./target/demo.example-0.0.1.jar
```

# devtool
Template updates are mild as compilation does not run.

# docker

## app
docker build -t app:latest .
docker rm -f app && docker run --rm --net n01 --name app -d -p 80:80 app:latest

## DB
cd pg && docker-compose -f docker-pg.yml up --build
