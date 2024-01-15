/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

/**
 *
 * @author IXL1KOR
 */

interface inter11{
    int add(int a,int b);
}

public class TestLambda3 {
    public static void main(String[] args) {
        inter11 i = (q,w)->q+w;
        System.out.println(i.add(2, 2));
        
        inter11 sub = (q,w)->{
            int result = q-w;
            return result;
        };
        System.out.println(sub.add(3, 1));
    }
    
}
/*
The lambda expression for addition (x, y) -> x + y does not require the return statement explicitly, as the result of the expression x + y is automatically returned.

The lambda expression for subtraction (x, y) -> { int result = x - y; return result; } uses the return statement explicitly within the block of statements.

In single-expression lambda bodies, the return statement is optional, but in multi-statement lambda bodies, you may use return to specify the return value explicitly. It's worth noting that for most cases, using a single-expre
*/