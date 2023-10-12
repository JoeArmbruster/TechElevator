package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Book implements CatalogItem {

    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator();
    }

    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return author.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return publishDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() {

        this.id = UUID.randomUUID().toString();

        try {
            String message = "The Book " + this.toString() + System.lineSeparator() + " - Was Registered on " + new Date();
            FileStorageService.writeContentsToFile(message, "src/main/resources/logs/book_log.txt", true);
        } catch (FileStorageException e) {
            e.printStackTrace();
        }

//        String logMessage = LocalDateTime.now() + " - Book created: " +
//                "Title: " + title +
//                ", Author: " + author +
//                ", Publish Date: " + publishDate +
//                ", ID: " + id;
//
//        try {
//            FileStorageService.writeContentsToFile(logMessage, "src/main/resources/logs/book_log.txt", true);
//        } catch (FileStorageException e) {
//            e.printStackTrace();
//        }
    }
}
