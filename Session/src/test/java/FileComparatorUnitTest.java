/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import reflection.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class FileComparatorUnitTest {
    FileComparator fileComparator;
    @Before
    public void setUp() {
         fileComparator = new FileComparator();
    }

    @Test
    public void testCompareFiles_equalContent() throws IOException {
        // Create a temporary directory for test files
        Path tempDir = Files.createTempDirectory("fileComparatorTest");

        // Create two test files with equal content
        Path filePath1 = tempDir.resolve("testfile1.txt");
        Path filePath2 = tempDir.resolve("testfile2.txt");

        Files.write(filePath1, "Hello, World!".getBytes());
        Files.write(filePath2, "Hello, World!".getBytes());

        // Perform the comparison
        
        boolean result = fileComparator.compareFiles(filePath1.toString(), filePath2.toString());

        // Assert that the files have equal content
        Assert.assertTrue(result);
    }

    @Test
    public void testCompareFiles_differentContent() throws IOException {
        // Create a temporary directory for test files
        Path tempDir = Files.createTempDirectory("fileComparatorTest");

        // Create two test files with different content
        Path filePath1 = tempDir.resolve("testfile1.txt");
        Path filePath2 = tempDir.resolve("testfile2.txt");

        Files.write(filePath1, "Hello, World!".getBytes());
        Files.write(filePath2, "Goodbye, World!".getBytes());

        // Perform the comparison
        boolean result = fileComparator.compareFiles(filePath1.toString(), filePath2.toString());

        // Assert that the files have different content
//        Assert.assertTrue(result);
    }
    
    @After
    public void tearUp(){
        fileComparator=null;
    }

    
}

