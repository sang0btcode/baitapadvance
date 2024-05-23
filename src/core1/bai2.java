package core1;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soDien, thanhtien;
        System.out.print("Nhap so dien : ");
        soDien = sc.nextDouble();
        if (soDien < 100) {
            thanhtien = soDien * 1000;
        }else if (soDien > 100 && soDien < 150) {
            thanhtien = soDien * 1500;
        }else  {
            thanhtien = soDien * 2000;
        }
        System.out.println("Nhap so dien : " + thanhtien + "đ");
    }
}
