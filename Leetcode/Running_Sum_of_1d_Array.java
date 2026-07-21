package Leetcode;

import java.util.*;

public class Running_Sum_of_1d_Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size= sc.nextInt();
        
        int arr[]=new int[size];
        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

       
       
        int sum=0;
        for(int i=0;i<size;i++){
            sum=sum+arr[i];
            arr[i]=sum;
            
        }

        System.out.println("The new array would be: ");

        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();

    }
}
