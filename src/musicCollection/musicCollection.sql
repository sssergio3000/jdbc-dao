drop DATABASE IF EXISTS musiccollection;
CREATE DATABASE musiccollection;

use musiccollection;

create TABLE composers (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) UNIQUE
);


create TABLE styles (
id int not NULL AUTO_INCREMENT PRIMARY KEY,
title varchar(30)
);

CREATE TABLE compositions (
id INT not NULL AUTO_INCREMENT PRIMARY KEY,
title varchar(100) not NULL,
composer INT not null,
style int not null,
length_sec int not null,
FOREIGN KEY (composer) REFERENCES composers (id) on UPDATE cascade ON DELETE CASCADE,
FOREIGN KEY (style) REFERENCES styles (id) on UPDATE cascade ON DELETE CASCADE
);

CREATE TABLE disc (
id int not NULL,
track_id int not null,
PRIMARY KEY (id, track_id),
FOREIGN KEY (track_id) references compositions (id)
);

INSERT into composers (name) values ('Sting'), ('Bon Jovi'), ('Madonna'), ('Beatles'), ('Eagles'), ('Pink Floyd'),
('Modern Talking'), ('Prince'), ('Michael Jackson'), ('Abba');

select * from composers order by id; 


insert into styles (title) values ('rock'), ('pop'), ('jazz'), ('raggie'), ('rap'), ('funk'), ('classic');

select * from styles; 

-- insert into compositions








