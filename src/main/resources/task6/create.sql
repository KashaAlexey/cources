CREATE TABLE author (id NUMBER(7) auto_increment NOT NULL PRIMARY KEY, first_name VARCHAR2(50), last_name VARCHAR2(50) NOT NULL, date_of_birth DATE);
create table book (id NUMBER(7) auto_increment NOT NULL PRIMARY KEY, author_id NUMBER(7) NOT NULL, name VARCHAR2(50) NOT NULL, published_in NUMBER(7) NOT NULL, CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author(id));