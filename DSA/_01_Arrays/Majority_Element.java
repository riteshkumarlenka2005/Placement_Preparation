package DSA._01_Arrays;
import java.util.*;



// ------------- Brute Force approach -----------

// public class Majority_Element {
//     public static int frequencyCount(int arr[], int n){
//         for(int i=0;i<n;i++){
//             int frequency=0;
//             for(int j=0;j<n;j++){
//                 if(arr[i]==arr[j]){
//                     frequency++;
//                 }

//             }
//             if(frequency>n/2){
//                 return arr[i];
//             }
//         }
//         return -1;

//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the size of the array: ");
//         int size= sc.nextInt();
        
//         int arr[]=new int[size];
//         System.out.println("Enter the elements into the array: ");
//         for(int i=0;i<size;i++){
//             arr[i] = sc.nextInt();
//         }

//         int result=frequencyCount(arr, size);

//         System.out.println("The number that appears more than size/2 times is "+result);
        
//     sc.close();

//     }
// }


// ------ Better approach HashMap Concept ------------

public class Majority_Element {
        public static int majorityElement(int arr[], int n){
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i=0;i<n;i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i])+1);
                }else{
                    map.put(arr[i], 1);
                }
            }

            for(Map.Entry<Integer, Integer> entry:map.entrySet()){
                if(entry.getValue()>n/2){
                    return entry.getKey();
                }
            }

            return -1;
        }
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size= sc.nextInt();
        
        int arr[]=new int[size];
        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        
        int result=majorityElement(arr, size);
        System.out.println("The number that appears more than size/2 times is "+result);
        
        
    sc.close();

    }
}