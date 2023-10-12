package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (FileWriter fileWriter = new FileWriter(filename, appendFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(contents);
        } catch (IOException e) {
            throw new FileStorageException("Error writing to file: " + filename, e);
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> lines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line =bufferedReader.readLine()) != null) {
            lines.add(line);
            }
        } catch (IOException e) {
            throw new FileStorageException("Error reading from file: " + filename, e);
        }
        return lines;
    }
}
