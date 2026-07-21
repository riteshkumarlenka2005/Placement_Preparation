package DSA._01_Arrays;

import java.util.*;

public class Intersection_of_2_Arrays {
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

        int i=0;
        int j=0;

        ArrayList<Integer> list = new ArrayList<>();

        while(i<size1 && j<size2){
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                
                if(list.isEmpty() || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        System.out.println("After Intersection the Array would be:");
        for(int value : list){
            System.out.print(value+" ");
        }
       


        sc.close();
    }
}
