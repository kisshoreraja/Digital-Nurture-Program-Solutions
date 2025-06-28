package com.cts.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Setup
        System.out.println("Setup complete.");
    }

    @AfterEach
    void tearDown() {
        calculator = null; // Teardown
        System.out.println("Teardown complete.");
    }

    @Test
    void testAddition() {
        // Arrange done in setup
        // Act
        int result = calculator.add(5, 3);
        // Assert
        assertEquals(8, result);
    }

    @Test
    void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    void testMultiplication() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }
}
