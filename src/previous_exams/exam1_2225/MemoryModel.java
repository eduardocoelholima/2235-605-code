package previous_exams.exam1_2225; //1

public class MemoryModel {

    int o = 0;
    MemoryModel(int o) { this.o = o; }

    public MemoryModel change(MemoryModel o) {
        this.o = o.o;
        return this;
    }

    public String toString() { return String.valueOf(o); }

    public static void main(String[] args) {
        MemoryModel o = new MemoryModel(1);
        System.out.println(o);
        System.out.println(o.o);
        System.out.println(o.change(new MemoryModel(2)));
    }
}

// Answer the following.

// 1. What is the output of this program?

// 2. Describe the implementation of the change() method.

// 3. In change() method, what does this.o refers to?

// 4. In change() method, what does o.o refers to?

// 5. Is there any problem in the constructor?
