package previous_exams.exam1_2225; //5

public class SubClass extends SuperClass {

    private int value = 0;
    private SubClass(int value) { super.value = value; }

    private void increment() { value++; }
    public String toString() { return String.valueOf(value); }

    public static void main(String[] args) {
        System.out.println(new SubClass(1));
    }
}

class SuperClass {
    protected int value = 10;

    SuperClass() {} // MARKED
    SuperClass(int value) { this.value = value; }
}

// Answer the following.

// 1. The output of this code is "0". How would you fix the code to make it print the value passed in the constructor call of SubClass?

// 2. Can the line with the comment "MARKED" be fully removed with no harm to the execution of this code? Why?
