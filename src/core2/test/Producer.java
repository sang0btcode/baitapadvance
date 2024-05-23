package core2.test;

public class Producer implements Runnable {
    private final MessageQueue queue;
    public Producer(MessageQueue queue) {
        this.queue = queue;
    }
    public void run() {
        int messageCount = 1;
        while (true) {
            try {
                String message = "Message " + messageCount++;
                queue.addMessage(new Message(message));
                System.out.println("Produced: " + message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
