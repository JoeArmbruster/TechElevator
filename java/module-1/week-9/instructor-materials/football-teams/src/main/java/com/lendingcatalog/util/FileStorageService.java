package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename, appendFile))) {
            printWriter.print(contents);
        } catch (FileNotFoundException e) {
            throw new FileStorageException ("Could not access " + filename + "\n" + e.getMessage());
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        File readFile = new File(filename);
        try (Scanner sc = new Scanner(readFile)) {
            List<String> linesOfText = new ArrayList<>();
            while (sc.hasNextLine()) {
                String lineOfText = sc.nextLine();
                linesOfText.add(lineOfText);
            }
            return linesOfText;
        } catch (FileNotFoundException e) {
            throw new FileStorageException("Unable to read from " + filename + "\n" + e.getMessage());
        }

    }
}
