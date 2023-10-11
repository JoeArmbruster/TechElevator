package com.lendingcatalog.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.lendingcatalog.util.FileStorageService;

import com.lendingcatalog.util.exception.FileStorageException;

public class Movie implements CatalogItem {

    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator();
    }


    @Override
    public boolean matchesName(String searchStr) {
        return name.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return director.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() {

        this.id = UUID.randomUUID().toString();

        String logMessage = LocalDateTime.now() + " - Movie created: " +
                "Name: " + name +
                ", Director: " + director +
                ", Release Date: " + releaseDate +
                ", ID: " + id;

        try {
            FileStorageService.writeContentsToFile(logMessage, "src/main/resources/logs/movie_log.txt", true);
        } catch (FileStorageException e) {
            e.printStackTrace();
        }
    }
}
