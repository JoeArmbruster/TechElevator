-- 3. List the first and last name of all authors, separated by a space, (name the column 'author') and the average star rating of their books (name the column 'average_rating').
-- Order by the average rating, lowest first. Where there is a tie in average rating, use a secondary order of author (full name), ascending.
-- (16 rows)

SELECT CONCAT(person.first_name, ' ', person.last_name) AS author, AVG(book.star_rating) AS average_rating
FROM person
JOIN book_author ON person.person_id = book_author.author_id
JOIN book ON book_author.book_id = book.book_id
GROUP BY author
ORDER BY average_rating ASC, author ASC;