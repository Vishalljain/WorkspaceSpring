/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

/**
 *
 * @author IXL1KOR
 */

interface inter1{
    int add(int a,int b);
}

public class TestLambda2 {
    public static void main(String[] args) {
        inter1 i = (q,w)->q+w;
        int add = i.add(1, 2);
        System.out.println(add);
        
    }
    
}
