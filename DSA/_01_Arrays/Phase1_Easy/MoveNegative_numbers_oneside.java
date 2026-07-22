package DSA._01_Arrays.Phase1_Easy;
import java.util.*;


public class MoveNegative_numbers_oneside {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size=sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements into the array:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int j=0;
        for(int i=0;i<size;i++){
            if(arr[i]<0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                j++;
            }
        }

        System.out.println("After moving one side the array would be:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();

    }
    
}
