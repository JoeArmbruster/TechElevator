-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)

SELECT DISTINCT person.person_name from person
JOIN movie ON person.person_id = movie.director_id
WHERE movie.length_minutes > 180
ORDER BY person.person_name;