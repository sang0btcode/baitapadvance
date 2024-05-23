package core1;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soCanNhap = 123;
        int soCanNhapToiDa = 5;
        int soDaNhap = 0;
        boolean daNhapDung = false;
        while (!daNhapDung && soDaNhap < soCanNhap) {
            System.out.println("Nhập số : ");
            int soNhap = sc.nextInt();
            soDaNhap++;
            if (soNhap == soCanNhap) {
                System.out.println("Chính xác");
                daNhapDung = true;
            }else {
                System.out.println("Sai rồi! Vui lòng nhập lại");
            }
            if (soDaNhap == 5) {
                System.out.println("Đã hết số lần nhập");
                break;
            }
        }


    }
}
