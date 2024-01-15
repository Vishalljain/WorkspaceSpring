/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reflection;

/**
 *
 * @author IXL1KOR
 */
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileComparator {

    public boolean compareFiles(String filePath1, String filePath2) throws IOException {
        // Read content of both files
        List<String> lines1 = Files.readAllLines(Paths.get(filePath1));
        List<String> lines2 = Files.readAllLines(Paths.get(filePath2));

        // Join lines to get the full content
        String content1 = String.join(System.lineSeparator(), lines1);
        String content2 = String.join(System.lineSeparator(), lines2);

        // Compare contents
        return content1.equals(content2);
    }
}


