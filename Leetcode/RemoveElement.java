package Leetcode;

import java.util.Scanner;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
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

         System.out.println("Enter the element to remove : ");
        int element= sc.nextInt();


        int result= removeElement(arr,element);

        System.out.print(result + ", ");
        

        sc.close();

    }
}
