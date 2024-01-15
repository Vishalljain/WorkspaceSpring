/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exampleFix;

/**
 *
 * @author IXL1KOR
 */
public class Data {
    public static void main(String[] args) {
        String prjDataLine = "data1;data2;;data4;";
        String[] prjDatas = prjDataLine.split(";",5);
       for(String pro:prjDatas){
           System.out.println(""+pro);
       }

// prjDatas will contain: ["data1", "data2", "data4"]

    }
}
