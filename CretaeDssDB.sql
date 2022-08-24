create database DSSDb;
use DSSDb;
create table admin (
  admin_id int not null auto_increment PRIMARY KEY,
  first_name varchar(50),
  last_name varchar(50),
  password varchar(50)
);

create table review (
  review_id INTEGER NOT NULL PRIMARY KEY,
  date_posted DATETIME,
  description VARCHAR(255),
  rating INTEGER,
  movie_id INTEGER
);

create table movies (
  movie_id INTEGER NOT NULL PRIMARY KEY,
  movie_title VARCHAR(255),
  movie_cost INTEGER,
  movie_year INTEGER
);

create table actors (
  actor_id BIGINT NOT NULL PRIMARY KEY,
  first_name varchar(255),
  last_name varchar(255),
  gennder CHAR(1),
  age INTEGER
);

create table movie_actor (
  ma_id INTEGER NOT NULL PRIMARY KEY,
  movie_id INTEGER NOT NULL,
  actor_id BIGINT NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
  FOREIGN KEY (actor_id) REFERENCES actors(actor_id)
);
