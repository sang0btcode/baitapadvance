package core2.test;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private static final int MAX_SIZE = 5;
    private final Queue<Message> queue;

    public MessageQueue() {
        this.queue = new LinkedList<>();
    }
    public synchronized boolean addMessage(Message message) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        queue.add(message);
        notifyAll();
        return true;
    }
public synchronized Message getMessage() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        Message message = queue.poll();
        notifyAll();
        return message;
}
}
