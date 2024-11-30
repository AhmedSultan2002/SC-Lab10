package expressivo;

/**
 * Immutable class representing a variable in an expression.
 */
public class Variable implements Expression {
    private final String name;
    
    // Abstraction Function:
    //   AF(name) = a variable with a specific name
    //
    // Representation Invariant:
    //   name is non-empty and only contains letters
    //
    // Safety from Rep Exposure:
    //   - name is private, final, and a String (immutable)

    private void checkRep() {
        assert name.matches("[A-Za-z]+");
    }

    public Variable(String name) {
        this.name = name;
        checkRep();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) return false;
        Variable that = (Variable) obj;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
