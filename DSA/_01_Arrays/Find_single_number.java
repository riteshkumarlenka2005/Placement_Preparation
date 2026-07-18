package DSA._01_Arrays;
import java.util.*;


// Find the single number (every element appears more than once except one)----- this is Brute Force Approach (nested loop)------ TC: O(n^2)

// public class Find_single_number {

//     public static int counting(int arr[], int n){

//         for(int i=0;i<n;i++){
//             int count=0;
//             for(int j=0;j<n;j++){
//                 if(arr[i]==arr[j]){
//                     count++;
//                 }
//             }

//             if(count==1){
//                 return arr[i];
//             }
            
//         }   

//         return -1;
//     }
//     public static void main(String[] args){
//     Scanner sc=new Scanner(System.in);
//     System.out.println("Enter the size of the number:");
//     int size=sc.nextInt();
    
//     int arr[]= new int[size];
//     System.out.println("Enter the elements into the array:");
//     for(int i=0;i<size;i++){
//         arr[i]=sc.nextInt();
//     }
    
//     int value = counting(arr,size);
//     System.out.println(value);

//     sc.close();
//     }
    
// }



// ----------------- Using HashMap concept ------------------ TC: O(n)

public class Find_single_number {
    public static int find_single_number(int arr[], int n){
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int frequency=map.get(arr[i]);
                map.put(arr[i],frequency+1);
            }else{
                map.put(arr[i],1);
            }
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }

        return -1;

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size=sc.nextInt();

        int arr[]=new int[size];
        System.out.println("Enter the elements into that array :");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

// ----------------------------------------------------------------------------------------------------------

        // Find the single number (every element appears twice except one)  XOR 

        // int xor=0;
        // for(int i=0;i<size;i++){
        //     xor = xor ^ arr[i];
        // }
        // System.out.println("the single number is: "+xor);

// ----------------------------------------------------------------------------------------------------

        int answer = find_single_number(arr, size);
        System.out.println("the single number is: "+answer);


        sc.close();
    }  
}








