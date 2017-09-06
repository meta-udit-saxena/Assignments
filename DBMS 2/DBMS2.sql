-- *************************************************** Assignment 1 *******************************************************************

USE library;
/*
to display all the columns of mmbers table
*/
DESCRIBE members;

/*
to display member_name , member_id and category
*/
SELECT member_name , member_id , category FROM members;

/*
to display member_name , member_id and category from members table where category of member is Faculty('F').
*/
SELECT member_name, member_id, category FROM members WHERE category = 'F';

/*
to display various categories of members
*/
SELECT DISTINCT(category) AS distinct_categories FROM members;

/*
to display member name and their category in the descending order of member name
*/
SELECT member_name, category FROM members ORDER BY member_name DESC;

/*
to display all the titles, their subject and publishers
*/
SELECT t.title_name, p.publisher_name, s.subject_name FROM title t 
    INNER JOIN publisher p ON (t.publisher_id = p.publisher_id)
    INNER JOIN subjects s ON (t.subject_id = s.subject_id) ;

/*
to display number of members present in each category. 
The result should include category and number of members belongs to that category
*/
SELECT category, COUNT(member_id) AS 'Number of Members' FROM members GROUP BY category;

/*
to display name of those members who belongs to the
category as to which member "Udit Saxena" belongs.
Solve the problem using join operation
*/
SELECT m1.member_name FROM members m1 
    INNER JOIN members m2 ON m1.category = m2.category AND m2.member_name = "Udit Saxena";  

/*
To display information on all the books issued. 
The result should include issue date, accession no, member id and return date.
If the book has not been returned, the column return date should be left blank. 
Give appropriate heading from the columns
*/
SELECT i.issue_date AS Issue_Date, i.accession_no AS Accession_Number, i.member_id AS Member_ID, r.return_date AS Return_Date FROM book_issue i 
    LEFT JOIN book_return r ON (r.accession_no = i.accession_no);




-- *************************************************** Assignment 2 ***************************************************************************


/*
Modify the SELECT command written for above query 
to display results in ascending order of issue date 
and within issue date in ascending order of member's name.
*/
SELECT i.issue_date AS Issue_Date, i.accession_no AS Accession_Number, i.member_id AS Member_ID, r.return_date AS Return_Date FROM book_issue i 
    LEFT JOIN book_return r ON (r.accession_no = i.accession_no)
    ORDER BY i.issue_date,(SELECT member_name FROM members m WHERE m.member_id = i.member_id);





-- *************************************************** Assignment 3 ***************************************************************************


-- Drop database if already exists
DROP DATABASE IF EXISTS Ecommerce;

-- create database
CREATE DATABASE Ecommerce;

-- select database
USE Ecommerce;

-- Category Table Created
CREATE TABLE Category(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_id INT ,
    CONSTRAINT fk_parent_id FOREIGN KEY (parent_id) REFERENCES Category (id) ON UPDATE CASCADE ON DELETE CASCADE);

-- values Inserted
INSERT INTO Category(name,parent_id) VALUES 
    ('Mobiles & Tablets',null),('Computers',null),('Mobiles',1),
    ('Tablets',1),('DeskTop',2),('Laptop',2),('Smart Phones',3),
    ('Featured Phones',3),('2G',4),('3G',4);


-- to display all the categories along with its Parent category.
SELECT c.name AS Category , p.name AS Parent FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id); 


-- Result should be sorted on Parent Category.
SELECT c.name AS Category, p.name AS Parent FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id) ORDER BY p.name; 


-- If category is top category then it should display “Top Category” in Parent category. 
SELECT IFNULL(p.name,'Top Category') as Parent, c.name AS Category FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id) ORDER BY p.name ; 


-- Rewrite above SQL query to display only Top Categories.
SELECT name AS Top_Category FROM Category WHERE parent_id IS NULL;



-- *************************************************** Assignment 4 ***************************************************************************

/*
Consider a form where providing a Zip Code populates associated City and State. 
Create appropriate tables and relationships for the same and write a SQL query
for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.
*/

-- drop table if already exist
DROP DATABASE IF EXISTS form;

-- create database form
CREATE DATABASE form;

-- select database form
USE form;

/*
State Table Created 
*/
create table State(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL);

/*
City Table Created
*/
create table City(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    state_id INT,
    CONSTRAINT fk_state_id FOREIGN KEY (state_id) REFERENCES State (id)
    );

/*
 Zipcode table Created
*/
create table Zipcode (
    zipcode int PRIMARY KEY,
    zone_name VARCHAR(50), 
    city_id int,
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES City (id)
    );
    
/*
Data Inserted inot State table
*/
INSERT INTO State (name) VALUES 
    ('Rajasthan'),('Uttar Pradesh'),('Gujrat'),('Madhya Pradesh'),('Punjab'),('Maharashtra' ), ('Jammu and Kashmir');

/*
Data Inserted inot City table
*/
INSERT INTO City (name,state_id) VALUES 
    ('Jaipur',1),('Jodhpur',1),('Udaipur',1),('Kota',1),('Ajmer',1),('Jabalpur',4),('Amritsar',5),('Jalandhar',5),('Barielly',2);

/*
Data Inserted inot ZIPCODE table
*/
INSERT INTO Zipcode(zipcode,zone_name,city_id) VALUES 
    (302017,'Gopalpura',1),(302028,'Amer',1),(302015,'mahesh nagar',1),(302022,'sitapura',1),(326510,'Deoli',4),(324002,'Kota Jn.',4),
    (313001,'Udaipur City',3),(342002,'Jodhpur City',2),(305001,'Ajmer',5),(482001,'Jabalpur city',6),(143001,'Amritsar City',7),
    (243001,'Bareilly',9),(144001,'Jalandhar',8);
    
/*
write a SQL query for that returns a Resultset containing Zip Code, City Names 
and States ordered by State Name and City Name.
*/
SELECT z.zipcode, z.zone_name, c.name AS City, s.name AS State FROM zipcode z
    INNER JOIN City c ON (z.city_id = c.id)
    INNER JOIN State s ON (c.state_id = s.id)
    ORDER BY s.name,c.name;
