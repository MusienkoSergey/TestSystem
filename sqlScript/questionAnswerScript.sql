CREATE SCHEMA IF NOT EXISTS testdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS questions (
  question_id int NOT NULL AUTO_INCREMENT,
  question varchar(255) NOT NULL,
  PRIMARY KEY (question_id));

CREATE TABLE IF NOT EXISTS answers (
  answer_id int NOT NULL AUTO_INCREMENT,
  correctness TINYINT(1) NOT NULL ,
  answer varchar(255) NOT NULL ,
  question_id int NOT NULL,
  PRIMARY KEY (answer_id),
  INDEX fk_question_id (question_id),
  CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES questions (question_id));

INSERT INTO questions (question_id, question) VALUES 
(1, 'My parents bought their house ..... 1967.'),
(2, 'There''s somebody waiting ..... the bus stop.'),
(3, 'Gerhard has some nice pictures hanging ..... his office wall.'),
(4, 'Put the papers ..... the desk please.'),
(5, 'I''m moving to a new flat ..... 7 August.'),
(6, 'I often visit my parents ..... Christmas. ');

INSERT INTO answers (correctness, answer, question_id) VALUES 
('1', 'in', '1'),
('0', 'at', '1'),
('0', 'on', '1'),
('0', 'in', '2'),
('1', 'at', '2'),
('0', 'on', '2'),
('0', 'in', '3'),
('0', 'at', '3'),
('1', 'on', '3'),
('0', 'in', '4'),
('0', 'at', '4'),
('1', 'on', '4'),
('0', 'in', '5'),
('0', 'at', '5'),
('1', 'on', '5'),
('0', 'in', '6'),
('1', 'at', '6'),
('0', 'on', '6');