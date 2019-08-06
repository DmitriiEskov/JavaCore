CREATE TABLE Kuzov (
id serial primary key,
Name varchar(100) NOT NULL
);

CREATE TABLE Engine (
id serial primary key, 
Name varchar(100) NOT NULL
);

CREATE TABLE KorobkaPeredach (
id serial primary key, 
Name varchar(100) NOT NULL
);

CREATE TABLE Cars (
id serial primary key, 
Kuzov integer references Kuzov(id) NOT NULL,
Engine integer references Engine(id) NOT NULL,
KorobkaPeredach integer references KorobkaPeredach(id) NOT NULL
);

INSERT INTO Kuzov (Name) VALUES
(N'White'), (N'Black'), (N'Blue'), (N'Red');

INSERT INTO Engine (Name) VALUES 
(N'FX100'), (N'DS200'), (N'LK550');

INSERT INTO KorobkaPeredach (Name) VALUES
(N'Korobka111'), (N'Korobka222'), (N'Korobka333');

INSERT INTO Cars (Kuzov, Engine, KorobkaPeredach) VALUES 
(1, 1, 1),
(2, 1, 2),
(3, 3, 2);

SELECT c.id, e.name, k.name, kp.name FROM cars c
LEFT JOIN engine e ON c.engine=e.id
LEFT JOIN kuzov k ON c.kuzov=k.id
LEFT JOIN KorobkaPeredach kp ON c.KorobkaPeredach=kp.id;

--Не используемы двигатели
SELECT e.name AS Engines FROM Engine e 
LEFT JOIN Cars c ON c.engine=e.id
WHERE c.engine IS NULL;

--Не используемые кузовы
SELECT k.name FROM Kuzov k
LEFT JOIN Cars c ON c.kuzov=k.id
WHERE c.kuzov IS NULL;

--Не используемые коробки передач
SELECT kp.Name AS KorobkaPeredach FROM KorobkaPeredach kp
LEFT JOIN Cars c ON kp.id=c.KorobkaPeredach
WHERE c.KorobkaPeredach IS NULL;