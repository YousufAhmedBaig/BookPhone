DROP TABLE IF EXISTS PHONES_MASTER;

CREATE TABLE PHONES_MASTER (
	phone_id INT AUTO_INCREMENT PRIMARY KEY,
	phone_name VARCHAR(90) NOT NULL,
	phone_quantity INT 
);


DROP TABLE IF EXISTS TESTERS;

CREATE TABLE TESTERS (
	tester_id INT PRIMARY KEY,
	tester_name VARCHAR(90) NOT NULL
);

DROP TABLE IF EXISTS BOOKING_DETAILS;

CREATE TABLE BOOKING_DETAILS (
	phone_id INT,
	tester_id INT, 
	booking_date TIMESTAMP,
	activity VARCHAR(20)	
);