package core2;

import java.util.Scanner;




public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mythread mt = new Mythread();
        Thread t1 = new Thread(mt);
        t1.start();
        System.out.println("Chương trình sẽ dừng sau ");
        try {
            Thread.sleep(30000);
            mt.check(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
