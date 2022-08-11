-- DB切り替え
\c tododb

CREATE TABLE  users (
  id SERIAL NOT NULL,
  name VARCHAR(30),
  email VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE genres(
  id SERIAL NOT NULL,
  genrename VARCHAR(30),
  PRIMARY KEY (id)
);

CREATE TABLE  items (
  id SERIAL NOT NULL,
  userID INT,
  text VARCHAR(300),
  genreID INT,
  priority INT,   
  datetime DATE,
  status BOOLEAN,
  eventid VARCHAR(100),
  foreign key (userID) references users(id),
  foreign key (genreID) references genres(id),
  PRIMARY KEY (id)
);

CREATE TABLE  test (
  col1 VARCHAR(10),
  col2 VARCHAR(10),
  col3 VARCHAR(10),
  PRIMARY KEY (col1)
);
