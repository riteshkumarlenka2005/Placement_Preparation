package DSA._01_Arrays.Phase1_Easy;
import java.util.*;

public class Reverse_Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        System.out.println("Enter the elements into the array:");
        int arr[] = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = size-1;

        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }

        System.out.println("After reversed the array is:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");

        }

        sc.close();

    }
}
