package DSA._01_Arrays.Phase1_Easy;

import java.util.*;

public class Smallest_Element {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");

        

        int size = sc.nextInt();
        
        if(size<=0){
            System.out.println("Please enter a valid positive size.");
            sc.close();
            return;
        }

        
        int arr[] = new int[size];

        System.out.println("Enter "+size+" elements:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int smallest = arr[0];
        for(int i=0;i<size;i++){
            if(smallest>arr[i]){
                smallest=arr[i];
            }
        }

        System.out.println("Smallest element is "+smallest);


        sc.close();

    }
}
