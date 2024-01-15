package com.example.demo;

public class Example {
    public static void main(String[] args) {
        try {
            int b=call();
            System.out.println(b);
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
       
    }

    public static int divide(int a, int b) {
        return a / b;
    }
    
    public static int call() {
    	int a= divide(10,0);
		return a;
    }
}
