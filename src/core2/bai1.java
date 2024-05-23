package core2;


import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mythread mt = new Mythread();
        Thread t1 = new Thread(mt);
        t1.start();
        System.out.println("Nhập 'STOP' để dừng chương trình ");
        while (true) {
            String input = sc.next();
            if (input.equals("STOP")) {
                mt.check(false);
                System.out.println("Chương trình đã dừng");
            }
        }
    }
}
