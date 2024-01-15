/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mockito;

/**
 *
 * @author IXL1KOR
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
    
    @Mock
    private Calculator calculator;// Mocking the Calculator dependency
    
    @InjectMocks
    private CalculatorService calculatorService;  // Injecting the mock into the CalculatorService
    
    @Test
    void testCalculateSum() {
        // Stubbing the behavior of the calculator mock
        when(calculator.add(3, 7)).thenReturn(10);

        // Calling the method under test
        int result = calculatorService.calculateSum(3, 7);

        // Verifying that the add method on the calculator mock is called with the expected arguments
        verify(calculator, times(1)).add(3, 7);

        // Asserting the result
        assertEquals(10, result);
    }
    
     @Test
    void testCalculateDifference() {
        // Stubbing the behavior of the calculator mock
        when(calculator.subtract(10, 5)).thenReturn(5);

        // Calling the method under test
        int result = calculatorService.calculateDifference(10, 5);

        // Verifying that the subtract method on the calculator mock is called with the expected arguments
        verify(calculator, times(1)).subtract(10, 5);

        // Asserting the result
        assertEquals(5, result);
    }
}
    

