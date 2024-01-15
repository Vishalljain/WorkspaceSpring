/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class TestRavi1 {

    static void help() {
        try {
            throw new NullPointerException("error_UnNon");
        } catch (NullPointerException e) {
            System.out.println("caught iinside helkp");
            throw e;
        }
    }
    
    
    static void help2(){
        throw new NullPointerException();
    }

    static void help1() {
        try {
            help();
            //help2();
            System.out.println("after help");
        } catch (NullPointerException e) {
            System.out.println("Caught in help1 error name given below:");
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            help1();
        } catch (Exception e) {
            System.out.println("Caught in main error name given below:");
        }

    }

}
