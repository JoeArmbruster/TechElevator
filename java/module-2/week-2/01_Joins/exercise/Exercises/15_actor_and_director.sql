-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT movie.title, person.person_name AS director_name FROM movie
JOIN person ON movie.director_id = person.person_id
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id AND movie.director_id = movie_actor.actor_id
ORDER BY movie.title;