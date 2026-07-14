package DSA._01_Arrays;
import java.util.*;

public class Check_Array_sorted_rotated {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int count =0;
        System.out.println("Enter the elements into the array:");
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<size;i++){
            if(arr[i]>(arr[(i+1)%size])){
                count++;
            }
        }

        if(count == 1){
            System.out.println("The array is sorted and rotated.");
        }else{
            System.out.println("The array is not sorted and rotated.");
        }


        sc.close();
    }
}
