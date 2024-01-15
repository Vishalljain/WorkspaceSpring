/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegerData;

/**
 *
 * @author IXL1KOR
 */
public class A111 {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b =new Integer(100);
        Integer c = new Integer(500);
        Integer d = new Integer(500);
        Integer e = new Integer(124);
        Integer f = new Integer(125);
        
        System.out.println(a==b);//false
        System.out.println(c==d);//false
        System.out.println(e==f);//false
        System.out.println(a.equals(b));//true
        System.out.println(c.equals(d));//true
        System.out.println(e.equals(f));//false
    }
}
