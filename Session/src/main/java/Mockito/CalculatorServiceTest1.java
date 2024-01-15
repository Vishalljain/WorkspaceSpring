/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mockito;

/**
 *
 * @author IXL1KOR
 */
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest1 {

    @Mock
    private Calculator calculator;  // Mocking the Calculator dependency

    @Test
    void testExample() {
        // Create an instance of CalculatorService and pass the mock calculator to its constructor
        CalculatorService calculatorService = new CalculatorService(calculator);

        // Stubbing the behavior of the calculator mock
        when(calculator.add(3, 7)).thenReturn(10);

        // Calling the method under test
        int result = calculatorService.calculateSum(3, 7);

        // Verifying that the add method on the calculator mock is called with the expected arguments
        verify(calculator, times(1)).add(3, 7);

        // Asserting the result
        assertEquals(10, result);
    }
}

