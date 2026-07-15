package DSA._01_Arrays;
import java.util.*;

public class Linear_Search {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size=sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter "+size+" elements into the array:");

        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element to search:");
        int element=sc.nextInt();
        boolean isFound=false;
        for(int i=0;i<size;i++){
            if(arr[i]==element){
                System.out.println("The element found at index "+i);
                isFound=true;
            }
        }
        if(!isFound){
            System.out.println("Element not found ");
        }
    
    
        sc.close();

    }
}
