package DSA._01_Arrays;
import java.util.*;


public class LeftRotate_by_1_position_Left {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int arr[] =new int[size];
         System.out.println("Enter the elements into the array:");
         for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
         }

         //rotate the array by 1 element left
         int temp=arr[0];

         for(int i=0;i<size-1;i++){
            arr[i] = arr[i+1];
         }
         arr[size-1]=temp;

         System.out.println("After 1 rotation left the array is:");
         for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
         }


        sc.close();
    }
}
