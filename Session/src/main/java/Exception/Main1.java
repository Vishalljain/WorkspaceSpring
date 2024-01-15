package Exception;

import MarshallingUnMarshalling.InvalidConfigurationException;

/**
 *
 * @author IXL1KOR
 */
public class Main1 {
    public static void main(String[] args) {
        int a =7;
        int b =8;
        int sum = sum(a,b);
        System.out.println(sum);
    }

    private static int sum(int a, int b){
        if(a+b==15){
            try {
                throw new InvalidConfigurationException("Number is equal to 15");
            } catch (InvalidConfigurationException ex) {
                loadData(a,b);
            }
        }
        
        return a+b;
    }

    private static void loadData(int a ,int b) {
        a=a+1;
        b=b+1;
        sum(a, b);
       
    }
    
}
