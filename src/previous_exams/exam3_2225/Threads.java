package exam3;

public class Threads extends Thread {
    static Object lock;
    int id;

    public Threads(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        System.out.println(id + " in");
        synchronized (lock) {
            try{ sleep(100); } catch (Exception e) {}
        }
        System.out.println(id + " out");
    }

    public static void main(String[] args) {
        Thread a = new Threads(new Object(), 1);
        a.start();
        Thread b = new Threads(new Object(), 2);
        b.run();
    }
}

// Answer the questions.
// 1 - Which possible outputs this program has?

// separing cases between synchronized (on the same object) or not.
// if not synchronized:
// 1i 1o 2i 2o
// 1i 2i 1o 2o
// 1i 2i 2o 1o
// 2i 2o 1i 1o
// 2i 1i 1o 2o
// 2i 1i 2o 1o

// if synchronized:
// no illegal monitor exception
// same outputs, but more unlikely to get 1out after 1in or 2out after 2in
