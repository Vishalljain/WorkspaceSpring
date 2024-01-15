/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */
class A11{
    public void show() throws Exception{
        System.out.println("Inside A");
    }
}

class B11 extends A11{
   @Override
   public void show() throws NullPointerException{
       System.out.println("Inside B");
   }
}



public class InheritanceExample {
    public static void main(String[] args) throws Exception {
      // B a = (B) new A(); //In Java, casting an object from a superclass to a subclass is not allowed, and it results in a compilation error. The reason for this is that the superclass object might not actually be an instance of the subclass, and attempting such a cast could lead to a ClassCastException at runtime.
       //a.show();
       
        A11 b = new B11();
        b.show();
    }
}
