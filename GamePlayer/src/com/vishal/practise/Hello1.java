package com.vishal.practise;

import java.util.Scanner;

public class Hello1 {
	    public static void main(String[] args){
	    String word = "india is my country";
	    StringBuffer sb = new StringBuffer();
	    String[] split = word.split("\\s");
	    for(int i =split.length-1;i>=0;i--) {
	    	sb.append(split[i]);
	    	sb.append(" ");
	    }
	    System.out.println(sb.toString());
	  
	}
}


