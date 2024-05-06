package previous_exams.exam3_2221;

public class ProducerConsumerStorage {
    public static void main(String[] args) {
        Storage storage = new Storage();
        (new Thread(new ProducerStorage(storage))).start();
        (new Thread(new ConsumerStorage(storage))).start();
    }
}

// Answer the questions
// 1 - Are there busy loops in this implementation? Where?

//  No. The while loops are "paused" by the wait() calls until the threads are notified.

// 2 - If more than one Storage instance is created, can a 'put' method from one instance
// run concurrently with a 'take' method of another instance? Why?

// As long as the new threads are initialized with the same Storage instance, they will be
// subject to the method synchronization, which only allows a single method to be executed
// at a time (among all threads calling that method on the same Storage instance).
