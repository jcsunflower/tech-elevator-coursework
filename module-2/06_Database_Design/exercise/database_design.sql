-- Initializing Tables

CREATE TABLE "member" (
	member_id serial NOT NULL,
	last_name varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	email_address varchar(255) NOT NULL,
	phone_number varchar(12),
	date_of_birth DATE(255) NOT NULL,
	opt_in_emails BOOLEAN NOT NULL DEFAULT 'false',
	group_id int NOT NULL,
	event_id int NOT NULL
	CONSTRAINT pk_member_member_id PRIMARY KEY (member_id)
);

CREATE TABLE "interest_group" (
	group_id serial NOT NULL,
	interest_group_name varchar(255) NOT NULL UNIQUE,
	CONSTRAINT pk_interest_group_group_id PRIMARY KEY (group_id)
);

CREATE TABLE "event" (
	event_id serial NOT NULL,
	event_name varchar(255) NOT NULL,
	event_description varchar(255) NOT NULL,
	start_date_and_time TIMESTAMP(255) NOT NULL,
	duration_in_minutes int NOT NULL CHECK (duration_in_minutes >= 30)
	group_id int NOT NULL
	CONSTRAINT pk_event_event_id PRIMARY KEY (event_id)
);

ALTER TABLE "member" ADD CONSTRAINT fk_member_group FOREIGN KEY ("member".group_id) REFERENCES ("interest_group".group_id);
ALTER TABLE "member" ADD CONSTRAINT fk_member_event FOREIGN KEY ("member".event_id) REFERENCES ("event".event_id);
ALTER TABLE "event" ADD CONSTRAINT fk_event_group FOREIGN KEY ("event".group_id) REFERENCES ("interest_group".group_id);

-- Inserting Groups

INSERT INTO "interest_group" (interest_group_name)
VALUES ('Anime Conventions');

INSERT INTO "member" (last_name, first_name, email_address, phone_number, date_of_birth, opt_in_emails, group_id, event_id)
VALUES ('Wilkosz', 'Oskar', 'wilkosom@miamioh.edu', '440-570-5355', '1998-12-11', true); 