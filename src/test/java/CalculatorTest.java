import calculator.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();
    private static final double DELTA = 1e-6;
    @org.junit.jupiter.api.Test
    void getFactorial() {
        assertEquals( 2, calculator.getFactorial(2), DELTA);
        assertEquals( 120, calculator.getFactorial(5), DELTA);
        assertEquals( 1, calculator.getFactorial(1), DELTA);
        assertEquals( 24, calculator.getFactorial(4), DELTA);
        assertEquals( 1, calculator.getFactorial(0), DELTA);
        assertEquals( 3628800, calculator.getFactorial(10), DELTA);
    }

    @org.junit.jupiter.api.Test
    void getSquareRoot() {
        assertEquals( 3, calculator.getSquareRoot(9), DELTA);
        assertEquals( 10, calculator.getSquareRoot(100), DELTA);
        assertEquals( 4, calculator.getSquareRoot(16), DELTA);
        assertEquals( 16, calculator.getSquareRoot(256), DELTA);
        assertEquals( 1, calculator.getSquareRoot(1), DELTA);
    }

    @org.junit.jupiter.api.Test
    void getNaturalLog() {
        assertEquals(2.1972245, calculator.getNaturalLog(9), DELTA);
        assertEquals( 0, calculator.getNaturalLog(1), DELTA);
        assertEquals( 2.70805, calculator.getNaturalLog(15), DELTA);
    }

    @org.junit.jupiter.api.Test
    void xpowerY() {
        assertEquals( 8, calculator.XpowerY(2, 3), DELTA);
        assertEquals( 625, calculator.XpowerY(5, 4), DELTA);
        assertEquals( 1, calculator.XpowerY(10392, 0), DELTA);
        assertEquals( 16, calculator.XpowerY(2, 4), DELTA);
        assertEquals( 64, calculator.XpowerY(4, 3), DELTA);
    }
}