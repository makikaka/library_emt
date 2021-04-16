CREATE TABLE book (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) NOT NULL,
genre_id BIGINT UNSIGNED not NULL,
author_id bigint UNSIGNED,
available_copies int null
);

CREATE TABLE author (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) NOT NULL,
surname VARCHAR(100) NOT NULL,
country_id bigint UNSIGNED
);

CREATE TABLE country (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) NOT NULL,
continent VARCHAR(30) NOT NULL
);

CREATE TABLE genre (
id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) NOT NULL
);


ALTER TABLE book ADD CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author(id);
ALTER TABLE author ADD CONSTRAINT fk_author_country FOREIGN KEY (country_id) REFERENCES country(id);
ALTER TABLE book ADD CONSTRAINT fk_book_genre FOREIGN KEY (genre_id) REFERENCES genre(id);


INSERT INTO genre (name)
values ("NOVEL");
INSERT INTO genre (name)
values ("THRILER");
INSERT INTO genre (name)
values ("HISTORY");
INSERT INTO genre (name)
values ("FANTASY");
INSERT INTO genre (name)
values ("BIOGRAPHY");
INSERT INTO genre (name)
values ("CLASSICS");
INSERT INTO genre (name)
values ("DRAMA");

INSERT INTO country (name, continent)
values ("China", "Asia");
INSERT INTO country (name, continent)
values ("US", "North America");
INSERT INTO country (name, continent)
values ("Macedonia", "Europe");
INSERT INTO country (name, continent)
values ("Colombia", "South America");

INSERT INTO author (name, surname, country_id)
values ("Edgar", "Allan Poe", 2);
INSERT INTO author (name, surname, country_id)
values ("Lu", "Xun", 1);
INSERT INTO author (name, surname, country_id)
values ("Grigor", "Prlichev", 3);
INSERT INTO author (name, surname, country_id)
values ("Gabrie", "García Márquez", 4);

INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Tales of Mystery and Imagination", 2, 1, 3500);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Mesmeric Revelation", 2, 1, 4300);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Ligeia", 2, 1, 210);

INSERT INTO book (name, genre_id, author_id, available_copies)
values ("A Madman's Diary", 4, 2, 2200);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Wandering", 1, 2, 120);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Old Tales Retold", 6, 2, 112);

INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Autobiography of Grigor Parlichev", 5, 3, 2200);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("O Armatolos", 3, 3, 120);

INSERT INTO book (name, genre_id, author_id, available_copies)
values ("One Hundred Years of Solitude", 1, 4, 10021);
INSERT INTO book (name, genre_id, author_id, available_copies)
values ("Love in the Time of Cholera", 1, 4, 1234);

