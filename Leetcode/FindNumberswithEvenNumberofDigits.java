package Leetcode;

import java.util.*;

public class FindNumberswithEvenNumberofDigits {
    public static int evenNoOfDigits(int arr[],int n){
        int evenDigitCount=0;
        
        for(int i=0;i<n;i++){
            int digitCount=0;
            int temp=arr[i];
            
            while(temp>0){
                digitCount += 1;
                temp /= 10;
            }
            if(digitCount % 2 == 0){
                evenDigitCount += 1;
            }
        }
        return evenDigitCount;
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

        int result= evenNoOfDigits(arr,size);
        System.out.println("Total numbers with even number of digits is "+result);

        sc.close();

    }
}
