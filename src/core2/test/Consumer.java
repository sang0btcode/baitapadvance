package core2.test;

public class Consumer implements Runnable {
   private final MessageQueue queue;

   public Consumer(MessageQueue queue) {
       this.queue = queue;
   }
    @Override
    public void run() {
while (true){
    try {
        Message message = queue.getMessage();
        System.out.println("Consumer " + message.getContent());
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    }
}
