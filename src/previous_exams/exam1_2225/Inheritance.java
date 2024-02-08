//package exam1; //4

public class Inheritance extends InheritanceParent {
    private int counter;

    public static InheritanceParent increment(InheritanceParent o) {
        o.counter += 1;
        return o;
    }

    protected InheritanceParent increment() {
        counter++;
        return this;
    }

    public String toString() { return String.valueOf(counter); }

    public static void main(String[] args) {
        Inheritance child = new Inheritance();
        InheritanceParent parent = child.increment();
        System.out.println("" + parent.counter + " " + child.counter);
        parent.increment();
        System.out.println("" + parent.counter + " " + child.counter);
    }
}

class InheritanceParent {
    protected int counter = 10;

    protected InheritanceParent increment() {
        counter++;
        return this;
    }
}
// Answer the following question.

// 1. What is the output of this code?
