set -e

psql -U postgres postgres << EOL

CREATE TABLE animal (
id serial PRIMARY KEY,
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

EOL
