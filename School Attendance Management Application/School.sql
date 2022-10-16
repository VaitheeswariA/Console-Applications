/*
*********************************************School Attendance Management System********************************
Modified Date					Modification							Author
-----------------------------------------------------------------------------------------------------------------
2022-10-05 						1. Initial database script 				Vaitheeswari 
-------------------------------------------------------------------------------------------------------------------
*/

/*CREATE DATABASE School_db;*/
USE School_db;

CREATE TABLE Admin
(
Name varchar(25),
Email_id varchar(35),
Password varchar(10),
Mobile_number varchar(12)
);
INSERT INTO Admin VALUES
("Admin","admin@gmail.com","admin","9876543210");

/*
SELECT * FROM Admin;
DELETE FROM Admin;
DROP TABEL Admin;
*/


CREATE TABLE Staff_Id
(
id int NOT NULL auto_increment,
PRIMARY KEY(id)
);

ALTER TABLE Staff_Id auto_increment=01;

CREATE TABLE IF NOT EXISTS Staff
(
Staff_id varchar(8) NOT NULL,
Name varchar(25),
Email_Id varchar(35),
Password varchar(10),
Mobile_number varchar(12),
Standard_incharge varchar(3),
Notification_Id varchar(5) NULL,
PRIMARY KEY(Staff_id)
);


INSERT INTO Staff_id VALUES();
INSERT INTO Staff VALUES
((SELECT CONCAT("EF20220",id) FROM Staff_id ORDER BY id DESC LIMIT 1),"Hariharan","hariharan@gmail.com","efhari1","9898989898","1A",NULL);

INSERT INTO Staff_id VALUES();
INSERT INTO Staff VALUES
((SELECT CONCAT("EF20220",id) FROM Staff_id ORDER BY id DESC LIMIT 1),"Madhu","madhu@gmail.com","efmadhu2","9797979797","1B",NULL);

INSERT INTO Staff_id VALUES();
INSERT INTO Staff VALUES
((SELECT CONCAT("EF20220",id) FROM Staff_id ORDER BY id DESC LIMIT 1),"Nilan","nilan@gmail.com","efnilan3","9696969696","2A",NULL);

INSERT INTO Staff_id VALUES();
INSERT INTO Staff VALUES
((SELECT CONCAT("EF20220",id) FROM Staff_id ORDER BY id DESC LIMIT 1),"Dhivya","dhivya@gmail.com","efdhivya4","9595959595","2B",NULL);

/*
DELETE FROM Staff_id;
DELETE FROM Staff;

SELECT * FROM Staff_id;
SELECT * FROM Staff;

DROP TABLE Staff_Id;
DROP TABLE Staff;
*/

CREATE TABLE IF NOT EXISTS Student_Id
(
id int NOT NULL AUTO_INCREMENT,
PRIMARY KEY(id)
);

ALTER TABLE Student_id AUTO_INCREMENT=01;

    CREATE TABLE IF NOT EXISTS Student
    (
    Student_Id varchar(10) NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Name varchar(25) NOT NULL,
    Email_Id varchar(35) NOT NULL,
    Student_Password varchar(25) NOT NULL,
    Mobile_Number varchar(10) NOT NULL,
    Standard varchar(3) ,
    Is_live_data boolean,
    Guardian_Name varchar(25),
    Emergency_Contact varchar(10),
    PRIMARY KEY(Student_Id),
    FOREIGN KEY(Staff_Incharge_Id) REFERENCES Staff(Staff_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT student_uc UNIQUE(Email_Id,Mobile_Number)
    );
    
    
    INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202201","Uma","uma@gmail.com","stuma1","9090909090","1A",true,"Maheshwari","9191919191");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202201","Ram","ram@gmail.com","stram2","9999999999","1A",true,"Magizhini","9098909890");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202201","Somu","somu@gmail.com","stsomu3","8888888888","1A",true,"Nagesh","8989898989");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202201","Krishna","krishna@gmail.com","stkrishna1","8080808080","1A",true,"Shivam","8098098098");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202202","Shiva","shiva@gmail.com","stshiva5","8089808980","1B",true,"Maheshwari","9191919191");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202202","Goutham","goutham@gmail.com","stgoutham6","7878787878","1B",true,"Maheshwaran","9191976544");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202202","Arul","arul@gmail.com","starul7","9192939495","1B",true,"Kumaran","9292929292");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202202","Arun","arun@gmail.com","starun8","7676767676","1B",true,"Shruthi","9695969596");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202203","Latha","latha@gmail.com","stlatha9","8789878987","2A",true,"Mahesh","8980878690");
    
	INSERT INTO Student_id VALUES();
    INSERT INTO Student VALUES
    ((SELECT CONCAT("ST20220",id) FROM Student_id ORDER BY id DESC LIMIT 1),"EF202204","kumar","kumar@gmail.com","stkumar10","7777777777","2B",true,"Dhinesh","7878989890");
  
  /*
   SELECT * FROM Student_Id;
	SELECT * FROM Student;
    
    DELETE FROM Student_Id;
    DELETE FROM Student WHERE Student_id="";
    
    DROP TABLE Student;
    DROP TABLE Student_Id;
  */
  
  

    CREATE TABLE IF NOT EXISTS StudentAttendance
    (
    Student_Id varchar(25) NOT NULL,
    Attendance_Date date NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Standard varchar(3) NOT NULL,
    Attendance_Record varchar(8) NOT NULL,
    Is_Holiday boolean ,
    Is_Absent boolean,
    Has_Approval boolean,
    Instruction varchar(40),
    PRIMARY KEY(Student_Id,Attendance_Date)
    );
    
    INSERT INTO StudentAttendance VALUES
    ("ST202201","2022-10-04","EF202201","1A","Present",false,false,false,NULL),
   ("ST202202","2022-10-04","EF202201","1A","Present",false,false,false,NULL),
   ("ST202203","2022-10-04","EF202201","1A","Leave",false,true,true,"approved leave"),
   ("ST202204","2022-10-04","EF202201","1A","Absent",false,false,false,"Need reason and proof"),
   ("ST202201","2022-10-05","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-06","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-07","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-10","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-11","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-12","EF202201","1A","Present",false,false,false,NULL),
   ("ST202201","2022-10-13","EF202201","1A","Present",false,false,false,NULL);
