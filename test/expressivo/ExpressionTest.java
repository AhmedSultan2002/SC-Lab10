package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Testing strategy:
    // - Number:
    //     - Test creation with integers and floating-point numbers
    //     - Test toString() formatting for numeric values
    //     - Test equality and hashCode consistency for equivalent and non-equivalent values
    // - Variable:
    //     - Test creation with single-letter and multi-letter variables
    //     - Test toString() formatting for variable names
    //     - Test equality and hashCode consistency for equivalent and non-equivalent names
    // - Add:
    //     - Test creation with two Number, two Variable, and mixed Number/Variable inputs
    //     - Test recursive toString() formatting for addition
    //     - Test equality and hashCode consistency for equivalent and non-equivalent expressions
    // - Multiply:
    //     - Test creation with two Number, two Variable, and mixed Number/Variable inputs
    //     - Test recursive toString() formatting for multiplication
    //     - Test equality and hashCode consistency for equivalent and non-equivalent expressions

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // Tests for Number
    @Test
    public void testNumberCreationAndToString() {
        Expression num1 = new Number(5);
        Expression num2 = new Number(3.14);
        assertEquals("5.0", num1.toString());
        assertEquals("3.14", num2.toString());
    }

    @Test
    public void testNumberEqualityAndHashCode() {
        Expression num1 = new Number(5);
        Expression num2 = new Number(5.0);
        Expression num3 = new Number(3);
        assertEquals(num1, num2);
        assertEquals(num1.hashCode(), num2.hashCode());
        assertNotEquals(num1, num3);
    }

    // Tests for Variable
    @Test
    public void testVariableCreationAndToString() {
        Expression var1 = new Variable("x");
        Expression var2 = new Variable("y");
        assertEquals("x", var1.toString());
        assertEquals("y", var2.toString());
    }

    @Test
    public void testVariableEqualityAndHashCode() {
        Expression var1 = new Variable("x");
        Expression var2 = new Variable("x");
        Expression var3 = new Variable("y");
        assertEquals(var1, var2);
        assertEquals(var1.hashCode(), var2.hashCode());
        assertNotEquals(var1, var3);
    }

    // Tests for Add
    @Test
    public void testAddCreationAndToString() {
        Expression add1 = new Add(new Number(3), new Variable("x"));
        Expression add2 = new Add(new Variable("y"), new Variable("z"));
        assertEquals("(3.0 + x)", add1.toString());
        assertEquals("(y + z)", add2.toString());
    }

    @Test
    public void testAddEqualityAndHashCode() {
        Expression add1 = new Add(new Number(3), new Variable("x"));
        Expression add2 = new Add(new Number(3), new Variable("x"));
        Expression add3 = new Add(new Variable("y"), new Variable("z"));
        assertEquals(add1, add2);
        assertEquals(add1.hashCode(), add2.hashCode());
        assertNotEquals(add1, add3);
    }

    // Tests for Multiply
    @Test
    public void testMultiplyCreationAndToString() {
        Expression mul1 = new Multiply(new Number(3), new Variable("x"));
        Expression mul2 = new Multiply(new Variable("y"), new Variable("z"));
        assertEquals("(3.0 * x)", mul1.toString());
        assertEquals("(y * z)", mul2.toString());
    }

    @Test
    public void testMultiplyEqualityAndHashCode() {
        Expression mul1 = new Multiply(new Number(3), new Variable("x"));
        Expression mul2 = new Multiply(new Number(3), new Variable("x"));
        Expression mul3 = new Multiply(new Variable("y"), new Variable("z"));
        assertEquals(mul1, mul2);
        assertEquals(mul1.hashCode(), mul2.hashCode());
        assertNotEquals(mul1, mul3);
    }

    // Mixed operations tests
    @Test
    public void testMixedOperationsToString() {
        Expression expr = new Add(new Multiply(new Number(2), new Variable("x")), new Number(3));
        assertEquals("((2.0 * x) + 3.0)", expr.toString());
    }

    @Test
    public void testMixedOperationsEqualityAndHashCode() {
        Expression expr1 = new Add(new Multiply(new Number(2), new Variable("x")), new Number(3));
        Expression expr2 = new Add(new Multiply(new Number(2), new Variable("x")), new Number(3));
        Expression expr3 = new Multiply(new Add(new Number(2), new Variable("x")), new Number(3));
        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());
        assertNotEquals(expr1, expr3);
    }
}
