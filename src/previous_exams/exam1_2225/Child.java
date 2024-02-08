//package exam1; //3

interface Contract {
    String scream();
}

abstract class Parent {
    final public String scream() { return "aaaaa"; }
}

public final class Child extends Parent implements Contract {
    public static void main(String[] args) {}
}

// Answer the following questions.

// 1. Is the Child class required to implement scream() in this source code? Why?

// 2. Can the Child class override scream()? Why?

// 3. Can a subclass of Child be declared? Why?

// 4. Can we change the access modifier of scream() in Contract to private? Why?
