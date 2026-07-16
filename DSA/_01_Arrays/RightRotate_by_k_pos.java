package DSA._01_Arrays;
import java.util.*;


public class RightRotate_by_k_pos {

    public static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements into that array:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Enter the number that how much element you want to rotate:");
        int num=sc.nextInt();
        num=num%size;

        reverse(arr, 0, size-num-1);
        reverse(arr, size-num, size-1);
        reverse(arr, 0, size-1);

        System.out.println("After right rotation the array would be:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }


        sc.close();
    }
}
