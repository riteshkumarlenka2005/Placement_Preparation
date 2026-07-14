package DSA._01_Arrays;

import java.util.*;

public class Missing_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number Upto what you want to print:");
        int num = sc.nextInt();

        long sum = (num * (num + 1)) / 2;
        long sum2 = 0;
        System.out.println("Enter the 1st n elements:");
        // int arr[] = new int[num - 1];

        // for (int i = 0; i < num - 1; i++) {   
        // arr[i] = sc.nextInt();
        // sum2 += arr[i];
        // }

        // ------------------- OR ----------------------(to reduce space complexity - O(1))

        for (int i = 0; i < num - 1; i++) {
            sum2 += sc.nextLong();

        }

        long missing_number = sum - sum2;
        System.out.println("The missing number is " + missing_number);

        sc.close();
    }
}
