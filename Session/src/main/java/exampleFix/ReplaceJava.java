/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exampleFix;

/**
 *
 * @author IXL1KOR
 */
public class ReplaceJava {
    public static void main(String[] args) {
        String line = "V:(MainVariant R:'VarianteSPLIT_REPLACE1' C:'KundeSPLIT_REPLACE1' I:'Intern 1' T:'TKUSPLIT_REPLACE1' X7:{'ProduktSPLIT_REPLACE1';'MeinKunde';'S1';'SchaltbildSPLIT_REPLACE1';'BemerkungSPLIT_REPLACE1';'LegendeSPLIT_REPLACE1';;'K1';1} Code:1 Con:'S1'\"";
         String splitString[] = line.replaceAll("\\{|\\}|\\)", "").split(" ");
         for(String s: splitString){
             System.out.println(""+s);
         }
         
    }
}
