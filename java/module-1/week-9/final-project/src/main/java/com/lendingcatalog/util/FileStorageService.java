package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (PrintWriter file = new PrintWriter(new FileOutputStream(filename, appendFile))) {
            file.println(contents);
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> fileList = new ArrayList<>();
        try (Scanner scanner = new Scanner(filename)) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (nextLine != null) {
                    fileList.add(nextLine);
                }
            }
        }
        return fileList;
    }
}
