USE library;
/*------------------------------------------------------ ASSIGNMENT 1 -------------------------------------------------------------------- */
  

/* 
Write a SELECT command to display name of those members
who belong to the category as to which member
"Udit Saxena" belongs.
 */
SELECT member_name FROM members
    WHERE category = (SELECT category FROM members 
    WHERE member_name = 'Udit Saxena');

/*
Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
*/
SELECT member_name, t.title_name, b.issue_date, due_date
    FROM book_issue b
    LEFT JOIN members M ON M.member_id = b.member_id
    JOIN books c ON b.accession_no= c.accession_no
    JOIN title t ON c.title_id= t.title_id
    WHERE (b.accession_no,b.member_id) NOT IN 
    (SELECT accession_no,member_id FROM book_return );


/*
SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
*/
SELECT b.issue_date, t.title_name, m.member_name, b.due_date
    FROM book_issue b
    LEFT JOIN members M
    ON M.member_id = b.member_id
    JOIN books c
    ON b.accession_no= c.accession_no
    JOIN title t
    ON c.title_id= t.title_id
    WHERE (b.accession_no,b.member_id) IN 
    (SELECT accession_no,member_id FROM book_return r
    WHERE DATEDIFF(r.return_date,b.due_date) > 0);



/*
to display information of those books
whose price is equal to the most expensive book purchased so far.
*/
SELECT t.title_id, b.purchase_date, b.price, t.title_name
    FROM books b, title t
    WHERE t.title_id = b.title_id 
    AND price  = (SELECT MAX(price) FROM books );


/*
Write a SELECT command to display the second maximum price
of a book.
*/
 SELECT MAX(price) FROM books
    WHERE price NOT IN (SELECT MAX(price) FROM books );
  
  
  /*------------------------------------------------------ ASSIGNMENT 2 -------------------------------------------------------------------- */
  
/*
Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.
*/
DROP VIEW IF EXISTS CATEGORY;

CREATE VIEW Category
    AS
    SELECT member_name, member_id ,
    CASE category WHEN 'F' THEN 'Faculty'
    WHEN 'S' THEN 'Student' ELSE 'Others' END 
    AS 'Category' FROM members;

SELECT * FROM Category;
  /*
View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/
DROP VIEW IF EXISTS Member_detail;
  
CREATE VIEW Member_detail AS
    SELECT member_name, issue_date,due_date
    FROM members m, book_issue b
    WHERE m.member_id = b.member_id;

SELECT * FROM Member_detail;
  
  /*
  View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
*/
DROP VIEW IF EXISTS Information;

CREATE VIEW Information AS
    SELECT s.subject_name, t.title_name,m.member_id, m.member_name, m.category,
    bi.issue_date,bi.due_date, br.return_date FROM book_issue bi
    JOIN books b 
    ON (b.accession_no = bi.accession_no)
    LEFT JOIN book_return br
    ON (br.accession_no = bi.accession_no AND br.member_id = bi.member_id)
    JOIN title t 
    ON (b.title_id = t.title_id)
    JOIN subjects s 
    ON (s.subject_id = t.subject_id)
    JOIN members m 
    ON (bi.member_id = m.member_id);

SELECT * FROM Information;