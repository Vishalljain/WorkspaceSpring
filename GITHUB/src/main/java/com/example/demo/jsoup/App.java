package com.example.demo.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
	
	public static void getData() throws IOException {
		String url = "https://www.worldometers.info/coronavirus/country/us/";
	       Document doc = Jsoup.connect(url).get();
	        System.out.println(doc.title());
		
	}
	public static void main(String[] args) throws IOException {
		
		getData();
		
	}

}
