package DSA._01_Arrays;
import java.util.*;
public class Largest_Element {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Please enter a valid positive size.");
            sc.close();
            return;
        }

        int arr[] = new int[size];

        System.out.println("Enter " + size + " elements: ");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();

        }

        int largest = arr[0];
        for(int i=0;i<size;i++){
            if(largest<arr[i]){
                largest = arr[i];
            }

        }
        System.out.println("The largest element is "+largest);

        sc.close();

    }
    
}
