package exam3.exam3_2235;
import java.util.*;
import static java.lang.Thread.sleep;

class Drop {
    static private Queue<Object> messages = new LinkedList<>();
    final static private Integer MAX = 2;

    static public Object take() {
        synchronized (messages) {
            while (messages.size() == 0) { try { messages.wait(); } catch (InterruptedException e) { } }
            try { sleep(1000);} catch (Exception e) {}
            messages.notifyAll();
            return messages.remove();
        }
    }

    static public void put(Object message) {
        synchronized (messages) {
            while (messages.size() == MAX) { try { messages.wait(); } catch (InterruptedException e) {} }
            try { sleep(1000); } catch (Exception e) {}
            messages.add(message);
            messages.notifyAll();
        }
    }
}

class Producer implements Runnable {
    private Drop drop;
    public Producer(Drop drop) { this.drop = drop; }

    public void run() {
        Random random = new Random();
        while(true) { drop.put(String.valueOf(random.nextInt(100))); }
    }
}

class Consumer implements Runnable {
    private Drop drop;
    public Consumer(Drop drop) { this.drop = drop; }
    public void run() { while (true) { drop.take(); } }
}

public class DropTest {
    public static void main(String[] args) {
        Drop consumerDrop = new Drop();
        Drop producerDrop = new Drop();
        for (int i=0; i<2; i++) {
            (new Thread(new Producer(consumerDrop))).start();
            (new Thread(new Consumer(producerDrop))).start();
        }
    }
}

//This program compiles as is.

// 1. How many producer threads will be created?

// 2

// 2. How many consumer threads will be created?

// 2

// 3. Is there any racing condition in this program that will cause inconsistent updates?
// An example of an inconsistent update is when an update is lost.

// No, since the synchronization is done using a static variable that is never updated, so
// the few instances of Drop do not affect the correct synchronization behaviour (only one
// thread would be allowed to acquire that lock when running put/take.

// 4. Is the use of synchronization correct in this program? If there is any issue, explain.

// It is correctly implemented, since a single mutex is used by all threads to control
// execution inside the synchronization block

