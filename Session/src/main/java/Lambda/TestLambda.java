/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

/**
 *
 * @author IXL1KOR
 */


interface interf{
   public void m1(int i,int q);
  // public void m2(int i);
}
public class TestLambda {
    public static void main(String[] args) {
        interf q = (a,b)->System.out.println(a+b);
        q.m1(2,3);
       
    }
}

/*
In Java, a lambda expression can only be used when the interface it targets has a single abstract method. Such an interface is known as a functional interface. If an interface has more than one abstract method, it is no longer a functional interface, and you cannot use a lambda expression to directly implement it.

This restriction is in place to ensure that lambda expressions are unambiguous and can be easily mapped to single-method interfaces. It is the foundation of functional programming constructs in Java.

If you have an interface with more than one abstract method, you have a few options:

Create Separate Lambda Expressions:
You can create separate lambda expressions for each method of the interface. This way, each lambda expression will effectively implement a functional interface with a single abstract method.
*/