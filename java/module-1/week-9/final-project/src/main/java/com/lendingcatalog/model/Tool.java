package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tool implements CatalogItem {

    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public String toString() {
        return "* Type: " + type + System.lineSeparator()
                + " - Manufacturer: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator();
    }

    @Override
    public boolean matchesName(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {

        this.id = UUID.randomUUID().toString();

        String logMessage = LocalDateTime.now() + " - Tool created: " +
                "Type: " + type +
                ", Manufacturer: " + manufacturer +
                ", Count: " + count +
                ", ID: " + id;

        try {
            FileStorageService.writeContentsToFile(logMessage, "src/main/resources/logs/tool_log.txt", true);
        } catch (FileStorageException e) {
            e.printStackTrace();
        }

    }
}
