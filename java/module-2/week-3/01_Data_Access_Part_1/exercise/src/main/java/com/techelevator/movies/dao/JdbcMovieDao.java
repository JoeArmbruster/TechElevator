package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Movie movie = mapRowToMovie(results);
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT * FROM movie WHERE movie_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            movie = mapRowToMovie(results);
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        if (useWildCard) {
            title = "%" + title + "%";
        }
        String sql = "SELECT * FROM movie WHERE title ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);

        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        if (useWildCard) {
            directorName = "%" + directorName + "%";
        }

        String sql = "SELECT * FROM movie " +
                "JOIN person ON movie.director_id = person.person_id " +
                "WHERE movie.release_date BETWEEN ? AND ? AND person.person_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, startYear, endYear, directorName);
        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }

        return movies;
    }

    public Movie mapRowToMovie(SqlRowSet results) {
        Movie movie = new Movie();
        movie.setId(results.getInt("movie_id"));
        movie.setTitle(results.getString("title"));
        movie.setOverview(results.getString("overview"));
        movie.setTagline(results.getString("tagline"));
        movie.setPosterPath(results.getString("poster_path"));
        movie.setHomePage(results.getString("home_page"));
        if (results.getDate("release_date") != null) {
            movie.setReleaseDate(results.getDate("release_date").toLocalDate());
        }
        movie.setLengthMinutes(results.getInt("length_minutes"));
        movie.setDirectorId(results.getInt("director_id"));
        movie.setCollectionId(results.getInt("collection_id"));
        return movie;
    }
}
