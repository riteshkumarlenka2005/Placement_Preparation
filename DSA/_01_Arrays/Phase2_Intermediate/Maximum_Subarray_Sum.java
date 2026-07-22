package DSA._01_Arrays.Phase2_Intermediate;

import java.util.*;


// ----------------------- Brute Force Approach -----------------
public class Maximum_Subarray_Sum {

    public static int maxSubarraySum(int arr[]){

        // -------------- example ---- [1,-2,3,10,-4,7,2,-5]
        int maxSum=arr[0];
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum = sum + arr[k];
                    
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
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

        int result = maxSubarraySum(arr);
        System.out.println("The Maximum SubArray Sum is "+result);


        sc.close();

    }
}
