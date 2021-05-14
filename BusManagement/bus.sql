-- Create a DB named bus into mysql.
CREATE DATABASE bus;
USE bus;

-- Table data
CREATE TABLE AdminSection(
AdminUsername varchar(20),
PASSWORD varchar(20)
);

CREATE TABLE BookTickets(
Username varchar(20),
Source varchar(20) REFERENCES Buses,
Destination varchar(20) REFERENCES Buses,
Day varchar(3),
Months varchar(20),
seats varchar(20)
);

CREATE TABLE Buses(
Number varchar(20),
Source varchar(20),
Destination varchar(20),
Bus_Type varchar(20),
Fare varchar(20)
);

CREATE TABLE UserSection(
FirstName varchar(20),
LastName varchar(20),
MobileNumber varchar(20),
Username varchar(20),
Password varchar(20)
);

CREATE TABLE UserSignIn(
Username varchar(20) REFERENCES UserSection,
Password varchar(20) REFERENCES UserSection
);

-- dump data
INSERT INTO UserSignIn VALUES(
'user', 'user' );

INSERT INTO AdminSection VALUES(
'admin', 'admin' );

INSERT INTO Buses VALUES(
'MH101', 'Pune', 'DELHI', 'AC', '2500' );