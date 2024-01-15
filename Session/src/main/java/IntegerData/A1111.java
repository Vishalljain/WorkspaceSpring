/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegerData;

/**
 *
 * @author IXL1KOR
 */
public class A1111 {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = new Integer(100);
        Integer c = 500;
        Integer d = new Integer(500);
        Integer e = 124;
        int f = 124;
        Integer g = new Integer(500);
        int h = 500;
        Integer i = 700;
        int j = i;
        Integer k = new Integer(500);
        Integer l = k;
        Integer m = new Integer(500);
        int n = m;
        
        System.out.println(a==b);//false
        System.out.println(c==d);//false
        System.out.println(e==f);//true
        System.out.println(g==h);//true
        System.out.println(j==i);//true
         System.out.println(l==k);//true
         System.out.println(m==n);//true
        System.out.println(a.equals(b));//true
        System.out.println(c.equals(d));//true
        System.out.println(e.equals(f));//true
         System.out.println(g.equals(h));//true
    }
}
