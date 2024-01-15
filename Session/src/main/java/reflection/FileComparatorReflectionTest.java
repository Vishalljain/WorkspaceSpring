/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reflection;

/**
 *
 * @author IXL1KOR
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileComparatorReflectionTest {

    public static void main(String[] args) {
        // Create an instance of the class containing the file comparison method
        FileComparator fileComparator = new FileComparator();

        // Get the Class object for the class containing the method
        Class<FileComparator> fileComparatorClass = FileComparator.class;

        // Get the Method object for the file comparison method
        try {
            Method compareFilesMethod = fileComparatorClass.getDeclaredMethod("compareFiles", String.class, String.class);

            // Make the method accessible (assuming it's not public)
            compareFilesMethod.setAccessible(true);

            // Prepare test file paths
            String filePath1 = "C:\\Users\\IXL1KOR\\Pictures\\Phothos\\a.txt";
            String filePath2 = "C:\\Users\\IXL1KOR\\Pictures\\Phothos\\b.txt";

            try {
                // Invoke the method using reflection
                boolean result = (boolean) compareFilesMethod.invoke(fileComparator, filePath1, filePath2);

                // Assert the result
                if (result) {
                    System.out.println("Files are equal.");
                } else {
                    System.out.println("Files are not equal.");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

