package ru.gb.alekseev.level3.lesson7.homework;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeSuit
    public void init() {
        calculator = new Calculator();
        System.out.println("created");
    }

    @Test(9)
    public void testAdd_9() {
        calculator = new Calculator();
        assertEquals(4, calculator.add(2, 2));
    }
    @Test(5)
    public void testSub_5() {
        calculator = new Calculator();
        assertEquals(3, calculator.sub(5, 2));
    }
    @Test(7)
    public void testMul_7() {
        calculator = new Calculator();
        assertEquals(9, calculator.mul(3, 3));
    }
    @Test(5)
    public void testDiv_5() {
        calculator = new Calculator();
        assertEquals(1, calculator.div(2, 2));
    }

    @AfterSuit
    public void close() {
        calculator = null;
        System.out.println("closed");
    }


    private void assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new RuntimeException("Expected value is " + expected + " actual value is " + actual);
    }
}
