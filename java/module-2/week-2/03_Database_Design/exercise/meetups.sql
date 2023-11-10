CREATE TABLE member (
	member_number INT PRIMARY KEY,
	last_name VARCHAR(50) NOT NULL,
	first_name VARCHAR(50)NOT NULL,
	email_address VARCHAR(100) NOT NULL UNIQUE,
	phone_number VARCHAR(20),
	date_of_birth DATE NOT NULL,
	receive_reminder_emails BOOLEAN NOT NULL
);

CREATE TABLE interest_group(
	group_number INT PRIMARY KEY,
	name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE event(
	event_number INT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	start_date_time TIMESTAMP NOT NULL,
	duration_minutes INT CHECK (duration_minutes >= 30),
	group_number INT,
	FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE member_interest_group(
	member_number INT,
	group_number INT,
	PRIMARY KEY (member_number, group_number),
	FOREIGN KEY (member_number) REFERENCES member (member_number),
	FOREIGN KEY (group_number) REFERENCES interest_group (group_number)
);

CREATE TABLE member_event(
	member_number INT,
	event_number INT, 
	PRIMARY KEY (member_number, event_number),
	FOREIGN KEY (member_number) REFERENCES member (member_number),
	FOREIGN KEY (event_number) REFERENCES event (event_number)
);

INSERT INTO member VALUES
	(1, 'Armbruster', 'Joe', 'newmotorsjoe@gmail.com', '8144641234', '1980-07-08', true),
	(2, 'Lassoff', 'Jenn', 'jlassoff@hotmail.com', '8143286725', '1983-2-14', false),
	(3, 'Yingling', 'Allen', 'allen@newmotors.com', '8145462345', '1989-4-12', true),
	(4, 'Confer', 'Tony', 'tony@newmotors.com', '8149872134', '1986-8-23', false),
	(5, 'Quinn', 'Robby', 'robertquinn@gmail.com', '8149751357', '1990-10-21', true),
	(6, 'Harney', 'Shane', 'shane@newmotors.com', '8763214567', '1978-11-30', false),
	(7, 'Francis', 'Mike', 'michaelf@newmotors.com', '1234567890', '1967-12-31', true),
	(8, 'Deboe', 'Donovan', 'donovand@hotmail.com', '2467891357', '2000-4-20', false);
	
INSERT INTO interest_group VALUES
	(1, 'Coding Enthusiasts'),
	(2, 'Photography Lovers'),
	(3, 'Art Admirers'),
	(4, 'Film Buffs');
	
INSERT INTO event VALUES
	(1, 'Coding Workshop', 'Learn how fun coding can be', '2023-02-17 11:00:00', 120, 1),
	(2, 'Photo Exhibition', 'Photos from local landmarks', '2023-04-20 12:30:00', 90, 2),
	(3, 'Art Gallery', 'Check out paintings from new artits', '2023-07-08 09:00:00', 90, 3),
	(4, 'Short Movie Marathon', 'Watch several movies', '2023-10-12 15:00:00', 150, 4);
	
INSERT INTO member_interest_group VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(4, 2),
	(5, 3),
	(6, 3),
	(7, 4),
	(8, 4);
	
INSERT INTO member_event VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(4, 2),
	(5, 3),
	(6, 3),
	(7, 4),
	(8, 4);
	