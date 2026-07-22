package Leetcode;

import java.util.Scanner;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i] = digits[i]+1;
                return digits;
            }

            digits[i]=0;
            
        }

        int newArray[] = new int[digits.length+1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size= sc.nextInt();
        
        int arr[]=new int[size];
        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int[] result = plusOne(arr);
        System.out.println("Array after adding one:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        
        sc.close();

    }
}
