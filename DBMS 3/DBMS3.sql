-- select library database
USE library;

/*
 Display information on books issued for more than 2 months sorted on member_name and title_name.
*/
SELECT m.member_name, m.member_id, t.title_name, bi.accession_no, bi.issue_date, bi.due_date, br.return_date ,TIMESTAMPDIFF(MONTH,br.issue_date,br.return_date) AS Month_Duration 
    FROM book_return br
    INNER JOIN book_issue bi ON (bi.accession_no = br.accession_no)
    INNER JOIN books b ON (b.accession_no = br.accession_no)
    INNER JOIN title t ON (b.title_id = t.title_id)
    INNER JOIN members m ON (m.member_id = br.member_id)
    WHERE TIMESTAMPDIFF(DAY,br.issue_date,br.return_date)/30>2
    ORDER BY m.member_name,t.title_name;


/*
Display those rows from members table having maximum length for member name.
*/
SELECT member_name,LENGTH(member_name)
    FROM members WHERE LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM members);

/*
Display count of number of books issued so far.
*/
SELECT count(*) AS 'Number oF Books issued' FROM book_issue;

/*
 Display subjectwise information on number of books purchased.
*/
SELECT s.subject_id, s.subject_name ,COUNT(b.accession_no) AS 'Number of Books Purchased' FROM subjects s
    INNER JOIN title t ON (t.subject_id = s.subject_id)
    INNER JOIN books b ON (t.title_id = b.title_id)
    group by b.title_id;

/*
Display those rows from the book_issue table where a book can be returned after 2 months
*/
SELECT * FROM book_issue WHERE TIMESTAMPDIFF(MONTH,issue_date,due_date)>=2;

/*
Display the list of books having price greater than the minimum price of books purchased so far.
*/
SELECT * FROM books WHERE price > (select MIN(price) FROM books);

/*
Display total no. of students, total no. of teachers and total no. of others in a single row.
*/ 
SELECT COUNT(IF(category='F',category,null)) AS Total_Faculty,
    COUNT(IF(category='M',category,null)) AS Total_Manager,
    COUNT(IF(category NOT IN('F','M'),category,null)) AS Others FROM members;
   

/*
 Display the information of those titles that have been issued more than 2 times.
*/
SELECT t.title_id , t.title_name FROM title t 
    INNER JOIN books b ON (b.title_id = t.title_id)
    INNER JOIN book_issue bi ON (bi.accession_no = b.accession_no)
    GROUP BY (bi.accession_no)
    HAVING COUNT(bi.accession_no)>2;

/*
 Display the information of books issued to members of category other than Faculty.
*/
SELECT b.* FROM book_issue b
    INNER JOIN members m ON (b.member_id = m.member_id)
    WHERE m.category NOT IN ('F');

/*
Display information on those authors for which at least 1 book has been purchased.
*/
SELECT a.author_id, a.author_name FROM author a 
    INNER JOIN title_author ta ON (ta.author_id = a.author_id)
    INNER JOIN books b ON (ta.title_id = b.title_id)
    GROUP BY a.author_id;
