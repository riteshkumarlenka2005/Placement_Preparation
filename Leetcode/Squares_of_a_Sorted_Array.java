package Leetcode;

import java.util.Arrays;
import java.util.Scanner;


//------------ Brute Force approach --------- 

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size= sc.nextInt();
        
        int arr[]=new int[size];
        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        System.out.println("The final array would be: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+ " ");
        }

        sc.close();

    }
}



// ----------  Two Pointer approach for Optimal solution -----------
