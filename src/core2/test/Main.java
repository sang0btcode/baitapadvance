package core2.test;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        Producer producer = new Producer(messageQueue);
        Consumer consumer = new Consumer(messageQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
