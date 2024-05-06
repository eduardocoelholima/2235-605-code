package previous_exams.exam3_2221;

public class ThreadOutputA extends Thread {
    static Object lock;
    int id;

    public ThreadOutputA(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        System.out.println(id + "before");
        synchronized (lock) { printSomething(id); }
        System.out.println(id + "after");
    }

    private static synchronized void printSomething (int id) {
        System.out.println(id + "in");
        try { sleep(100); } catch (Exception e) {}
        System.out.println(id + "out");
    }

    public static void main(String[] args) {
        new ThreadOutputA(new Object(), 1).start();
        new ThreadOutputA(new Object(), 2).run();
    }
}

// Answer the questions.
// 1 - Which possible outputs this program has?

// The lock field object might be synchronized or not
// (we have two threads: main and the first thread instance created).
// So you can have any combination of 1b,2b, then 1in always followed by 1out,
//  and 2in always followed by 2out. Either pairs can go first. Then the 1a,2a can
// appear anywhere after their respective 2out,1out.

// 2 - Which objects are the threads synchronized on?

// Possibly the objects passed to the constructors. For sure the static object.
