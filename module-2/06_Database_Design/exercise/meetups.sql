DROP SCHEMA public CASCADE;
CREATE SCHEMA public; 

-- Initializing Tables

CREATE TABLE member (
	member_id serial NOT NULL,
	last_name varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	email_address varchar(255) NOT NULL,
	phone_number varchar(12),
	date_of_birth DATE NOT NULL,
	opt_in_emails BOOLEAN NOT NULL DEFAULT 'false',
	CONSTRAINT pk_member_member_id PRIMARY KEY (member_id)
);

CREATE TABLE interest_group (
	group_id serial NOT NULL,
	interest_group_name varchar(255) NOT NULL UNIQUE,
	CONSTRAINT pk_interest_group_group_id PRIMARY KEY (group_id)
);

CREATE TABLE member_group (
	member_id int NOT NULL,
	group_id INT NOT NULL,
	CONSTRAINT fk_member_group_member_id FOREIGN KEY (member_id) REFERENCES member(member_id),
	CONSTRAINT fk_member_group_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
	CONSTRAINT pk_member_group PRIMARY KEY (member_id, group_id)
);

CREATE TABLE event (
	event_id serial NOT NULL,
	event_name varchar(255) NOT NULL,
	event_description varchar(255) NOT NULL,
	start_date_and_time TIMESTAMP NOT NULL,
	duration_in_minutes int NOT NULL CHECK (duration_in_minutes >= 30),
	group_id int NOT NULL,
	CONSTRAINT pk_event_event_id PRIMARY KEY (event_id),
	CONSTRAINT fk_event_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id)
);

CREATE TABLE member_event (
	member_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT fk_member_event_member_id FOREIGN KEY (member_id) REFERENCES member(member_id),
	CONSTRAINT fk_member_event_event_id FOREIGN KEY (event_id) REFERENCES event(event_id),
	CONSTRAINT pk_member_event PRIMARY KEY (member_id, event_id)
);

-- Inserting Information into Different Groups

INSERT INTO interest_group (interest_group_name)
VALUES ('Anime Conventions'), ('Esports Events'), ('Live Concerts');

INSERT INTO event (event_name, event_description, start_date_and_time, duration_in_minutes, group_id)
VALUES ('Ohayocon 2022', 'Ohayocon is a yearly Japanese anime and popular culture convention in Columbus, Ohio.', '20220210 19:00:00', 2400, 1),
('LCS 2022 Spring Split Week 4 Day 1', 'The LCS 2022 Spring Season is the first split of the tenth year of North America''s professional League of Legends league. Ten teams compete in a round robin group stage.', '20220225 17:30:00', 360, 2),
('Coachella 2022', 'An annual music festival held at Indio, California. The festival includes dozens of concerts across multiple stages by popular artists from a variety of genres, including hip hop, rock, and pop.', '20220415 8:00:00', 4320, 3),
('Matsuricon 2022', 'Matsuricon is an annual Japanese pop-culture event that focuses primarily on Japanese animation, manga, and video games. We also showcase both American and Japanese popular culture, due tot he natural overlap of fandom from both genres', '20220412 19:00:00', 2400, 1);

INSERT INTO member (last_name, first_name, email_address, phone_number, date_of_birth, opt_in_emails)
VALUES ('Wilkosz', 'Oskar', 'wilkosom@miamioh.edu', '440-570-5355', '1998-12-11', true),
('Greathouse', 'Lindsey', 'lindsey.greathouse@l3harris.com', '615-934-2112', '1996-12-09', false),
('Hays', 'Emily', 'hayse@miamioh.edu', '513-582-1918', '1996-12-30', true),
('Eimer', 'Joe', 'jeimer94@aol.com', '615-630-5732', '1994-08-26', false),
('Barnes', 'Hayli', 'barnesk6@miamioh.edu', '614-584-2279', '1997-05-11', false),
('Mullins', 'Josh', 'bigthundergod69@gmail.com', '123-456-7890', '1997-02-02', false),
('Coleman', 'Zendaya', 'zendaya@gmail.com', NULL, '1996-09-01', false),
('Pascal', 'Pedro', 'pedro.pascal@gmail.com', NULL, '1975-04-02', false);

INSERT INTO member_group (member_id, group_id)
VALUES ((SELECT member_id FROM member WHERE email_address = 'wilkosom@miamioh.edu'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Anime Conventions')),
((SELECT member_id FROM member WHERE email_address = 'wilkosom@miamioh.edu'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Esports Events')),
((SELECT member_id FROM member WHERE email_address = 'jeimer94@aol.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Anime Conventions')),
((SELECT member_id FROM member WHERE email_address = 'jeimer94@aol.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Esports Events')),
((SELECT member_id FROM member WHERE email_address = 'jeimer94@aol.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Live Concerts')),
((SELECT member_id FROM member WHERE email_address = 'lindsey.greathouse@l3harris.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Anime Conventions')),
((SELECT member_id FROM member WHERE email_address = 'lindsey.greathouse@l3harris.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Esports Events')),
((SELECT member_id FROM member WHERE email_address = 'hayse@miamioh.edu'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Anime Conventions')),
((SELECT member_id FROM member WHERE email_address = 'bigthundergod69@gmail.com'), (SELECT group_id FROM interest_group WHERE interest_group_name = 'Live Concerts'));

INSERT INTO member_event (member_id, event_id)
VALUES ((SELECT member_id FROM member WHERE email_address = 'wilkosom@miamioh.edu'), (SELECT event_id FROM event WHERE event_name = 'Ohayocon 2022')),
((SELECT member_id FROM member WHERE email_address = 'wilkosom@miamioh.edu'), (SELECT event_id FROM event WHERE event_name = 'LCS 2022 Spring Split Week 4 Day 1')),
((SELECT member_id FROM member WHERE email_address = 'jeimer94@aol.com'), (SELECT event_id FROM event WHERE event_name = 'Ohayocon 2022')),
((SELECT member_id FROM member WHERE email_address = 'lindsey.greathouse@l3harris.com'), (SELECT event_id FROM event WHERE event_name = 'Ohayocon 2022')),
((SELECT member_id FROM member WHERE email_address = 'hayse@miamioh.edu'), (SELECT event_id FROM event WHERE event_name = 'Matsuricon 2022')),
((SELECT member_id FROM member WHERE email_address = 'bigthundergod69@gmail.com'), (SELECT event_id FROM event WHERE event_name = 'Coachella 2022'));






