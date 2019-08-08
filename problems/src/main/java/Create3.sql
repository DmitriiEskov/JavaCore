CREATE TABLE Type (
id serial primary key,
name varchar(100)
);

CREATE TABLE Product (
id serial primary key,
name varchar(100),
type_id integer references Type(id),
expired_date date,
price integer
);

INSERT INTO Type (Name) VALUES ('СЫР'), ('МОЛОКО'), ('МОРОЖЕНОЕ');

INSERT INTO Product (name, type_id, expired_date, price, quantity) VALUES
('Сыр', 1, '2019-09-23', 100, 6),
('Сыр2', 1, '2019-10-10', 150, 15),
('Сыр3', 1, '2019-12-11', 250, 0),
('Молоко', 2, '2019-11-1', 50, 3),
('Молоко2', 2, '2019-10-2', 240, 0),
('Молоко3', 2, '2019-09-3', 77, 0),
('Мороженое', 3, '2019-09-12', 240, 3),
('Мороженое', 3, '2019-12-24', 140, 3);

---1
SELECT p.*
FROM Product p, Type t
WHERE t.name='СЫР' AND t.id=p.type_id;

--2
SELECT * FROM Product pr WHERE pr.name LIKE '%Мороженое%';

--3
SELECT * FROM Product pr WHERE pr.expired_date BETWEEN '2019-09-01' AND '2019-09-30';

--4
SELECT pOne.* FROM Product pOne
INNER JOIN
(
	SELECT MAX(pr.price) AS price
	FROM Product pr
)
	pTwo ON pOne.price=pTwo.price;

--5
SELECT * FROM Product p, Type t WHERE t.Name='МОЛОКО' AND t.id=p.type_id;

--6
SELECT p.* FROM Product p, Type t WHERE (t.Name='МОЛОКО' OR t.Name='СЫР') AND t.id=p.type_id;

--7
SELECT * FROM Product WHERE quantity < 10;

--8
SELECT pr.*, t.name FROM Product pr LEFT JOIN Type t ON pr.type_id=t.id;