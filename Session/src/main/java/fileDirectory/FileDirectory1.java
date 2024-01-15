/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IXL1KOR
 */
public class FileDirectory1 {
    public static void main(String[] args) {
        
        String path = "C:\\Users\\IXL1KOR\\Desktop\\Pav2Py Docs";
        File file = new File(path);
        List<String> filenames = new ArrayList();
        checkForDirectory(file,filenames);
        
        System.out.println("List of filenames:");
        ExtractingFileName(filenames);
    }

    public static void ExtractingFileName(List<String> filenames) {
        for (String filename : filenames) {
            int lastIndexOf = filename.lastIndexOf("\\");
            if(lastIndexOf!=-1){
                String fileName1 = filename.substring(lastIndexOf+1);
                System.out.println(fileName1);
            }
            
        }
    }

    private static void checkForDirectory(File directory,List list) {
        
        if(directory.isDirectory()){
           // System.out.println("Listing files in directory: " + directory.getAbsolutePath());
            File[] listFiles = directory.listFiles();
            for(File file:listFiles){
                if(file!=null){
                    if(file.isDirectory()){
                        checkForDirectory(file,list);
                    }else{
                        list.add(file.getAbsolutePath());
                        //System.out.println(file.getAbsolutePath());
                    }
            }
            }
            
        }else{
           // System.out.println(directory.getAbsolutePath()+"is not a directory");
        }
        
            }
}
