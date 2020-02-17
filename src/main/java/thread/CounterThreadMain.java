package thread;

/**
 * Default behaviour of Thread:
 *  execute it independently even though Main thread has existed (unless using join or daemon)
 */
class Counter {

    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
        System.out.println(count);
    }
}

class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}

public class CounterThreadMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        System.out.println("Main thread done.");

        threadA.join();
        threadB.join();
        System.out.println("All Other thread done.");
    }
}