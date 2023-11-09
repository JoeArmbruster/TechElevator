-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT movie.title from movie
JOIN person ON movie.director_id = person.person_id
WHERE person.person_name = 'James Cameron'
ORDER BY movie.title;