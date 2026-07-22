package DSA._01_Arrays.Phase1_Easy;
import java.util.*;

public class Max_Consecutive_ones {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements into that array:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int count=0;
        int maxCount=0;

        for(int i=0;i<size;i++){
            
            if(arr[i] == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count = 0;
            }
            
        }

        System.out.println("The max Consecutive ones is "+maxCount);


        sc.close();
    }
}
