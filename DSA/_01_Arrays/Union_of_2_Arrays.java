package DSA._01_Arrays;
import java.util.*;



// Brute force Approacr, Concatenate + HashMap + store in ArrayList + Sort 

// public class Union_of_2_Arrays {


//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter the size of the 1st array: ");
//         int size1 = sc.nextInt();

//         int arr1[] = new int[size1];

//         System.out.println("Enter the elements into the 1st array:");
//         for (int i = 0; i < size1; i++) {
//             arr1[i] = sc.nextInt();
//         }

//         System.out.print("Enter the size of the 2nd array: ");
//         int size2 = sc.nextInt();

//         int arr2[] = new int[size2];

//         System.out.println("Enter the elements into the 2nd array:");
//         for (int i = 0; i < size2; i++) {
//             arr2[i] = sc.nextInt();
//         }

//         // Create third array
//         int size3 = size1 + size2;
//         int arr3[] = new int[size3];

//         // Copy first array
//         for (int i = 0; i < size1; i++) {
//             arr3[i] = arr1[i];
//         }

//         // Copy second array
//         for (int i = size1, j = 0; i < size3; i++, j++) {
//             arr3[i] = arr2[j];
//         }


//         System.out.println("After concatenation the array would be :");

//         for (int i = 0; i < size3; i++) {
//             System.out.print(arr3[i] + " ");
//         }

// // -------------- Create hashmap-------------

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i=0;i<size3;i++){
//             if(map.containsKey(arr3[i])){
//                 int frequency=map.get(arr3[i]);
//                 map.put(arr3[i], frequency+1);
//             }else{
//                 map.put(arr3[i], 1);
//             }
//         }
//  // Store unique keys into an ArrayList
//         ArrayList<Integer> union = new ArrayList<>();
//         for(int key:map.keySet()){
//             union.add(key);
//         }
// // sort 
//         Collections.sort(union);
//         System.out.println("\n\nUnion of two arrays:");

//         for (int value : union) {
//             System.out.print(value + " ");
//         }

//         sc.close();
//     }
// }



// Using HashSet + ArrayList + Sort ----------- Brute Force -------------

// public class Union_of_2_Arrays {


//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the size of the 1st array: ");
//         int size1 = sc.nextInt();

//         int arr1[] = new int[size1];

//         System.out.println("Enter the elements into the 1st array:");
//         for (int i = 0; i < size1; i++) {
//             arr1[i] = sc.nextInt();
//         }

//         System.out.println("Enter the size of the 2nd array: ");
//         int size2 = sc.nextInt();

//         int arr2[] = new int[size2];

//         System.out.println("Enter the elements into the 2nd array:");
//         for (int i = 0; i < size2; i++) {
//             arr2[i] = sc.nextInt();
//         }

//         // Creation of HasSet 
//         HashSet<Integer> set = new HashSet<>();

//         for(int i=0;i<size1;i++){
//             set.add(arr1[i]);
//         }

//         for(int i=0;i<size2;i++){
//             set.add(arr2[i]);
//         }

//         // Create ArrayList
//         ArrayList<Integer> list = new ArrayList<>();

//         for(int values:set){
//             list.add(values);
//         }

//         Collections.sort(list);

//         for(int value:list){
//             System.out.print(value+" ");
//         }


//         sc.close();
//     }
// }




// Optimized Approach -----  Two Pointer Approach  -----


public class Union_of_2_Arrays {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the 1st array: ");
        int size1 = sc.nextInt();

        int arr1[] = new int[size1];

        System.out.println("Enter the elements into the 1st array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of the 2nd array: ");
        int size2 = sc.nextInt();

        int arr2[] = new int[size2];

        System.out.println("Enter the elements into the 2nd array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

    // Create ArrayList ------
        int i=0;
        int j=0;

        ArrayList<Integer> list = new ArrayList<>();

        while(i<size1 && j<size2){
            if(arr1[i]<arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }
            else if(arr1[i]>arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1)!=arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
            else if(arr1[i]==arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
                j++;

            }

        }

        while(i<size1){
            list.add(arr1[i]);
            i++;
        }

        while(j<size2){
            list.add(arr2[j]);
            j++;
        }

        System.out.println("After Union the Array would be:");
        for(int value : list){
            System.out.print(value+" ");
        }

        sc.close();
    }
}


