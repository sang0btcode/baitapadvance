package core1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class bai3 {
    public static void main(String[] args) {
        int[] mangSoNguyen = new int[100];
        int soLuongPhanTu = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\LEGION\\IdeaProjects\\baiTap\\src\\core1\\input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    mangSoNguyen[soLuongPhanTu++] = Integer.parseInt(numbers[i]);
                }
            }
            reader.close();

            quickSort(mangSoNguyen, 0, soLuongPhanTu - 1);

            System.out.println("Mảng số nguyên sau khi sắp xếp:");
            for (int i = 0; i < soLuongPhanTu; i++) {
                System.out.print(mangSoNguyen[i] + " ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (hi > lo) {
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = (lo - 1);
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
