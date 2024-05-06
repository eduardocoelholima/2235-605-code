package previous_exams.exam3_2221;

public class ThreadOutputB extends Thread {
    static Object lock;
    int id;

    public ThreadOutputB(Object lock, int id) { this.lock = lock; this.id = id; }

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
        new ThreadOutputB(new Object(), 1).start();
        new ThreadOutputB(new Object(), 2).run();
    }
}

// Answer the questions.
// 1 - Are the threads always synchronized on the same objects? Explain. Mention all
// objects that work as locks/monitors.

//Not always. 1. The lock variable: second thread constructor might run (on main thread) before or after
// the first thread runs. 2. The static method synchronization will always be synchronized.

// 2 - Can the main thread finish before thread 2 finishes?

// Yes. The nested synchronization here does not impact the order in which a thread is able to finish,
// After the first lock is acquired, the second lock (the static method lock) will always be able to
// be acquired.

