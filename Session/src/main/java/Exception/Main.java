/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import MarshallingUnMarshalling.InvalidConfigurationException;

/**
 *
 * @author IXL1KOR
 */
public class Main {
    public static void main(String[] args) {
        try {
            int a =7;
            int b =8;
            sum(a,b);
        } catch (InvalidConfigurationException ex) {
            loadData();
        }
    }

    private static int sum(int a, int b) throws InvalidConfigurationException {
        if(a+b==15){
            throw new InvalidConfigurationException("Number is equal to 15");
        }
        else{
            return a+b;
        }
    }

    private static void loadData() {
        System.out.println("Data is in sorted form");
    }
    
}
