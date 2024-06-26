package previous_exams.exam3_2221;

public class ProducerConsumerDrop {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}

// Answer the questions
// 1 - What can happen if the synchronized keyword is removed from 'take' and 'put' methods?

// The threads will access shared variables (message, empty) without a mutex, which can cause
// out-of-date reads and lost updates

// 2 - How many messages the "Drop" storage can hold at the same time?

// one