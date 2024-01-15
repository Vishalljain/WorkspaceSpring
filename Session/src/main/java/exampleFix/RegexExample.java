/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exampleFix;

/**
 *
 * @author IXL1KOR
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static final String REGEX_CHAR_IN_QUOTES = "\\'(.*?)\\'";
    public static final String SINGLE_QUOTE = "SINGLE_QUOTE";

    public static void main(String[] args) {
        String pattern = REGEX_CHAR_IN_QUOTES;
        String line = "V:(SubVariant R:'Untervariante 1' C:'Kunde 1' I:'Intern 1' T:'TKU 1.1' X7:{'Produkt 1.1';'Mein Kunde';'S1';'Schaltbild 1.1';'Bemerkung 1.1';'Legende 1.1';;;2}))";
        
        // Replace double single quotes with the SINGLE_QUOTE constant
        line = line.replaceAll("''",SINGLE_QUOTE);
        // Compile the regular expression pattern
        Pattern p = Pattern.compile(pattern);

        // Create a matcher with the input string
        Matcher m = p.matcher(line);

        // Use the find method to find matches
        while (m.find()) {
            // Retrieve the matched substring
            String temp = m.group();
            
            // Your code using the matched substring (temp) goes here
            System.out.println("Match found: " + temp);
        }
    }
}
