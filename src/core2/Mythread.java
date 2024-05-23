package core2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Mythread extends Thread {
    boolean check = true;

    @Override
    public void run() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\LEGION\\IdeaProjects\\baiTap\\src\\core2\\output.txt"));
            while (check) {
                int soNguyen = rand.nextInt(100);
                bufferedWriter.write(soNguyen + "\n");
                bufferedWriter.flush();
                Thread.sleep(1000);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void check(boolean b) {
        this.check = b;
    }
}
