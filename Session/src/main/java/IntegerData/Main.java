/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegerData;

/**
 *
 * @author IXL1KOR
 */
class Base{
    void print(){
        System.out.println("Base");
    }
}
class Derived extends Base{
    @Override
    void print(){
        System.out.println("Derived");
    }
}


public class Main {
    
    static void doPrint(Base base){
        base.print();
    }
    
    public static void main(String[] args) {
        Base b = new Base();
        Base b1 = new Derived();
        Derived d = new Derived();
        
        doPrint(b);//base
        doPrint(b1);//derived
        doPrint(d);//derived
    }
    
}
