package DSA._01_Arrays;

import java.util.*;

public class Check_Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Please enter a valid integer value!");
            sc.close();
            return;
        }

        System.out.println("Enter " + size + " elements in to the array:");
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        boolean is_Sorted = true;

        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                is_Sorted = false;
                break;
            }

        }
        if (is_Sorted) {
            System.out.println("The array is sorted.");
        } else {
            System.out.println("The array is not sorted !!");
        }

        sc.close();

    }
}
