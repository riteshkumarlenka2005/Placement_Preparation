package DSA._01_Arrays;
import java.util.*;


// public class LeftRotate_by_k_pos_left {
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Enter the size of the array:");
//         int size = sc.nextInt();

//         int arr[] =new int[size];
//          System.out.println("Enter the elements into the array:");
//          for(int i=0;i<size;i++){
//             arr[i] = sc.nextInt();
//          }

//          System.out.println("Enter the number that how much element you want to rotate:");
//          int num=sc.nextInt();
//          num=num%size;
//          //rotate the array by k element left
//          for(int i=0;i<num;i++){
//             int temp=arr[0];

//             for(int j=0;j<size-1;j++){
//                 arr[j] = arr[j+1];
//             }
//             arr[size-1]=temp;
//          }
         

//          System.out.println("After left rotation the array would be:");
//          for(int i=0;i<size;i++){
//             System.out.print(arr[i]+" ");
//          }

//         sc.close();
//     }
// }



// Another approach Using Reversal Algorithm 

// First reverse upto the element , that how many element you want to rotate 
// Then again reverse the rest elements or right side part 
// Then reverse the complete array


public class LeftRotate_by_k_pos_left {

    public static void reverse(int arr[] , int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int arr[] =new int[size];
         System.out.println("Enter the elements into the array:");
         for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
         }

         System.out.println("Enter the number that how much element you want to rotate:");
         int num=sc.nextInt();
         num=num%size;

         reverse(arr, 0, num-1);
         reverse(arr, num, size-1);
         reverse(arr, 0, size-1);

         System.out.println("After left rotation the array would be:");
         for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
         }

        sc.close();
    }
}

 