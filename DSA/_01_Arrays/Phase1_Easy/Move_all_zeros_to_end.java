package DSA._01_Arrays.Phase1_Easy;
import java.util.*;


//---------Approach-1 : Using extra another array { time complexity- O(n)}--------- this is Brute Force :


// public class Move_all_zeros_to_end {
//     public static void main(String[] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("Enter the size of the array:");
//         int size= sc.nextInt();

//         int arr[]=new int[size];
//         System.out.println("Enter the elements into the array:");
//         for(int i=0;i<size;i++){
//             arr[i]=sc.nextInt();
//         }

//         int arr2[]=new int[size];
//         int j=0;
//         // System.out.println("Move all zeros to end:");
//         for(int i=0;i<size;i++){
//             if(arr[i]!=0){
//                 arr2[j]=arr[i];
//                 j++;
//             }
//         }
//         for(int i=j;i<size;i++){
//             arr2[i]=0;
//         }
//         System.out.println("After move all zeros the array would be:");
//         for(int i=0;i<size;i++){
//             System.out.print(arr2[i]+" ");
//         }
//         sc.close();
//     }
// }






public class Move_all_zeros_to_end {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size= sc.nextInt();

        int arr[]=new int[size];
        System.out.println("Enter the elements into the array:");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }


//----------------- Approach-2 : Optimal two pointer Overwrite Technique { time complexity- O(n)}----  This is Optimal

        
        int j=0;
        for(int i=0;i<size;i++){
            if(arr[i]!=0){
                arr[j]=arr[i];
                j++;
            }
        }
       
        for(int i=j;i<size;i++){
            arr[i]=0;
        }


//----------------- Approach-3 : Optimal two pointer swapping Technique { time complexity- O(n)}----  This is Optimal


        // int j=0;

        // for(int i=0;i<size;i++){
        //     if(arr[i]!=0){
        //         int temp =arr[i];
        //         arr[i]=arr[j];
        //         arr[j]=temp;

        //         j++;
        //     }
        // }
        // for(int i=j;i<size;i++){
        //     arr[i]=0;
        // }



//----------------- Approach-3 : Bubble-like Adjacent Swapping Technique { time complexity- O(n^2) }---- this is Inefficient 

// for (int i = 0; i < size - 1; i++) {

//     for (int j = 0; j < size - 1; j++) {

//         if (arr[j] == 0 && arr[j + 1] != 0) {

//             int temp = arr[j];
//             arr[j] = arr[j + 1];
//             arr[j + 1] = temp;

//         }

//     }

// }



        System.out.println("After move all zeros the array would be:");
        for(int i=0;i<size;i++){
              System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}


