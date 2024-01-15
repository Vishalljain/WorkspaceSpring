package com.vishal.practise;

import java.util.Arrays;

public class Hello3 {
	public static void main(String[] args) {
		 String word = "india is my country";
		 String[] a = word.split(" ");
		 int i=0,j=a.length-1;
		 while(i<j) { 
			 String temp = a[i];
			 a[i]=a[j];
			 a[j]=temp;
			 i++;
			 j--;
		 }
		 System.out.println(Arrays.toString(a));
		 String join = String.join(" ", a);
		 System.out.println(join);
	}

}


/*
(0<3)
temp=a[0]
a[0]=a[3]
a[3]=a[0]  //country is my India

(1<2)
temp=a[1]
a[1]=a[2]
a[2]=a[1]//country my is India

*/