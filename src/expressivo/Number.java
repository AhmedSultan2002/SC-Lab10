package expressivo;

/**
 * Immutable class representing a numeric constant in an expression.
 */
public class Number implements Expression {
    private final double value;
    
    // Abstraction Function:
    //   AF(value) = a numeric constant value
    //
    // Representation Invariant:
    //   true
    //
    // Safety from Rep Exposure:
    //   - value is private and final, and a primitive (immutable)

    private void checkRep() {
        // No specific rep invariant for now
    }

    public Number(double value) {
        this.value = value;
        checkRep();
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Number)) return false;
        Number that = (Number) obj;
        return Double.compare(this.value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
