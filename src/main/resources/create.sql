CREATE TABLE Caregivers (
    Username varchar(255),
    Salt BINARY(16),
    Hash BINARY(16),
    PRIMARY KEY (Username)
);

CREATE TABLE Availabilities (
    Time date,
    Username varchar(255) REFERENCES Caregivers,
    PRIMARY KEY (Time, Username)
);

CREATE TABLE Vaccines (
    Name varchar(255),
    Doses int,
    PRIMARY KEY (Name)
);

CREATE TABLE Patients (
    Username varchar(255),
    Salt BINARY(16),
    Hash BINARY(16),
    PRIMARY KEY (Username)
)

CREATE TABLE Appointments (
   appID varchar(255) PRIMARY KEY,
   patID varchar(255) REFERENCES Patients(Username),
   carID varchar(255) REFERENCES Caregivers(Username),
   vacID varchar(255) REFERENCES Vaccines(Name),
   Time date,
   Username varchar(255),
   FOREIGN KEY (Time, Username) REFERENCES Availabilities(Time, Username)
);