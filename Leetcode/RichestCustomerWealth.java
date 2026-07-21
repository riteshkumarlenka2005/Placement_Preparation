package Leetcode;

import java.util.*;

public class RichestCustomerWealth {

    public static int findMaxWealth(int arr[][], int r,int c){
        int maxWealth=0;

        for(int i=0;i<r;i++){
            int wealth = 0;         
            for(int j=0;j<c;j++){
                wealth += arr[i][j];
            }
            maxWealth = Math.max(maxWealth, wealth);
            
        }
        return maxWealth;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row size of the array: ");
        int rsize= sc.nextInt();
        System.out.println("Enter the column size of the array: ");
        int csize= sc.nextInt();
        
        int arr[][]=new int[rsize][csize];
        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<rsize;i++){
            for(int j=0;j<csize;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int result=findMaxWealth(arr,rsize,csize);
        System.out.println("The maximum wealth is "+result);

        sc.close();

    }
}