/*
Select * From StudentAttendance WHERE Student_id="ST202201";
*/


	CREATE TABLE IF NOT EXISTS Notification_Id
    (
    id int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id)
    );
    
    ALTER TABLE Notification_Id AUTO_INCREMENT=1;
    
    CREATE TABLE IF NOT EXISTS Leave_Notification
    (
    Notification_id varchar(10) NOT NULL,
    Notification_type varchar(35),
    Requested_Student_Id varchar(25),
    From_date date,
    To_date date,
    Approver_Staff_Id varchar(10),
    Request_reason varchar(35),
    Request_status varchar(15),
    is_live_request boolean,
    PRIMARY KEY(Notification_id)
    );
   
   
   INSERT INTO Notification_Id VALUES();
   
   INSERT INTO Leave_Notification VALUES
   ((SELECT CONCAT("L",id) FROM Notification_Id ORDER BY id DESC LIMIT 1),"Leave request","ST202203","2022-10-04","2022-10-04","EF202201","Sick","Approved",false);
   
 
/*
	DELETE FROM Leave_Notification;
    DELETE FROM Notification_Id;
    
    SELECT * FROM Notification_Id;
    SELECT * FROM Leave_Notification;
    
    DROP TABLE Notification_Id;
    DROP TABLE Leave_Notification;
*/


CREATE TABLE IF NOT EXISTS Deleted_Staff
(
Staff_id varchar(8) NOT NULL,
Name varchar(25),
Email_Id varchar(35),
Password varchar(10),
Mobile_number varchar(12),
Standard_incharge varchar(3),
Notification_Id varchar(5) NULL,
PRIMARY KEY(Staff_id)
);
/*
SELECT * FROM Deleted_Staff;

DELETE FROM Deleted_Staff;
*/

CREATE TABLE IF NOT EXISTS Deleted_Student
    (
    Student_Id varchar(10) NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Name varchar(25) NOT NULL,
    Email_Id varchar(35) NOT NULL,
    Student_Password varchar(25) NOT NULL,
    Mobile_Number varchar(10) NOT NULL,
    Standard varchar(3) ,
    Is_live_data boolean,
    Guardian_Name varchar(25),
    Emergency_Contact varchar(10),
    PRIMARY KEY(Student_Id),
    FOREIGN KEY(Staff_Incharge_Id) REFERENCES Staff(Staff_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT student_uc UNIQUE(Email_Id,Mobile_Number)
    );
    
    /*
    SELECT * FROM Deleted_Student;
    DROP TABLE Deleted_Student
    */
    
    CREATE TABLE IF NOT EXISTS Deleted_StudentAttendance
    (
    Student_Id varchar(25) NOT NULL,
    Attendance_Date date NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Standard varchar(3) NOT NULL,
    Attendance_Record varchar(8) NOT NULL,
    Is_Holiday boolean ,
    Is_Absent boolean,
    Has_Approval boolean,
    Instruction varchar(40),
    PRIMARY KEY(Student_Id,Attendance_Date)
    );
      /*
    SELECT * FROM Deleted_StudentAttendance;
    DROP TABLE Deleted_StudentAttendance
    */
    
    