package exam3.exam3_2235;

import java.util.ArrayList;

public class Threads extends Thread {
    static Object lock = new ArrayList<>();
    int id;

    public Threads(Object lock, int id) { this.lock = lock; this.id = id; }

    public void run () {
        synchronized (lock) {
            try{ if (id == 1) sleep(100); } catch (InterruptedException e) {}
            System.out.println(id);
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        (new Threads(lock, 1)).start();
        (new Threads(lock, 2)).start();
    }
}

// Answer the questions.
// 1 - In this program, is an IllegalMonitorStateException possible? Why?

// 2 - When does an IllegalMonitorStateException happens, in any java program?

// 3 - What are the possible outputs of this program?

// always synchronized:
// 1122
// 2211

//4 - Any output/s is/are more likely to occur? Why?

// equally likely