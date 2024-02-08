package exam3;
import java.util.*;
import static java.lang.Thread.sleep;

class Drop<T> {
    private Queue<T> messages = new LinkedList<>();
    private Integer MAX = 10;

    public synchronized T take() {
        while (messages.size()==0) { try { wait(); } catch (InterruptedException e) {} }
        try{ sleep(1000); } catch (Exception e) {};
        notifyAll();
        T message = messages.remove();
        System.out.printf("DROP: %s%n", messages);
        return message;
    }

    public synchronized void put(T message) {
        while (messages.size()==MAX) { try { wait(); } catch (InterruptedException e) {} }
        try{ sleep(1000); } catch (Exception e) {};
        messages.add(message);
        System.out.printf("DROP: %s%n", messages);
        notifyAll();
    }
}

class Producer implements Runnable {
    private Drop<String> drop;
    public Producer(Drop drop) { this.drop = drop; }

    public void run() {
        Random random = new Random();
        while(true) { drop.put(String.valueOf(random.nextInt(100))); }
    }
}

class Consumer implements Runnable {
    private Drop<String> drop;
    public Consumer(Drop drop) { this.drop = drop; }

    public void run() {
        Random random = new Random();
        while (true) { drop.take(); }
    }
}

public class DropTest {
    public static void main(String[] args) {
        Drop<String> drop = new Drop<>();
        for (int i=0; i<4; i++) {
            (new Thread(new Producer(drop))).start();
            (new Thread(new Consumer(drop))).start();
        }
    }
}

// 1. How many producer threads will be created?
// 2. How many consumer threads will be created?
// 3. How many messages can be stored in a Drop instance?
// 4. Which object(s) is(are) acting as lock(s)/monitor(s) in this program?
