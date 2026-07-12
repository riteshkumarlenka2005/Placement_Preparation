package DSA._01_Arrays;
import java.util.*;

public class Second_Smallest {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size=sc.nextInt();

        if(size<=0){
            System.out.println("Please enter a valid integer size:");
        }

        int arr[]=new int[size];
        System.out.println("Enter "+size+" elements into the array:");

        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int smallest=0;
        int s_smallest=0;

        if(arr[0]<arr[1]){
            smallest=arr[1];
            s_smallest=arr[0];
        }else{
            smallest=arr[0];
            s_smallest=arr[1];
        }

        for(int i=0;i<size;i++){
            if(arr[i]<smallest){
                s_smallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]<s_smallest){
                s_smallest=arr[i];
            }

        }

        System.out.println("The second smallest element is "+s_smallest);
    
        sc.close();
        
    }
}
