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

CREATE TABLE disc_info (
id int not null AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(30) not null);


CREATE TABLE disc_tracks (
disc_id int not NULL,
track_id int not null,
PRIMARY KEY (id, track_id),
FOREIGN KEY (track_id) references compositions (id) on UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (disc_id) references disc_info (id) on UPDATE CASCADE ON DELETE CASCADE
);

INSERT into composers (name) values ('Sting'), ('Bon Jovi'), ('Madonna'), ('Beatles'), ('Eagles'), ('Pink Floyd'),
('Modern Talking'), ('Prince'), ('Michael Jackson'), ('Abba');

select * from composers order by id; 


insert into styles (title) values ('rock'), ('pop'), ('jazz'), ('raggie'), ('rap'), ('funk'), ('classic');

select * from styles; 

insert into compositions (title, composer, style, length_sec)
values ('desert rose', 1, 2, 243),
       ('it''s my life', 2, 1, 212),
       ('crazy for you', 3, 2, 189),
       ('frozen', 3, 2, 250),
       ('always', 2, 1, 180),
       ('yesterday', 4, 2, 190),
       ('cherry lady', 7, 2, 215),
       ('billie jean', 9, 2, 193),
       ('dancing queen', 10, 4, 233),
       ('hotel california', 5, 1, 200),
       ('another brick in the wall', 6, 1, 170);
       
       
       INSERT INTO disc_info (title)
       VALUES ('Sting - the best'),
       ('Euro songs ''80'),
       ('Madonna 1985');
       
       INSERT into disc values (
       1,1),
       (1,2),
       (1,3),
       (1,4);
       
       INSERT into disc values (
       2,5),
       (2,6),
       (2,7),
       (2,8);
       
       alter TABLE disc
       add COLUMN title VARCHAR(30);
       
       
       












