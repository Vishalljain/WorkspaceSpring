/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */
public class Chaining {
    public static void main(String[] args) {
        String msg = "FALSE";
        String replaceWithSmall = replaceWithSmall(msg);
        System.out.println(replaceWithSmall);
        
    }

    private static String replaceWithSmall(String msg) {
        String replaceAll = msg.replaceAll("FALSE1","False" ).replaceAll("FALSE", "TRUE");
        return replaceAll;
    }
    }
