/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */


public class TestRavi {
	static void sum() throws ArithmeticException {
		System.out.println("inside sum");
                try{
                    int data1 = 50 / 0;
                }catch(Exception e){
                    System.out.println("Inside");
                }
		sum3();
		// throw new ArithmeticException("cvdsvdbcscsc");
	}
 
	static void sum3() throws ArithmeticException {
		System.out.println("inside sum3");
 
	}
 
	static void sum2() throws ArithmeticException {
		System.out.println("inside sum2");
		sum();
	}
 
	public static void main(String[] args) {
		try {
			sum2();
                       
		} catch (ArithmeticException e) {
			System.out.println("try executed");
			
		}
 
	}
 
}
 

 
