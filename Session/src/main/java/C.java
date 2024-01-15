/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */
// Class A
class A {
    int hello;

    A(int helloValue) {
        this.hello = helloValue;
    }
}

// Class B
class B {
    A a; // A reference in class B
    private String name = "Vishal";
    private String numberGiven = "95";

    public B() {
        // Creating an instance of A with hello set to 10
        this.a = new A(10);
    }

    // Method to get the reference to the instance of A
    public A getA() {
        return this.a;
    }
    
    public B getB(){
        return this;
    }
}

// Class C
public class C {
    // Method in class C that takes a reference to an instance of A as a parameter
    public void useAInstance(A aInstance, B bInstance) {
        System.out.println(aInstance.hello);
        bInstance.a.hello=20;
        System.out.println(bInstance.getB()+""+bInstance.getA()+""+aInstance.hello);
        aInstance.hello=10;
        System.out.println(bInstance.getB()+""+bInstance.getA()+""+aInstance.hello);
        System.out.println("");
    }

    public static void main(String[] args) {
        // Creating instances of B and C
        B bObject = new B();
        C cObject = new C();

        // Getting the reference to the instance of A from class B

        A aFromB = bObject.getA();
        B b = bObject.getB();

        // Passing the reference to the instance of A from class B to class C
        cObject.useAInstance(aFromB,b);
    }
}

