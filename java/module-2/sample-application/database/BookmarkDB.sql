SELECT username FROM app_user WHERE role = 'ROLE_ADMIN';

SELECT username, user_id FROM app_user WHERE display_name IS NULL;

SELECT DISTINCT url FROM bookmark;

SELECT title, url FROM bookmark WHERE description LIKE '%recommend%';

SELECT title, url FROM bookmark WHERE user_id IN (2, 3, 4);

SELECT COUNT(*) AS total_bookmarks FROM bookmark;

SELECT user_id, COUNT(*) AS bookmark_count FROM bookmark GROUP BY user_id;

SELECT bookmark_id, COUNT(*) AS user_count FROM bookmark GROUP BY bookmark_id;

SELECT COUNT(*) / COUNT(DISTINCT user_id) AS average_bookmarks_per_user FROM bookmark;

SELECT * FROM bookmark WHERE user_id IN (SELECT user_id FROM app_user WHERE display_name IS NULL);

SELECT username FROM app_user WHERE user_id IN (SELECT user_id FROM bookmark WHERE description ILIKE '%Tips%');	