package DSA._01_Arrays;

import java.util.*;

public class Third_Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Please Enter a valid positive Input:");
            sc.close();
            return;

        }

        int arr[] = new int[size];
        System.out.println("Enter " + size + " elements into the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();

        }

        int largest = Integer.MIN_VALUE;
        int s_largest = Integer.MIN_VALUE;
        int t_largest = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] > largest) {
                t_largest = s_largest;
                s_largest = largest;
                largest = arr[i];
            } else if (arr[i] > s_largest && arr[i] < largest) {
                t_largest = s_largest;
                s_largest = arr[i];

            } else if (arr[i] > t_largest && arr[i] < s_largest) {
                t_largest = arr[i];
            }

        }

        System.out.println("The third largest element is " + t_largest);

        sc.close();
    }
}
