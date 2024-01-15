package com.vishal.practise;

public class Hello {
	
	
	public static void main() {
		String word = "india is my country";
		String[] split = word.split(" ");
		for(int i =split.length-1;i>=0;i--) {
			System.out.print(split[i]+" ");
		}
	}

}
