-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)

SELECT book.book_title, CONCAT (person_foreword.first_name, ' ', person_foreword.last_name) AS foreword_author
FROM book_author
JOIN book ON book_author.book_id = book.book_id
JOIN person ON book_author.author_id = person.person_id
JOIN person AS person_foreword ON book.foreword_by = person_foreword.person_id
WHERE person.first_name = 'Moishe' AND person.last_name = 'Reiling'
ORDER BY book.book_title;