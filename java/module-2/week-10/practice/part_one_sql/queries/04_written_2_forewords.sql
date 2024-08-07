-- 4. List the first and last name of all persons, separated by a space, (name the column 'full_name') who have written at least 2 forewords.
-- Include the count of forewords written by each person (name the column 'foreword_count').
-- Order by full_name ascending.
-- (7 rows)

SELECT CONCAT(person.first_name, ' ', person.last_name) AS full_name, COUNT(book.foreword_by) AS foreword_count
FROM person
JOIN book ON person.person_id = book.foreword_by
WHERE book.foreword_by IS NOT NULL
GROUP BY full_name
HAVING COUNT(book.foreword_by) >= 2
ORDER BY full_name ASC;