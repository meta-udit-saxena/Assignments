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
    JOIN publisher p ON (t.publisher_id = p.publisher_id)
    JOIN subjects s ON (t.subject_id = s.subject_id) ;

/*
to display number of members present in each category. 
The result should include category and number of members belongs to that category
*/
SELECT COUNT(member_id),category FROM members GROUP BY category;

/*
to display name of those members who belongs to the
category as to which member "Udit Saxena" belongs.
Solve the problem using join operation
*/
SELECT m1.member_name FROM members m1 
    JOIN members m2 ON m1.category = m2.category AND m2.member_name = "Udit Saxena";  

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
INSERT INTO Category(name,parent_id) VALUES ('Mobiles & Tablets',null),('Computers',null),('Mobiles',1),
                                            ('Tablets',1),('DeskTop',2),('Laptop',2),('Smart Phones',3),
                                            ('Featured Phones',3),('2G',4),('3G',4);


-- to display all the categories along with its Parent category.
SELECT p.name AS Parent , c.name AS Category FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id); 


-- Result should be sorted on Parent Category.
SELECT p.name AS Parent , c.name AS Category FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id) ORDER BY p.name; 


-- If category is top category then it should display “Top Category” in Parent category. 
SELECT IFNULL(p.name,'Top Category') AS Parent , c.name AS Category FROM Category c 
    LEFT JOIN Category p ON (c.parent_id = p.id) ORDER BY p.name; 


-- Rewrite above SQL query to display only Top Categories.
SELECT name AS Top_Category FROM Category WHERE parent_id is NULL;



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

-- create a table z     ipcode
create table zipcode (
    zipcode int not null ,
    city varchar(45),
    state varchar(45) ,
    PRIMARY KEY (zipcode)
    );

-- load data from csv file to zipcode table
LOAD DATA LOCAL INFILE 'C:\\Users\\User27\\Downloads\\pincode_data.csv' 
    INTO TABLE form.zipcode FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n';

/*
write a SQL query for that returns a Resultset containing Zip Code, City Names 
and States ordered by State Name and City Name.
*/
SELECT zipcode, state, city FROM zipcode WHERE zipcode = 302001;
