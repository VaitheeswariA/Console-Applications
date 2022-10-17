/******************************Hotel Dining Table Booking Application*************************************
Modified Date 					Modification 					Author
------------------------------------------------------------------------------------------------------------
2022-10-06					1.Initial creation script			Vaitheeswari A
************************************************************************************************************/

/*DROP DATABASE Hotel_db;*
/*CREATE DATABASE hotel_db;*/
Use hotel_db;

CREATE TABLE IF NOT EXISTS Customer
(
Customer_Id int NOT NULL AUTO_INCREMENT,
Customer_Name varchar(25) NOT NULL,
Customer_MobileNo varchar(10) NOT NULL,
primary key(Customer_Id)
);
ALTER TABLE Customer AUTO_INCREMENT=101;

CREATE TABLE IF NOT EXISTS Variety
(
Variety_Id tinyint NOT NULL,
Variety_type varchar(20) NOT NULL,
primary key(Variety_Id)
);

INSERT INTO Variety VALUES
(1,"Veg"),
(2,"Non Veg"),
(3,"Rice"),
(4,"Bread"),
(5,"Drinking Beverages"),
(6,"Desert"),
(7,"Shakes");




CREATE TABLE IF NOT EXISTS Food
(
Id int,
Variety_Id tinyint,
Food_name varchar(40),
Food_quantity int,
Food_Price double,
primary key(Id,Variety_Id),
foreign key(Variety_Id) REFERENCES Variety(Variety_Id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Food VALUES
(1,1,"Gobi 65",1, 140.00),
(2,1,"Gobi 65",1, 140.00),
(3,1,"Mushroom pepper fry", 1,150.00),
(4,1,"Paneer butter masala", 1,170.70),
(5,1,"Aloo Gobi masala",1, 120.20),
(6,1,"Chenna Masala",1, 110.00),
(7,1,"Dal Fry",1, 120.25),
(8,1,"Veg Kurma", 1,115.50),
(9,1,"Bhindhi Masala", 1,80.50),
(10,1,"Veg Manchurian gravy", 1,125.50),
(11,1,"Mushroom gravy", 1,110.00),
(1,2,"Chicken 65", 1,120.50),
(2,2,"Fish Fingers",1, 130.50),
(3,2,"Mutton chops",1, 250.70),
(4,2,"Mutton cola", 1,30.00),
(5,2,"Chicken Chettinad masala",1, 150.00),
(6,2,"Chicken pepper dry",1, 135.00),
(7,2,"Mutton gravy",1, 250.00),
(8,2,"Fish Masala",1, 200.00),
(9,2,"Prawn gravy",1, 150.00),
(10,2,"Butter Chicken masala",1, 150.00),
(1,4,"Naan",1, 20.00),
(2,4,"Roti",1, 25.00),
(3,4,"Chapathi",1, 15.00),
(4,4,"Garlic naan",1, 23.00),
(5,4,"Parotta",1, 17.00),
(6,4,"cyleon parotta",1, 18.00),
(7,4,"Chilli parotta",1, 110.00),
(8,4,"Chicken kothu parotta",1, 130.00),
(9,4,"Butter Naan",1, 22.00),
(10,4,"kuboos",1, 15.00),
(1,3,"White basmati rice",1, 100.00),
(2,3,"Ghee rice",1, 115.70),
(3,3,"pulao", 1,110.00),
(4,3,"Veg Briyani",1, 125.00),
(5,3,"Channa Briyani",1, 130.00),
(6,3,"Prawn Briyani",1, 230.00),
(7,3,"Chicken Briyani",1, 210.00),
(8,3,"Mutton Briyani",1, 250.00),
(9,3,"Fish Briyani",1, 230.00),
(10,3,"Hydrabadhi Chicken briyani",1, 250.75),
(11,3,"Mint Mojito",1, 70.00),
(1,5,"Lemon Soda",1, 60.00),
(2,5,"Danger Soda",1, 170.00),
(3,5,"Coke",1, 40.00),
(4,5,"paneer soda",1, 40.00),
(5,6,"Gulab jamun",1, 40.00),
(6,6,"White basmati rice",1, 100.00),
(7,6,"Brownie",1, 50.00),
(8,6,"Sizzling Brownie",1, 130.00),
(9,6,"Carrot halwa",1, 70.00),
(10,6,"Bread halwa",1, 50.00),
(1,7,"Strawberry",1, 110.00),
(2,7,"Mango",1, 120.00),
(3,7,"Vennila",1, 100.00),
(4,7,"Chocolate",1, 120.00),
(5,7,"ButterFruit",1, 140.00);

CREATE TABLE IF NOT EXISTS OrderDetails
(
Order_id int NOT NULL AUTO_INCREMENT,
Customer_id int NOT NULL,
Selected_table int NULL,
table_availability boolean,
Price double NOT NULL,
Primary key(Order_id),
foreign key(Customer_id) REFERENCES Customer(Customer_id) ON UPDATE CASCADE ON DELETE CASCADE,
Check(Selected_table<=5 AND Selected_table>=1)
);
ALTER TABLE OrderDetails AUTO_INCREMENT=1001;

CREATE TABLE IF NOT EXISTS orderlist
(
Order_id int NOT NULL,
Food_name varchar(40) NOT NULL,
Quantity int NOT NULL,
each_food_price int NOT NULL,
Foreign Key(Order_id) REFERENCES OrderDetails(Order_id) ON UPDATE CASCADE ON DELETE CASCADE
);

	
/*Sample queries...
Drop table Orderlist

SELECT * FROM orderlist;
SELECT * FROM OrderDetails;
SELECT * FROM Customer;
DELETE FROM Customer ;
SELECT * FROM Food WHERE Id=11 AND Variety_Id=3
SELECT * FROM OrderDetails

DELETE FROM OrderDetails;
DROP TABLE OrderDetails

DELETE FROM OrderDetails WHERE Order_Id=1001;
DELETE FROM Orderlist;
DELETE FROM Customer;
*/