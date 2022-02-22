-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

-- SELECT movie_id
-- FROM movie
-- WHERE title = 'Coach Carter'; -- 7214

-- SELECT *
-- FROM genre;

INSERT INTO genre (genre_name)
VALUES ('Sports'); -- Genre ID: 11771

INSERT INTO movie_genre (movie_id, genre_id)
VALUES (7214, 11771);