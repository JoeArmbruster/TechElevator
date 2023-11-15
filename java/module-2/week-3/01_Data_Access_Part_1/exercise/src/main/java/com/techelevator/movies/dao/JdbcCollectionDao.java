package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Collection collection = mapRowToCollection(results);
            collections.add(collection);
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name FROM collection WHERE collection_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()){
            collection = mapRowToCollection(results);
        }
        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();

        if (useWildCard){
            name = "%" + name + "%";
        }

        String sql = "SELECT collection_id, collection_name FROM collection WHERE collection_name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        while(results.next()){
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    public Collection mapRowToCollection(SqlRowSet results){
        Collection collection = new Collection();
        collection.setId(results.getInt("collection_id"));
        collection.setName(results.getString("collection_name"));
        return collection;
    }
}
