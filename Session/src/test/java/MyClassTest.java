/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IXL1KOR
 */
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThrows;
import reflection.MyClass;

public class MyClassTest {

    @Test
   
    public void testExceptionIsThrown() {
        MyClass tester = new MyClass();
        assertThrows(IllegalArgumentException.class, () -> tester.multiply(1000, 5));
    }

    @Test
    public void testMultiply() {
        MyClass tester = new MyClass();
        Assert.assertEquals(2, tester.multiply(10, 5));
       
    }
}
//https://www.vogella.com/tutorials/JUnit/article.html