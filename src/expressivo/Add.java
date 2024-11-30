package expressivo;

import java.util.Objects;

/**
 * Immutable class representing addition in an expression.
 */
public class Add implements Expression {
    private final Expression left, right;
    
    // Abstraction Function:
    //   AF(left, right) = an addition expression left + right
    //
    // Representation Invariant:
    //   left != null, right != null
    //
    // Safety from Rep Exposure:
    //   - left and right are private, final, and immutable (Expression is immutable)

    private void checkRep() {
        assert left != null && right != null;
    }

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Add)) return false;
        Add that = (Add) obj;
        return this.left.equals(that.left) && this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
