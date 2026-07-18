package DSA._01_Arrays;
import java.util.*;


public class Concatenation_of_2Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the 1st array: ");
        int size1 = sc.nextInt();

        int arr1[] = new int[size1];

        System.out.println("Enter the elements into the 1st array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the 2nd array: ");
        int size2 = sc.nextInt();

        int arr2[] = new int[size2];

        System.out.println("Enter the elements into the 2nd array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Create third array
        int size3 = size1 + size2;
        int arr3[] = new int[size3];

        // Copy first array
        for (int i = 0; i < size1; i++) {
            arr3[i] = arr1[i];
        }

        // Copy second array
        for (int i = size1, j = 0; i < size3; i++, j++) {
            arr3[i] = arr2[j];
        }

        System.out.println("After concatenation the array is:");

        for (int i = 0; i < size3; i++) {
            System.out.print(arr3[i] + " ");
        }

        sc.close();
    }
}
