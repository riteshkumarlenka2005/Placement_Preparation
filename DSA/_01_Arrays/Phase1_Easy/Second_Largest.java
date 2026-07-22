package DSA._01_Arrays.Phase1_Easy;
import java.util.*;

public class Second_Largest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        if(size<=0){
            System.out.println("Please enter a valid possitive size:");
            sc.close();
            return;
        }

        int arr[] = new int[size];
        System.out.println("Enter "+size+" elements into the array:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();

        }

        int largest = 0;
        int s_largest = 0;

        if(arr[0]>arr[1]){
            largest=arr[0];
            s_largest=arr[1];
        }else{
            largest=arr[1];
            s_largest=arr[0];
        }

        for(int i=2;i<size;i++){
            if(arr[i]>largest){
                s_largest=largest;
                largest=arr[i];
            }
            else if(arr[i]>s_largest){
                s_largest=arr[i];
            }
        }




// ---------------------  Another Approach  --------------------


        // int largest=arr[0];
        // int s_largest=-1;

        // for(int i=1;i<size;i++){
        //     if(arr[i]>largest){
        //         s_largest=largest;
        //         largest=arr[i];
        //     }
        //     else if(arr[i]<largest && arr[i]>s_largest){
        //         s_largest=arr[i];
        //     }

        // }




        System.out.println("The second largest element is "+s_largest);

        sc.close();


    }
}




