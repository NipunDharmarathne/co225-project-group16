DROP DATABASE IF EXISTS CO225_PROJECT;
CREATE DATABASE CO225_PROJECT;
USE CO225_PROJECT;

CREATE TABLE Administrator(
	AdminID VARCHAR(10) PRIMARY KEY, 
	Password VARCHAR(100), 
	FirstName VARCHAR(50),
	LastName VARCHAR(50),	
	University VARCHAR(50),
	Faculty VARCHAR(50),	
	Department VARCHAR(50),
	AcademicYear INT,	
	NoOfSemesters INT,
	TotalSubFirstSem INT,		
	TotalSubSecondSem INT);

CREATE TABLE Student(
	StudentID VARCHAR(10) PRIMARY KEY, 
	Password VARCHAR(100), 
	FirstName VARCHAR(50),
	LastName VARCHAR(50),	
	University VARCHAR(50),
	Faculty VARCHAR(50),	
	Department VARCHAR(50),
	AcademicYear INT,		
	CurrentSemInTheAcademicYear INT);

CREATE TABLE Course(
	CourseCode VARCHAR(10), 
	AdminID VARCHAR(10),
	Name VARCHAR(50), 
	Credits INT,
	Semester INT,
	PRIMARY KEY (CourseCode, AdminID),
	index(AdminID));

CREATE TABLE StudentResult(
	StudentID VARCHAR(10), 
	Semester VARCHAR(50),
	GPA INT,
	PRIMARY KEY (StudentID, Semester),
	index(StudentID));
	
--ALTER TABLE Course ADD FOREIGN KEY (AdminID) REFERENCES Administrator (AdminID) ON UPDATE CASCADE ON DELETE CASCADE;
--ALTER TABLE StudentResult ADD FOREIGN KEY (StudentID) REFERENCES Student (StudentID) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO Administrator VALUES ('E1', 'ABC', 'ASD', 'FSAFDSA', 'UOP', 'FOE', 'COM', 2, 2, 7, 6);
INSERT INTO Administrator VALUES ('E3', 'ABC', 'ASD', 'FSAFDSA', 'UOP', 'FOE', 'COM', 3, 2, 7, 6);
INSERT INTO Administrator VALUES ('E2', 'ABCD', 'ASD', 'FSAFDSA', 'UOM', 'FOE', 'COM', 2, 2, 7, 6);

INSERT INTO Student VALUES ('S1', 'ABCD', 'ASD', 'FSAFDSA', 'UOP', 'FOE', 'COM', 2, 2);
INSERT INTO Student VALUES ('S2', 'AABCD', 'AASSD', 'FSVSAFDSA', 'UOM', 'FOE', 'COM', 2, 2);

INSERT INTO Course VALUES ('C1', 'E1', 'CO222', 3, 3);
INSERT INTO Course VALUES ('C2', 'E2', 'EE222', 3, 3);
INSERT INTO Course VALUES ('C3', 'E1', 'CO223', 3, 3);
INSERT INTO Course VALUES ('C4', 'E3', '3EE222', 3, 3);
INSERT INTO Course VALUES ('C5', 'E3', '3CO223', 3, 3);

SHOW TABLES;
SELECT* FROM Student;
SELECT* FROM Administrator;
SELECT* FROM Course;

CREATE VIEW Student_Course 
AS 
SELECT StudentID, CourseCode 
FROM Course, Administrator, Student 
WHERE Course.AdminID=Administrator.AdminID 
AND Student.University=Administrator.University 
AND Student.Faculty=Administrator.Faculty 
AND Student.Department=Administrator.Department 
AND Student.AcademicYear=Administrator.AcademicYear; 

SELECT* FROM Student_Course;

SELECT* FROM Student_Course WHERE StudentID='S1';

SELECT CourseCode FROM Student_Course WHERE StudentID='S1';




















































































SELECT Student.StudentID, CourseCode 
FROM Course, Administrator, Student 
WHERE Course.AdminID=Administrator.AdminID 
AND Student.University=Administrator.University 
AND Student.Faculty=Administrator.Faculty 
AND Student.Department=Administrator.Department 
AND Student.AcademicYear=Administrator.AcademicYear; 

SELECT StudentID FROM ( 
SELECT Student.StudentID, CourseCode 
FROM Course, Administrator, Student 
WHERE Course.AdminID=Administrator.AdminID 
AND Student.University=Administrator.University 
AND Student.Faculty=Administrator.Faculty 
AND Student.Department=Administrator.Department 
AND Student.AcademicYear=Administrator.AcademicYear) AS T; 


SELECT StudentID FROM ( 
SELECT Student.StudentID, CourseCode 
FROM Course, Administrator, Student 
WHERE Course.AdminID=Administrator.AdminID 
AND Student.University=Administrator.University 
AND Student.Faculty=Administrator.Faculty 
AND Student.Department=Administrator.Department 
AND Student.AcademicYear=Administrator.AcademicYear) AS T
WHERE StudentID='S1';
